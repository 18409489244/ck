package com.lyf.service.impl.Alarm;

import com.lyf.enums.AlarmLevelEnum;
import com.lyf.service.Alarm.AlarmLevelService;
import org.springframework.stereotype.Service;

/**
 * @program: codepractice
 * @description:
 * @author: 刘耀福
 * @create: 2024-04-02 08:43
 **/
@Service
public class SeriousAlarmLevelServiceImpl implements AlarmLevelService {
    /**
     * 是否支持
     *
     * @param payType
     * @return
     */
    @Override
    public boolean supports(String payType) {
        return AlarmLevelEnum.serious.getType().equals(payType);
    }
    /**
     * 告警接口
     *
     * @return
     */
    @Override
    public void pay() {
        System.out.println("严重告警......");
    }
}
