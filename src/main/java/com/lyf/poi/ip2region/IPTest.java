package com.lyf.poi.ip2region;

/**
 * @program: codepractice
 * @description: 测试
 * @author: 刘耀福
 * @create: 2023-09-26 16:56
 **/

import java.util.List;

public class IPTest {
    public static void main(String[] args) {
        //只获取省,市
        int[] index = {2, 3};
        List<String> parse = IpParseUtil.parse("222.223.145.133", index);
        System.out.println(parse.get(0));
        System.out.println(parse.get(1));
    }
}
