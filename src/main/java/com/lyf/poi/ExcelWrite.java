package com.lyf.poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWrite {
    //生成的文件路径
    static String PATH = "C:\\yd\\project\\poi\\";

    public static void testWrite03() throws IOException {
        //创建一个工作簿、03版本HSSFWorkbook
        Workbook workbook = new HSSFWorkbook();
        //创建一个工作表
        Sheet sheet = workbook.createSheet("第一个Sheet页");
        //创建一行、创建第一个行
        Row row1 = sheet.createRow(0);
        //创建列
        Cell cell11 = row1.createCell(0);
        //创建列并设置值
        cell11.setCellValue("今日新增观众");

        //创建列并设置值
        Cell cell12 = row1.createCell(1);
        cell12.setCellValue(666);


        //创建第二行
        Row row2 = sheet.createRow(1);
        //创建列并设置值
        Cell cell21 = row2.createCell(0);
        cell21.setCellValue("统计时间");
        //创建列并设置值
        Cell cell22 = row2.createCell(1);
        String s = new DateTime().toString("yyyy-MM-dd HH:mm:ss");
        cell22.setCellValue(s);

        //生成一张表（IO流） 03 版本使用xls 结尾
        FileOutputStream fileOutputStream = new FileOutputStream(PATH + "03版本测试写入.xls");
        //把工作簿通过流写出
        workbook.write(fileOutputStream);
        //关闭刘
        fileOutputStream.close();
        System.out.println("文件生成完毕");

    }

    public static void testWrite07() throws IOException {
        //创建一个工作簿、07版本HSSFWorkbook
        Workbook workbook = new XSSFWorkbook();
        //创建一个工作表
        Sheet sheet = workbook.createSheet("第一个Sheet页");
        //创建一行、创建第一个行
        Row row1 = sheet.createRow(0);
        //创建列
        Cell cell11 = row1.createCell(0);
        //创建列并设置值
        cell11.setCellValue("今日新增观众");

        //创建列并设置值
        Cell cell12 = row1.createCell(1);
        cell12.setCellValue(666);


        //创建第二行
        Row row2 = sheet.createRow(1);
        //创建列并设置值
        Cell cell21 = row2.createCell(0);
        cell21.setCellValue("统计时间");
        //创建列并设置值
        Cell cell22 = row2.createCell(1);
        String s = new DateTime().toString("yyyy-MM-dd HH:mm:ss");
        cell22.setCellValue(s);

        //生成一张表（IO流） 07 版本使用xlsx 结尾
        FileOutputStream fileOutputStream = new FileOutputStream(PATH + "07版本测试写入.xlsx");
        //把工作簿通过流写出
        workbook.write(fileOutputStream);
        //关闭刘
        fileOutputStream.close();
        System.out.println("文件生成完毕");

    }


    /**
     * 耗时比较短
     *
     * @throws IOException
     */
    public static void testWrite03BigData() throws IOException {
        long startTime = System.currentTimeMillis();
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("我的第一个sheet页");
        for (int rowNum = 0; rowNum < 65536; rowNum++) {
            Row row = sheet.createRow(rowNum);
            //每一行填10列
            for (int cellNum = 0; cellNum < 10; cellNum++) {
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum + "条");
            }
        }

        FileOutputStream fileOutputStream = new FileOutputStream(PATH + "03大数据流写入.xls");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) / 1000);

    }

    /**
     * 耗时比较旧 解决：优化、缓存
     *
     * @throws IOException
     */
    public static void testWrite07BigData() throws IOException {
        long startTime = System.currentTimeMillis();
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("我的第一个sheet页");
        for (int rowNum = 0; rowNum < 65536; rowNum++) {
            Row row = sheet.createRow(rowNum);
            //每一行填10列
            for (int cellNum = 0; cellNum < 10; cellNum++) {
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum + "条");
            }
        }
        FileOutputStream fileOutputStream = new FileOutputStream(PATH + "07大数据流写入.xls");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) / 1000);
    }


    /**
     * SXSSH 可以写非常大的数据量、 如100万条甚至更多条，写数据速度更快、占用更少的内存
     * 过程中会产生临时文件、需要清理临时文件、默认100条记录保存在内存中、如果超过这数量、则最前面的数据被写入临时文件
     * 如果想要自定义内存中的数量，可以使用new new SXSSFWorkbook(数量)
     *
     * @throws IOException
     */
    public static void testWrite07BigDataS() throws IOException {
        long startTime = System.currentTimeMillis();
        Workbook workbook = new SXSSFWorkbook();
        Sheet sheet = workbook.createSheet("我的第一个sheet页");
        for (int rowNum = 0; rowNum < 65536; rowNum++) {
            Row row = sheet.createRow(rowNum);
            //每一行填10列
            for (int cellNum = 0; cellNum < 10; cellNum++) {
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum + "条");
            }
        }
        FileOutputStream fileOutputStream = new FileOutputStream(PATH + "07-XSSF大数据流写入.xls");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        //关闭临时文件
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) / 1000);
    }

    public static void main(String[] args) {
        try {
            testWrite07BigDataS();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
