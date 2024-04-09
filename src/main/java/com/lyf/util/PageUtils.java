package com.lyf.util;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @program: yshj
 * @description: 手动分页工具类
 * @author: 刘耀福
 * @create: 2023-12-22 15:29
 **/
public class PageUtils {
    private PageUtils() {
    }

    public static List getRecords(List records, long current, long size, int total){
        int start = 0 + ((int)current -1)*((int)size);
        if(start > total){
            return Lists.newArrayList();
        } else {
            if(((int)size) * ((int)current) - total >= 0 && start == 0){
                return records;
            } else {
                int end = ((int)size) * ((int)current);
                end = end - total > 0? total : end;
                return records.subList(start, end);
            }
        }
    }
}
