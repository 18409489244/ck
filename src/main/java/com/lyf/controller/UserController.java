package com.lyf.controller;
import com.lyf.service.CategoryEntityService;
import com.lyf.service.UserService;
import com.lyf.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return R.ok(userService.listUser());
    }


    @GetMapping("/getData")
    public R getData(){
        return R.ok(categoryEntityService.getData());
    }
}
