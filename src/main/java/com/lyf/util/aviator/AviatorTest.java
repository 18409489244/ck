package com.lyf.util.aviator;

import com.googlecode.aviator.AviatorEvaluator;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: codepractice
 * @description: 计算
 * @author: 刘耀福
 * @create: 2023-09-26 17:05
 **/
public class AviatorTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    /**
     * 算数表达式
     */
    public static void test1() {
        Long sum = (Long) AviatorEvaluator.execute("1 + 2 + 3");
        System.out.println(sum);
    }


    /**
     * 逻辑表达式
     */
    public static void test2() {
        Boolean result = (Boolean) AviatorEvaluator.execute("3 > 1 && 2 != 4 || true");
        System.out.println(result);
    }

    /**
     * 往表达式传入值
     */
    public static void test3() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "张三");
        String str = "'hello ' + name";
        String result = (String) AviatorEvaluator.execute(str, map);
        System.out.println(result);
        //写法二
        String result2 = (String) AviatorEvaluator.exec(str, "李四");
        System.out.println(result2);
    }

    /**
     * 三元表达式
     */
    public static void test4() {
        String result = (String) AviatorEvaluator.execute("3 > 0 ? yes : no");
        System.out.println(result);
    }

    /**
     * 函数调用
     */
    public static void test5() {
        //求字符串长度,不能用String.length();
        System.out.println("string.length('hello') = " + AviatorEvaluator.execute("string.length('hello')"));
        //判断字符串中是否包含某个字符串
        System.out.println("string.contains('hello', 'h') = " + AviatorEvaluator.execute("string.contains('hello', 'h')"));
        System.out.println("math.pow(-3, 2) = " + AviatorEvaluator.execute("math.pow(-3, 2)"));
        System.out.println("math.sqrt(9.0) = " + AviatorEvaluator.execute("math.sqrt(9.0)"));
    }


}
