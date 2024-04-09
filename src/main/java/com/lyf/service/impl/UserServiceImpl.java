package com.lyf.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lyf.DynamicBean.ReflectUtil;
import com.lyf.entity.HandingVo;
import com.lyf.entity.ResultUser;
import com.lyf.entity.User;
import com.lyf.mapper.UserMapper;
import com.lyf.service.UserService;
import com.lyf.util.Constants;
import com.lyf.util.PageUtils;
import com.lyf.util.R;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @program: codepractice
 * @description:
 * @author: 刘耀福
 * @create: 2024-03-16 09:28
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public R listUser() {
        List<User> users = userMapper.selectUser();
        Map<String, List<User>> userListMap = users.stream().collect(Collectors.groupingBy(User::getTypeId));
        List<Map<String, Object>> userListNew = new ArrayList<>();
        userListMap.entrySet().forEach(map -> {
            String key = map.getKey();
            List<User> value = map.getValue();
            value.stream().forEach(user -> {
                Map<String, Object> userMap = null;
                try {
                    userMap = getFiledName(user, key);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(userMap);
                userListNew.add(userMap);
            });
        });
        Map<String, List<Map<String, Object>>> allPackageListMap = userListNew.stream().collect(Collectors.groupingBy(map -> map.get("typeId").toString()));
        Map<String, List<Map<String, Object>>> resultMap = new HashMap<>();
        AtomicInteger index = new AtomicInteger(1);
        allPackageListMap.entrySet().forEach(map -> {
            String key = map.getKey();
            if (Constants.ONE_STR.equals(key)) {
                resultMap.put(key + "基准包", map.getValue());
            } else {
                resultMap.put(key + "对比包" + index.getAndIncrement(), map.getValue());
            }
        });
        return R.ok(resultMap);
    }

    private static Map<String, Object> getFiledName(Object o, String key) {
        Field[] fields = o.getClass().getDeclaredFields();
        Map<String, Object> map = new HashMap<>(4);
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            try {
                if (!"typeId".equals(fields[i].getName())) {
                    map.put(fields[i].getName() + key, fields[i].get(o));
                } else {
                    map.put(fields[i].getName(), fields[i].get(o));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        Map<String, Object> treeMap = new TreeMap<>(map);
        return treeMap;
    }


    @Override
    public R listUser2() {
        List<User> users = userMapper.selectUser();
        List<Map<String, Object>> listMap = new ArrayList<>();
        List<Map<String, Object>> resultListMap = new ArrayList<>();
        users.forEach(user -> {
            listMap.add(user.toMap());
        });
        Map<String, List<Map<String, Object>>> typeIdMap = listMap.stream().collect(
                Collectors.groupingBy(item -> item.get("typeId").toString()));
        typeIdMap.entrySet().forEach(map -> {
            map.getValue().forEach(m -> {
                Set<String> keys = m.keySet();
                Map<String, Object> mapNew = new HashMap<>();
                for (String key : keys) {
                    mapNew.put(key + map.getKey(), m.get(key));
                }
                resultListMap.add(mapNew);
            });
        });
        return R.ok(resultListMap);
    }
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public R listUser3() throws Exception {
        List<String> baseTypeIds = new ArrayList<>();
        baseTypeIds.add("1");

        List<String> compareTypeIds = new ArrayList<>();
        compareTypeIds.add("2");
        compareTypeIds.add("3");

        LinkedList<String> typeIds = new LinkedList<>();
        typeIds.addAll(baseTypeIds);
        typeIds.addAll(compareTypeIds);
        List<Map<String, Object>> listMap = new ArrayList<>();

        int index = 0;
        for (String typeId : typeIds) {
            List<User> users = userMapper.selectUserByTypeId(typeId);
            for (User user : users) {
                LinkedHashMap<String, Object> propertiesMap = new LinkedHashMap<>(12);
                propertiesMap.put("username", user.getUsername());
                propertiesMap.put("balance"+index, user.getBalance());
                listMap.add(propertiesMap);
            }
            index++;
        }
        List<Map<String,Object>> resultList = new ArrayList<>();
        Map<Object, List<Map<String, Object>>> username = listMap.stream().collect(Collectors.groupingBy(item -> item.get("username")));
        for (int i = 0; i < username.entrySet().size(); i++) {
            Map<String, Object> tmpMap = new HashMap<>();
            for (int j = 0; j < listMap.size(); j++) {
                if (listMap.get(i).get("username").equals(listMap.get(j).get("username"))) {
                    tmpMap.putAll(listMap.get(i));
                    tmpMap.putAll(listMap.get(j));
                }
            }
            resultList.add(tmpMap);
        }

        //头信息封装headers
        Map<String,Object> headers = new HashMap<>();
        headers.put("username","部门");
        AtomicInteger flag1 = new AtomicInteger(0);
        AtomicInteger flag2 = new AtomicInteger(1);
        for (String ignored : typeIds) {
            if(flag1.get()==0){
                headers.put("balance"+flag1.get(),"实际指标得分（基准包）");
                flag1.getAndIncrement();
            }else{
                headers.put("balance"+flag2,"实际指标得分（对比包"+flag2.getAndIncrement()+"）");
            }
        }
        //头信息封装headers

        //排序
        List<Map<String, Object>> maps = sortMapListByFeild(resultList, "balance2", "desc");

        //分页
        Map<String, Object> entityList = new HashMap<>();
        if(CollectionUtils.isEmpty(maps)){
            entityList.put("records", PageUtils.getRecords(maps, 1, 10, 0));
            entityList.put("current", 1);
            entityList.put("size", 10);
            entityList.put("total", 0);
        }else{
            entityList.put("records", PageUtils.getRecords(maps, 1, 10, maps.size()));
            entityList.put("current", 1);
            entityList.put("size", 10);
            entityList.put("total", maps.size());
        }
        HandingVo handingVo = new HandingVo();
        handingVo.setHeaders(headers);
        handingVo.setEntityList(entityList);
        return R.ok(handingVo);
    }


    private static List<Map<String, Object>> sortMapListByFeild(List<Map<String, Object>> list, String feild, String sortTyp) {
        if (!CollectionUtils.isEmpty(list)) {
            list.sort((m1, m2) -> {
                if (StringUtils.equals(sortTyp, "desc")) {
                    return String.valueOf(m2.get(feild)).compareTo(String.valueOf(m1.get(feild)));
                } else {
                    return String.valueOf(m1.get(feild)).compareTo(String.valueOf(m2.get(feild)));
                }
            });
        }
        return list;
    }
}
