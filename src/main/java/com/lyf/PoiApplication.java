package com.lyf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lyf.poi.list.mapper")
//@ComponentScan("com.lyf.poi.list")
public class PoiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PoiApplication.class, args);
    }

}
