package com.lyf.controller.pay;
import com.lyf.service.pay.PaymentService;
import com.lyf.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: codepractice
 * @description: 支付方式优化
 * @author: 刘耀福
 * @create: 2024-04-02 08:39
 **/
@Slf4j
@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payment")
    public R pay(String payType){
        paymentService.payment(payType);
        return R.ok();
    }
}
