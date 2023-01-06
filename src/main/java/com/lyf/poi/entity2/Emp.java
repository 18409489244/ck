package com.lyf.poi.entity2;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class Emp {

    @ExcelProperty("编号")
    private String id;

    @ExcelProperty("姓名")
    private String name;

    @ExcelProperty("年龄")
    private int age;

    @ExcelProperty(value = "生日", format = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;

    @ExcelProperty("状态")
    private String status;


}
