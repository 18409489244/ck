package com.lyf.entity.exportExcelHeBing;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.*;

public class ExportExcelUtils {
    /**
     * 表头字体大小
     */
    private static String headerFontSize = "13";
    /**
     * 表头字体样式
     */
    private static String headerFontName = FontStyle.MicrosoftYahei.name;
    /**
     * 数据字体大小
     */
    private static String otherFontSize = "10";
    /**
     * 数据字体样式
     */
    private static String otherFontName = FontStyle.MicrosoftYahei.name;
    /**
     * 单元格宽度
     */
    private static Integer width = 30;
    /**
     * sheet的名字
     */
    private static String sheetName = "sheetName";
    /**
     * 是否开启表头样式,默认为true,开启
     */
    private static Boolean isOpeanHeaderStyle = true;
    /**
     * ##############是否开始其他数据样式,默认为false,关闭(不建议开启,数据量大时影响性能)################
     */
    private static Boolean isOpeanOtherStyle = false;


    /**
     * @param resultMap
     * @description 导出全部数据
     */
    public static void exportExcelAll(HttpServletResponse response, Map<String,LinkedList<ReportDtoExport>> resultMap) throws IOException {
        // 创建一个工作簿
        XSSFWorkbook wb = new XSSFWorkbook();
        resultMap.entrySet().forEach(sheetMap->{
            String sheet = sheetMap.getKey();
            LinkedList<ReportDtoExport> list = sheetMap.getValue();


            // 创建一个sheet
            XSSFSheet sh = wb.createSheet(sheet);
            // 创建Excel工作表第一行,设置表头信息
            XSSFRow row0 = sh.createRow(0);
            //处理表头
            String[] startKeys = {"序号", "部门"};
            ReportDtoExport reportDtoExport = list.get(0);
            LinkedHashMap<String, Object> map = reportDtoExport.getMap();
            Set<String> titleSet = map.keySet();
            String[] endsKeysss = titleSet.toArray(new String[titleSet.size()]);
            String[] endsKeys = new String[endsKeysss.length];
            for(int m = 0; m<endsKeysss.length;m++){
                if("合计".equals(endsKeysss[m])){
                    endsKeys[m] = endsKeysss[m];
                }else{
                    endsKeys[m] = endsKeysss[m].split("_")[1];
                }
            }

            String[] resultKeys = new String[startKeys.length + endsKeys.length];
            for (int x = 0; x < startKeys.length; x++) {
                resultKeys[x] = startKeys[x];
            }
            for (int y = 0; y < endsKeys.length; y++) {
                resultKeys[startKeys.length + y] = endsKeys[y];
            }
            //表头
            for (int i = 0; i < resultKeys.length; i++) {
                // 设置单元格宽度
                sh.setColumnWidth(i, 256 * width + 184);
                XSSFCell cell = row0.createCell(i);
                cell.setCellValue(resultKeys[i]);
                //设置样式
                // 是否开启表头样式
                if (isOpeanHeaderStyle) {
                    // 创建表头样式
                    XSSFCellStyle headerStyle = setCellStyle(wb, headerFontSize, headerFontName, "header");
                    cell.setCellStyle(headerStyle);
                }
            }
            //内容
            for (int i = 0; i < list.size(); i++) {
                // 循环创建行
                XSSFRow row = sh.createRow(i+1);
                //获取每一个对象
                ReportDtoExport reportDtoDomain = list.get(i);
                //设置固定的值数组
                String[] startContent = new String[2];
                startContent[0]= String.valueOf(reportDtoDomain.getNo());
                startContent[1]=reportDtoDomain.getDeptName();
                //获取每一个对象里面的articleMap对象
                LinkedHashMap<String, Object> contentArticleMap = reportDtoDomain.getMap();

                //获取articleMap里面的values
                Collection<Object> values = contentArticleMap.values();
                //将values转为后面拼接的动态数组
                String[] endContent =new String[values.size()];
                int index=0;
                for (Object value : values) {
                    endContent[index] = String.valueOf(value);
                    index++;
                }

                //开始拼接数组内容、一行一行输出
                String[] resultContent = new String[startContent.length+endContent.length];
                for(int ii=0;ii<startContent.length;ii++){
                    resultContent[ii]=startContent[ii];
                }
                for (int jj =0;jj<endContent.length;jj++){
                    resultContent[startContent.length+jj]=endContent[jj];
                }
                // 给行的每列写入数据
                for (int j = 0; j < resultContent.length; j++) {
                    XSSFCell cell = row.createCell(j);
                    cell.setCellValue(resultContent[j]);
                }
            }
        });

        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("数据统计2022-05-29.xlsx", "UTF-8"));
        //这个操作也非常的耗时,暂时不知道和什么有关,应该该和文件的大小有关
        wb.write(response.getOutputStream());
    }



    /**
     * @param wb       工作簿
     * @param fontSize 字体大小
     * @param fontName 字体名称
     * @return 工作簿样式
     * @description 设置Excel样式
     */
    private static XSSFCellStyle setCellStyle(XSSFWorkbook wb, String fontSize, String fontName, String boo) {
        // 创建自定义样式类
        XSSFCellStyle style = wb.createCellStyle();
        // 创建自定义字体类
        XSSFFont font = wb.createFont();
        // 设置字体样式
        font.setFontName(fontName);
        // 设置字体大小
        font.setFontHeightInPoints(Short.parseShort(fontSize));
        // 我这个版本的POI没找到网上的HSSFCellStyle
        // 设置对齐方式
        style.setAlignment(HorizontalAlignment.CENTER);
        // 数据内容设置边框实在太丑,容易看瞎眼睛,我帮你们去掉了
        if ("header".equals(boo)) {
            // 设置边框
            style.setBorderBottom(BorderStyle.MEDIUM);
            style.setBorderLeft(BorderStyle.MEDIUM);
            style.setBorderRight(BorderStyle.MEDIUM);
            style.setBorderTop(BorderStyle.MEDIUM);
            // 表头字体加粗
            font.setBold(true);
        }
        style.setFont(font);
        return style;
    }


    /**
     * 找了半天也没找到可以diy的类,我自己写个吧
     */
    enum FontStyle {
        // 微软雅黑
        MicrosoftYahei("微软雅黑"),
        // 宋体
        TimesNewRoman("宋体"),
        // 楷体
        Italics("楷体"),
        // 幼圆
        YoungRound("幼圆");

        private String name;

        FontStyle(String name) {
            this.name = name;
        }
    }

}
