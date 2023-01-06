package com.lyf.poi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.baidu.fsg")
public class PoiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PoiApplication.class, args);
    }

}
