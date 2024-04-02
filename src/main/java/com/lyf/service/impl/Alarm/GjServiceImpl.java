package com.lyf.service.impl.Alarm;

import com.lyf.enums.AlarmLevelEnum;
import com.lyf.service.Alarm.AlarmLevelService;
import com.lyf.service.Alarm.GjService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @program: codepractice
 * @description:
 * InitializingBean接口为bean提供了初始化方法的方式，它只包括 afterPropertiesSet 方法，凡是继承该接口的类，在初始化bean的时候都会执行该方法
 *
 * Spring中提供一些Aware相关接口，如BeanFactoryAware、 ApplicationContextAware、ResourceLoaderAware、ServletContextAware等等，
 * 这些 Aware接口的Bean在被初始之后，可以取得一些相对应的资源，例如实作BeanFactoryAware的Bean在初始后，Spring容器将会注入BeanFactory的实例，
 * 而实作ApplicationContextAware的Bean，在Bean被初始后，将会被注入 ApplicationContext的实例等等。
 * @create: 2024-04-02 08:47
 **/
@Service
public class GjServiceImpl implements GjService, InitializingBean, ApplicationContextAware {
    @Autowired
    private GeneralAlarmLevelServiceImpl generalAlarmLevelService;

    @Autowired
    private SeriousAlarmLevelServiceImpl seriousAlarmLevelService;

    ApplicationContext applicationContext;


    List<AlarmLevelService> alarmLevelServices;

    @Override
    public void afterPropertiesSet(){
        Map<String, AlarmLevelService> beansOfType = applicationContext.getBeansOfType(AlarmLevelService.class);
        Collection<AlarmLevelService> values = beansOfType.values();
        alarmLevelServices = new ArrayList<>(values);
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void gj(String type) {
        if(AlarmLevelEnum.general.getType().equals(type)){
            generalAlarmLevelService.pay();
        }else if(AlarmLevelEnum.serious.getType().equals(type)){
            seriousAlarmLevelService.pay();
        }
    }

    @Override
    public void gjYouHua(String type) {
        for (AlarmLevelService payService : alarmLevelServices) {
            if(payService.supports(type)){
                payService.pay();
            }
        }
    }
}
