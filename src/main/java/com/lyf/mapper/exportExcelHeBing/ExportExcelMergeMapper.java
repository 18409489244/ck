package com.lyf.mapper.exportExcelHeBing;

import com.lyf.entity.exportExcelHeBing.ExportExcelMergeDto;
import com.lyf.entity.exportExcelHeBing.IndexDto;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: codepractice
 * @description:
 * @author: 刘耀福
 * @create: 2024-04-12 10:15
 **/
public interface ExportExcelMergeMapper {
    LinkedList<ExportExcelMergeDto> exportExcelMerge(@Param("weightPackageId") String weightPackageId,
                                                     @Param("oneLevelId") String oneLevelId);

    List<IndexDto> getOneLevel(@Param("weightPackageId") String weightPackageId);
}
