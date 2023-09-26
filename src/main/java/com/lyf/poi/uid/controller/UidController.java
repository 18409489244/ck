package com.lyf.poi.uid.controller;


import com.lyf.poi.uid.util.DefGenerator;
import com.lyf.poi.uid.util.IdGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author liuyaofu
 * @create 2022-08-12-23:16
 */
@RestController
public class UidController {

    @Resource
    private IdGenerator idGenerator;

    @Resource
    private DefGenerator defGenerator;


    @GetMapping(value = "getUid")
    public long getUid() {
        long l = idGenerator.nextId();
        String parse = idGenerator.parse(l);
        System.out.println(parse);
        return l;
    }

    @GetMapping(value = "getUidDef")
    public long getUidDef() {
        long l = defGenerator.nextId();
        String parse = defGenerator.parse(l);
        System.out.println(parse);
        return l;
    }


}
