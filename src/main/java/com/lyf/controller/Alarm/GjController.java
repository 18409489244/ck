package com.lyf.controller.Alarm;
import com.lyf.service.Alarm.GjService;
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
public class GjController {
    @Autowired
    private GjService gjService;

    /**
     * 告警
     * @param type
     * @return
     */
    @GetMapping("/gj")
    public R gj(String type){
        gjService.gj(type);
        return R.ok();
    }

    /**
     * 优化
     * @param type
     * @return
     */
    @GetMapping("/gjYouHua")
    public R gjYouHua(String type){
        gjService.gjYouHua(type);
        return R.ok();
    }
}
