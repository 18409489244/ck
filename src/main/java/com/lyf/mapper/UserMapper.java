package com.lyf.mapper;

import com.lyf.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: codepractice
 * @description:
 * @author: 刘耀福
 * @create: 2024-03-16 09:49
 **/
@Mapper
public interface UserMapper {
    List<User> selectUser();
}
