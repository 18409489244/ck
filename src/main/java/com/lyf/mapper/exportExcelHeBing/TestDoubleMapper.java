package com.lyf.mapper.exportExcelHeBing;

import com.lyf.entity.exportExcelHeBing.TestDouble;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: codepractice
 * @description:
 * @author: 刘耀福
 * @create: 2024-04-17 15:07
 **/
@Mapper
public interface TestDoubleMapper {

    List<TestDouble> selectData();

}
