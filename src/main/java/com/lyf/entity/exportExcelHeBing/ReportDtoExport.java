package com.lyf.entity.exportExcelHeBing;
import lombok.Data;
import java.util.LinkedHashMap;

@Data
public class ReportDtoExport {
    private Integer no;
    private String deptName;
    private LinkedHashMap<String, Object> map;
}
