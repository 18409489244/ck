package com.lyf.service.impl.exportExcelHeBing;

import com.lyf.entity.exportExcelHeBing.ExportExcelMergeDto;
import com.lyf.entity.exportExcelHeBing.IndexDto;
import com.lyf.entity.exportExcelHeBing.ReportDtoExport;
import com.lyf.mapper.exportExcelHeBing.ExportExcelMergeMapper;
import com.lyf.service.exportExcelHeBing.ExportExcelMergeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: codepractice
 * @description:
 * @author: 刘耀福
 * @create: 2024-04-12 10:11
 **/
@Service
public class ExportExcelMergeServiceImpl implements ExportExcelMergeService {
    @Autowired
    private ExportExcelMergeMapper exportExcelMergeMapper;
    @Override
    public Map<String,LinkedList<ReportDtoExport>> exportExcelMerge() {
        //默认权重包下所有一级层级
        String  weightPackageId = "975834663312719872";
        List<IndexDto> oneLevelList = exportExcelMergeMapper.getOneLevel(weightPackageId);

        Map<String,LinkedList<ReportDtoExport>> resulMap = new HashMap<>();
        oneLevelList.forEach(oneLevel->{
            List<ExportExcelMergeDto> exportExcelMergeDtoList = exportExcelMergeMapper.exportExcelMerge(weightPackageId,oneLevel.getIndexId());
            List<IndexDto> indexDtos = exportExcelMergeDtoList.stream().map(item -> {
                IndexDto indexDto = new IndexDto();
                indexDto.setIndexId(item.getIndexId());
                indexDto.setIndexName(item.getIndexName());
                return indexDto;
            }).collect(Collectors.toList());

            LinkedList<ReportDtoExport> linkedList = new LinkedList<>();
            Map<String, List<ExportExcelMergeDto>> exportExcelMergeDtoListMap = exportExcelMergeDtoList.stream().collect(Collectors.groupingBy(item -> item.getDeptName()));

            // 按List大小降序排序
            exportExcelMergeDtoListMap = new LinkedHashMap<>(exportExcelMergeDtoListMap.entrySet().stream()
                            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue(Comparator.comparingInt(List::size))))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new)));

            exportExcelMergeDtoListMap.values().stream().forEach(exportExcelMergeDtos -> {
                Map<String, List<ExportExcelMergeDto>> mapTemp = exportExcelMergeDtos.stream().collect(Collectors.groupingBy(u -> u.getIndexId()));
                LinkedHashMap<String, Object> stateMap = new LinkedHashMap<>();
                indexDtos.forEach(indexDto->{
                    List<ExportExcelMergeDto> listTemp = mapTemp.getOrDefault(indexDto.getIndexId(),null);
                    if(listTemp != null) {
                        stateMap.put(indexDto.getIndexId() + "_" + indexDto.getIndexName(), listTemp.get(0).getIndexScore());
                        stateMap.put(indexDto.getIndexId() + "_" + "分值",listTemp.get(0).getIndexScoreProv());
                    }else{
                        stateMap.put(indexDto.getIndexId() + "_" + indexDto.getIndexName(), "/");
                        stateMap.put(indexDto.getIndexId() + "_" + "分值","/");
                    }
                });


                List<Double> indexScoreList = exportExcelMergeDtos.stream().map(item -> item.getIndexScore()).collect(Collectors.toList());
                Optional<Double> reduce = indexScoreList.stream().reduce(Double::sum);
                stateMap.put("合计",reduce.get());
                ReportDtoExport reportDtoExport = new ReportDtoExport();
                reportDtoExport.setNo(1);
                reportDtoExport.setDeptName(exportExcelMergeDtos.get(0).getDeptName());
                reportDtoExport.setMap(stateMap);
                linkedList.add(reportDtoExport);
                resulMap.put("打印宽表-"+oneLevel.getIndexName(),linkedList);
            });
        });


        return resulMap;
    }


//    @Override
//    public Map<String,LinkedList<ReportDtoExport>> exportExcelMerge() {
//        //默认权重包下所有一级层级
//        String  weightPackageId = "975834663312719872";
//        List<IndexDto> oneLevelList = exportExcelMergeMapper.getOneLevel(weightPackageId);
//
//        Map<String,LinkedList<ReportDtoExport>> resulMap = new HashMap<>();
//        oneLevelList.forEach(oneLevel->{
//            LinkedList<ExportExcelMergeDto> exportExcelMergeDtoList = exportExcelMergeMapper.exportExcelMerge(weightPackageId,oneLevel.getIndexId());
//            List<IndexDto> indexDtos = exportExcelMergeDtoList.stream().map(item -> {
//                IndexDto indexDto = new IndexDto();
//                indexDto.setIndexId(item.getIndexId());
//                indexDto.setIndexName(item.getIndexName());
//                return indexDto;
//            }).distinct().collect(Collectors.toList());
//
//            LinkedList<ReportDtoExport> linkedList = new LinkedList<>();
//
//            Map<String, List<ExportExcelMergeDto>> exportExcelMergeDtoListMap = exportExcelMergeDtoList.stream().collect(Collectors.groupingBy(item -> item.getDeptName()));
//
//            // 按List大小降序排序
//            exportExcelMergeDtoListMap = new LinkedHashMap<>(exportExcelMergeDtoListMap.entrySet().stream()
//                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue(Comparator.comparingInt(List::size))))
//                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new)));
//
//
//            exportExcelMergeDtoListMap.values().stream().forEach(exportExcelMergeDtos -> {
//                Map<String, List<ExportExcelMergeDto>> mapTemp = exportExcelMergeDtos.stream().collect(Collectors.groupingBy(u -> u.getIndexId()));
//                LinkedHashMap<String, Object> stateMap = new LinkedHashMap<>();
//
//                indexDtos.forEach(indexDto->{
//                    List<ExportExcelMergeDto> listTemp = mapTemp.getOrDefault(indexDto.getIndexId(),null);
//                    if(listTemp != null) {
//                        stateMap.put(indexDto.getIndexId() + "_" + indexDto.getIndexName()+ "分值("+listTemp.get(0).getIndexScore()+")", listTemp.get(0).getIndexScore());
//                    }else{
//                        stateMap.put(indexDto.getIndexId() + "_" + indexDto.getIndexName(), "/");
//                    }
//                });
//
//                List<Double> indexScoreList = exportExcelMergeDtos.stream().map(item -> item.getIndexScore()).collect(Collectors.toList());
//                Optional<Double> reduce = indexScoreList.stream().reduce(Double::sum);
//                stateMap.put("合计",reduce.get());
//                ReportDtoExport reportDtoExport = new ReportDtoExport();
//                reportDtoExport.setNo(1);
//                reportDtoExport.setDeptName(exportExcelMergeDtos.get(0).getDeptName());
//                reportDtoExport.setMap(stateMap);
//                linkedList.add(reportDtoExport);
//                resulMap.put("打印宽表-"+oneLevel.getIndexName(),linkedList);
//            });
//        });
//
//
//        return resulMap;
//    }
}
