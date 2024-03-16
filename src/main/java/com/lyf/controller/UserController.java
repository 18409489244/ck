package com.lyf.controller;
import com.lyf.service.CategoryEntityService;
import com.lyf.service.UserService;
import com.lyf.util.R;
import com.lyf.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: codepractice
 * @description:
 * @author: 刘耀福
 * @create: 2024-03-16 10:02
 **/
@Slf4j
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private CategoryEntityService categoryEntityService;
    /**
     * 用户对比包
     * @return
     */
    @GetMapping("/listUser")
    public R listUser(){
        String xxx = "222";
        return R.ok("保存成功",xxx);
    }


    @GetMapping("/getData")
    public R getData(){
        return R.ok(categoryEntityService.getData());
    }



    @GetMapping("/getData1")
    public Result getData1(){
        return Result.ok();
    }
}
