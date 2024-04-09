package com.lyf.controller.user;
import com.lyf.entity.User;
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
     * 使用反射修改对象属性方法
     *
     * @return
     */
    @GetMapping("/listUser")
    public R listUser() {
        return userService.listUser();
    }

    /**
     * 使用xxx修改对象属性方法
     *
     * @return
     */
    @GetMapping("/listUser2")
    public R listUser2() {
        return userService.listUser2();
    }

    /**
     * 使用xxx修改对象属性方法
     *
     * @return
     */
    @GetMapping("/listUser3")
    public R listUser3() throws Exception {
        return userService.listUser3();
    }


    @GetMapping("/getData")
    public R getData() {
        return R.ok(categoryEntityService.getData());
    }


    @GetMapping("/getData1")
    public Result getData1() {
        return Result.ok();
    }
}
