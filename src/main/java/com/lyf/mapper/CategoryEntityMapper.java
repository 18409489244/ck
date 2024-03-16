package com.lyf.mapper;

import com.lyf.entity.CategoryEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: codepractice
 * @description:
 * @author: 刘耀福
 * @create: 2024-03-16 12:44
 **/
@Mapper
public interface CategoryEntityMapper {
    List<CategoryEntity> getList();
}
