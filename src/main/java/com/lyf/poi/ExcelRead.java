package com.lyf.poi;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class ExcelRead {
    //生成的文件路径
    static String PATH = "C:\\yd\\project\\poi\\";

    public static void testRead03() throws IOException {
        //获取文件流
        FileInputStream inputStream = new FileInputStream(PATH + "03版本测试写入.xls");
        //创建一个工作簿、03版本HSSFWorkbook
        Workbook workbook = new HSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);
        String stringCellValue = cell.getStringCellValue();
        System.out.println(stringCellValue);
        inputStream.close();

    }

    public static void testCellType() throws IOException {
        //获取文件流
        FileInputStream inputStream = new FileInputStream(PATH + "明细单.xlsx");
        //创建一个工作簿、03版本HSSFWorkbook
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        //获取标题内容
        Row rowTitle = sheet.getRow(0);
        if (rowTitle != null) {
            //获取一行的列总数
            int cellsCount = rowTitle.getPhysicalNumberOfCells();
            for (int cellNum = 0; cellNum < cellsCount; cellNum++) {
                Cell cell = rowTitle.getCell(cellNum);
                if (cell != null) {
                    //获取列的类型
                    int cellType = cell.getCellType();
                    String stringCellValue = cell.getStringCellValue();
                    System.out.print(stringCellValue + " | ");
                }
            }
        }
        System.out.println();
        //获取表中内容
        //获取除了标题行以外的行数据
        int rowCount = sheet.getPhysicalNumberOfRows();
        for (int rowNum = 1; rowNum < rowCount; rowNum++) {
            Row rowData = sheet.getRow(rowNum);
            if (rowData != null) {
                //读取列
                int cellCount = rowTitle.getPhysicalNumberOfCells();
                for (int cellNum = 0; cellNum < cellCount; cellNum++) {
                    System.out.print("[" + rowNum + "-" + cellNum + "]");
                    Cell cell = rowData.getCell(cellNum);
                    //匹配列的数据类型
                    if (cell != null) {
                        int cellType = cell.getCellType();
                        String cellValue = "";
                        switch (cellType) {
                            case HSSFCell.CELL_TYPE_STRING: //字符串类型
                                System.out.print("【String】");
                                cellValue = cell.getStringCellValue();
                                break;
                            case HSSFCell.CELL_TYPE_BOOLEAN: //布尔类型
                                System.out.print("【Boolean】");
                                cellValue = String.valueOf(cell.getBooleanCellValue());
                                break;
                            case HSSFCell.CELL_TYPE_BLANK: //空的
                                System.out.print("【BLANK】");
                                break;
                            case HSSFCell.CELL_TYPE_NUMERIC: //数字(日期、普通数字)
                                System.out.print("【NUMERIC】");
                                if (HSSFDateUtil.isCellDateFormatted(cell)) {//日期
                                    System.out.print("【日期】");
                                    Date date = cell.getDateCellValue();
                                    cellValue = new DateTime(date).toString("yyyy-MM-dd HH:mm:ss");
                                } else {
                                    //不是日期格式、防止数字过长
                                    System.out.print("【数字转为字符串输出】");
                                    cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                                    cellValue = cell.toString();
                                }
                                break;
                            case HSSFCell.CELL_TYPE_ERROR: //空的
                                System.out.print("【数据类型错误】");
                                break;
                        }
                        System.out.println(cellValue);
                    }
                }
            }
        }
        inputStream.close();
    }

    public static void main(String[] args) {
        try {
            testCellType();
            System.out.println();
            System.out.println("dev 提交");
            System.out.println("master 提交");
            System.out.println("dev 二次提交");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
