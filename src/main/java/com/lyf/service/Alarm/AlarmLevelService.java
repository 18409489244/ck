package com.lyf.service.Alarm;

/**
 * @program: codepractice
 * @description: 支付通用接口
 * @author: 刘耀福
 * @create: 2024-04-02 08:43
 **/
public interface AlarmLevelService {
    /**
     * 是否支持
     * @param payType
     * @return
     */
    boolean supports(String payType);
    /**
     * 支付接口
     * @return
     */
    void pay();
}
