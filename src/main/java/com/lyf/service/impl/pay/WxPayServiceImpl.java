package com.lyf.service.impl.pay;

import com.lyf.service.pay.PayService;
import org.springframework.stereotype.Service;

/**
 * @program: codepractice
 * @description:
 * @author: 刘耀福
 * @create: 2024-04-02 08:42
 **/
@Service
public class WxPayServiceImpl implements PayService {
    /**
     * 支付接口
     *
     * @return
     */
    @Override
    public void pay() {
        System.out.println("微信支付");
    }
}
