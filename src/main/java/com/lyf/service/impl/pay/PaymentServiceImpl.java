package com.lyf.service.impl.pay;

import com.lyf.service.pay.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: codepractice
 * @description:
 * @author: 刘耀福
 * @create: 2024-04-02 08:47
 **/
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private WxPayServiceImpl wxPayService;

    @Autowired
    private ZfbPayServiceImpl zfbPayService;


    @Override
    public void payment(String payType) {
        if("wx".equals(payType)){
            wxPayService.pay();
        }else if("zfb".equals(payType)){
            zfbPayService.pay();
        }
    }
}
