package com.lyf.service.impl;
import com.lyf.entity.User;
import com.lyf.mapper.UserMapper;
import com.lyf.service.UserService;
import com.lyf.util.Constants;
import com.lyf.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
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
        userListMap.entrySet().forEach(map->{
            String key = map.getKey();
            List<User> value = map.getValue();
            value.stream().forEach(user->{
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
        Map<String, List<Map<String,Object>>> resultMap = new HashMap<>();
        AtomicInteger index = new AtomicInteger(1);
        allPackageListMap.entrySet().forEach(map->{
            String key = map.getKey();
            if(Constants.ONE_STR.equals(key)){
                resultMap.put(key+"基准包",map.getValue());
            }else{
                resultMap.put(key+"对比包"+ index.getAndIncrement(),map.getValue());
            }
        });
        return R.ok(resultMap);
    }

    private static Map<String,Object> getFiledName(Object o,String key){
        Field[] fields=o.getClass().getDeclaredFields();
        Map<String,Object> map = new HashMap<>(4);
        for(int i=0;i<fields.length;i++){
            fields[i].setAccessible(true);
            try {
                if(!"typeId".equals(fields[i].getName())){
                    map.put(fields[i].getName()+key,fields[i].get(o));
                }else{
                    map.put(fields[i].getName(),fields[i].get(o));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        Map<String, Object> treeMap = new TreeMap<>(map);
        return treeMap;
    }
}
