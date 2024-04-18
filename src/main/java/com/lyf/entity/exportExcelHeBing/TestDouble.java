package com.lyf.entity.exportExcelHeBing;

import lombok.Data;

/**
 * @program: codepractice
 * @description:
 * @author: 刘耀福
 * @create: 2024-04-17 15:15
 **/
@Data
public class TestDouble {
    private int id;
    private String name;
    //方式1
    private String score;

    //方式二
   /* private Double score;
    private String scoreStr;*/

    private String subject;

}
