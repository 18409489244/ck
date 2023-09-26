package com.lyf.poi.EasyExcel.练习2;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EasyExcelTest {

    //生成的文件路径
    static String PATH = "C:\\me\\tempfile";

    public static List<DemoData> getDataList() {
        List<DemoData> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DemoData demoData = new DemoData();
            demoData.setName("张三" + i);
            demoData.setAge(i);
            demoData.setBirthday(new Date());
            demoData.setSalary(0.56);
            list.add(demoData);

        }
        return list;
    }

    /**
     *
     */
    // 根据list 写入excel
    public static void simpleWrite(List<DemoData> dataList) {
        // 写法1
        String fileName = PATH + "EasyTest.xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // write (fileName, 格式类)
        // sheet (表明)
        // doWrite (数据)
        EasyExcel.write(fileName, DemoData.class).sheet("模板").doWrite(dataList);
    }


    /**
     * 读取
     */
    public static void simpleRead() {
        // 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
        // 写法1：
        String fileName = PATH + "EasyTest.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭

        // 重点注意读取的逻辑 DemoDataListener
        EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).sheet().doRead();
    }

    public static void main(String[] args) {
        //实体集合写数据到excel
        //simpleWrite(getDataList());
        //读取excel中数据到控制台
        simpleRead();

    }


}
