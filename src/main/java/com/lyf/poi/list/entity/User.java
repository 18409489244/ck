package com.lyf.poi.list.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

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
}
