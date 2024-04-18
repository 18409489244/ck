package com.lyf.service.exportExcelHeBing;
import com.lyf.entity.exportExcelHeBing.ReportDtoExport;

import java.util.LinkedList;
import java.util.Map;

/**
 * @program: codepractice
 * @description:
 * @author: 刘耀福
 * @create: 2024-04-12 10:11
 **/
public interface ExportExcelMergeService {
    Map<String,LinkedList<ReportDtoExport>> exportExcelMerge();
}
