package com.lyf.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @program: codepractice
 * @description:
 * @author: 刘耀福
 * @create: 2024-04-08 22:08
 **/
@Data
@Accessors(chain = true)
public class HandingVo {
    private Object entityList;

    private Object headers;
}
