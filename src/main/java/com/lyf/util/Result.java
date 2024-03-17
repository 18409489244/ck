package com.lyf.util;

/**
 * @program: codepractice
 * @description:
 * @author: 刘耀福
 * @create: 2024-03-16 22:21
 **/

import java.io.Serializable;

/**
 * @Description TODO 统一返回对象
 * @Author admin
 * @Date 2021/6/30
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1147263201878313870L;

    private Integer code;
    private String message;
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result() {
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Result<T> ok() {
        return new Result<>(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMessage());
    }

    public static <T> Result<T> ok(String message) {
        return new Result<>(ResultCodeEnum.SUCCESS.getCode(), message);
    }

    public static <T> Result<T> ok(String message, T data) {
        return new Result<>(ResultCodeEnum.SUCCESS.getCode(), message, data);
    }

    public static <T> Result<T> ok(T data) {
        return new Result<>(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMessage(), data);
    }

    public static <T> Result<T> fail() {
        return new Result<>(ResultCodeEnum.FAIL.getCode(), ResultCodeEnum.FAIL.getMessage());
    }

    public static <T> Result<T> fail(String message) {
        return new Result<>(ResultCodeEnum.FAIL.getCode(), message);
    }

    public static <T> Result<T> fail(String message, T data) {
        return new Result<>(ResultCodeEnum.FAIL.getCode(), message, data);
    }

    public static <T> Result<T> fail(T data) {
        return new Result<>(ResultCodeEnum.FAIL.getCode(), ResultCodeEnum.FAIL.getMessage(), data);
    }

    public static <T> Result<T> custom(Integer code, String message) {
        return new Result<>(code, message);
    }

    public static <T> Result<T> custom(Integer code, String message, T data) {
        return new Result<>(code, message, data);
    }
}
