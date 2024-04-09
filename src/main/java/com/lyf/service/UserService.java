package com.lyf.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.lyf.entity.User;
import com.lyf.util.R;

import java.lang.reflect.InvocationTargetException;

/**
 * @program: codepractice
 * @description:
 * @author: 刘耀福
 * @create: 2024-03-16 09:27
 **/
public interface UserService {
    R listUser();

    R listUser2();

    R listUser3() throws Exception;
}
