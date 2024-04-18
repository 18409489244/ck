package com.lyf.controller.exportExcelHeBing;
import com.lyf.entity.exportExcelHeBing.ExportExcelUtils;
import com.lyf.entity.exportExcelHeBing.ReportDtoExport;
import com.lyf.service.exportExcelHeBing.ExportExcelMergeService;
import com.lyf.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedList;
import java.util.Map;

/**
 * @program: codepractice
 * @description:
 * @create: 2024-04-12 10:10
 **/
@Slf4j
@RestController
public class ExportExcelMergeController {

    @Autowired
    private ExportExcelMergeService exportExcelMergeService;

    /**
     * 动态excel导出功能
     * @param response
     * @return
     * @throws Exception
     */
    @GetMapping("/exportExcelMerge")
    public R exportExcelMerge(HttpServletResponse response) throws Exception {
        Map<String,LinkedList<ReportDtoExport>> resultMap = exportExcelMergeService.exportExcelMerge();

        ExportExcelUtils.exportExcelAll(response,resultMap);
        return R.ok();
    }
}
