package com.lyf.DynamicBean;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: codepractice
 * @description:
 * @author: 刘耀福
 * @create: 2024-04-08 17:57
 **/
public class Kill {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static void main(String[] args) throws Exception {

        User user = new User();
        user.setName("Daisy");
        String s = MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(user);
        System.out.println(s);

        Map<String, Object> propertiesMap = new HashMap<>(1);
        propertiesMap.put("age", 18);

        Object obj = ReflectUtil.getObject(user, propertiesMap);
        String s1 = MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        System.out.println(s1);
    }



}
