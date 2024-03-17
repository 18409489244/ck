package com.lyf.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: codepractice
 * @description:
 * @author: 刘耀福
 * @create: 2024-03-16 09:49
 **/
@Data
@TableName("t_user")
public class User {
    private String userId;
    private String username;
    private int balance;
    private String typeId;

    public User(String userId, String username, int balance, String typeId) {
        this.userId = userId;
        this.username = username;
        this.balance = balance;
        this.typeId = typeId;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                boolean accessible = field.isAccessible();
                field.setAccessible(true);
                map.put(field.getName(), field.get(this));
                field.setAccessible(accessible);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }
}
