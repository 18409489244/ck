package com.lyf.service.impl.pay;

import com.lyf.service.pay.PayService;
import org.springframework.stereotype.Service;

/**
 * @program: codepractice
 * @description:
 * @author: 刘耀福
 * @create: 2024-04-02 08:43
 **/
@Service
public class ZfbPayServiceImpl implements PayService {
    /**
     * 支付接口
     *
     * @return
     */
    @Override
    public void pay() {
        System.out.println("支付宝支付");
    }
}
