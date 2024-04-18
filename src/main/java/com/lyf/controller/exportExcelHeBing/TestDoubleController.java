package com.lyf.controller.exportExcelHeBing;

import com.lyf.entity.exportExcelHeBing.ExportExcelUtils;
import com.lyf.entity.exportExcelHeBing.ReportDtoExport;
import com.lyf.entity.exportExcelHeBing.TestDouble;
import com.lyf.service.exportExcelHeBing.TestDoubleService;
import com.lyf.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @program: codepractice
 * @description:
 * @author: 刘耀福
 * @create: 2024-04-17 15:00
 **/
@Slf4j
@RestController
public class TestDoubleController {
    @Autowired
    private TestDoubleService testDoubleService;


    @GetMapping("/testDouble")
    public R testDouble(){
        List<TestDouble> list =  testDoubleService.testDouble();
        //方式1
        List<TestDouble> isNotNullList = list.stream().filter(item -> Objects.nonNull(item.getScore())).collect(Collectors.toList());

        List<TestDouble> isNullList = list.stream().filter(item -> Objects.isNull(item.getScore())).collect(Collectors.toList());

        isNotNullList = isNotNullList.stream().sorted(Comparator.comparing(TestDouble::getScore,Comparator.comparingDouble(Double::parseDouble))).collect(Collectors.toList());
        isNotNullList.addAll(isNullList);



        //方式2
      /*  List<TestDouble> isNotNullList2 = list.stream().filter(item -> Objects.nonNull(item.getScore())).collect(Collectors.toList());

        List<TestDouble> isNullList2 = list.stream().filter(item -> Objects.isNull(item.getScore())).collect(Collectors.toList());

        isNotNullList2 = isNotNullList2.stream().sorted(Comparator.comparing(TestDouble::getScore)).collect(Collectors.toList());

        isNotNullList2.addAll(isNullList2);
        isNotNullList2.forEach(item->{
            item.setScoreStr(String.format("%.2f",item.getScore()));
        });*/
        return R.ok(isNotNullList);
    }


    public static void main(String[] args) {
        //一、使用BigDecimal的setScale方法
        double one11 = 92.00;
        double one112 = 92.236;
        BigDecimal two11 = new BigDecimal(one11);
        BigDecimal two12 = new BigDecimal(one112);
        double three11 = two11.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        double three12 = two12.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println("一、使用BigDecimal的setScale方法：" + three11);
        System.out.println("一、使用BigDecimal的setScale方法：" + three12);

        System.out.println("===========================");
        //二、使用Sting自带的format方法
        double one22 = 92.00;
        String  str22 = String.format("%.2f",one22);
        double four22 = Double.parseDouble(str22);
        System.out.println("二、使用Sting自带的format方法：" + four22);
        System.out.println("二、使用Sting自带的format方法：" + str22);

        System.out.println("===========================");
        //三、使用NumberFormat设置最大小数位数
        double d33 = 92.00;
        NumberFormat nf33 = NumberFormat.getNumberInstance();
        // 保留两位小数
        nf33.setMaximumFractionDigits(2);
        // 如果不需要四舍五入，可以使用RoundingMode.DOWN
        nf33.setRoundingMode(RoundingMode.UP);
        System.out.println("三、使用NumberFormat设置最大小数位数：" + nf33.format(d33));
        String format1 = nf33.format(d33);
        double v1 = Double.parseDouble(format1);
        System.out.println("三、使用NumberFormat设置最大小数位数：" + v1);

        System.out.println("===========================");
        //四、使用DecimalFormat，#.00为保留两位小数
        double f44 = 92.00;
        DecimalFormat df44 = new DecimalFormat("#.00");
        System.out.println("四、使用DecimalFormat，#.00为保留两位小数：" + df44.format(f44));
        String format = df44.format(f44);
        double v = Double.parseDouble(format);
        System.out.println("四、使用DecimalFormat，#.00为保留两位小数：" + v);

    }
}


