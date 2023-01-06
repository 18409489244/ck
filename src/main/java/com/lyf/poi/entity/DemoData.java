package com.lyf.poi.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class DemoData {

    @ExcelProperty("姓名")
    private String name;

    @ExcelProperty("生日")
    private Date birthday;

    @ExcelProperty("工资")
    private Double salary;

    @ExcelIgnore
    private int age;
}
