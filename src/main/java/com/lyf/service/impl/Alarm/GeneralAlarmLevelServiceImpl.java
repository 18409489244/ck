package com.lyf.service.impl.Alarm;

import com.lyf.enums.AlarmLevelEnum;
import com.lyf.service.Alarm.AlarmLevelService;
import org.springframework.stereotype.Service;

/**
 * @program: codepractice
 * @description:
 * @author: 刘耀福
 * @create: 2024-04-02 08:42
 **/
@Service
public class GeneralAlarmLevelServiceImpl implements AlarmLevelService {
    /**
     * 是否支持
     *
     * @param payType
     * @return
     */
    @Override
    public boolean supports(String payType) {
        return AlarmLevelEnum.general.getType().equals(payType);
    }

    /**
     * 告警接口
     *
     * @return
     */
    @Override
    public void pay() {
        System.out.println("一般告警...");
    }
}
