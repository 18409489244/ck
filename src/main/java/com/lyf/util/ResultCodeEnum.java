package com.lyf.util;

/**
 * @program: codepractice
 * @description:
 * @author: 刘耀福
 * @create: 2024-03-16 22:22
 **/

/**
 * @Description TODO 返回信息
 * @Author admin
 * @Date 2021/6/29
 */
public enum ResultCodeEnum {

    SUCCESS(200, "请求成功"),
    FAIL(500, "请求失败"),
    NO_PERMISSION(403, "权限不足");

    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
