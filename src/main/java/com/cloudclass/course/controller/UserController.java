package com.cloudclass.course.controller;

import com.cloudclass.course.annotation.LoginRequired;
import com.cloudclass.course.entity.User;
import com.cloudclass.course.service.UserService;
import com.cloudclass.course.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/getUser")
    @LoginRequired
    public Result getUserByLogin(HttpServletRequest req){
        String id = req.getParameter("id");
        User user = userService.queryObject(id);
        return Result.ok().put("user",user);
    }

    @RequestMapping("/save")
    public Result save(@RequestBody User user){
        userService.save(user);
        return Result.ok();
    }

    @RequestMapping("/updateUser")
    public Result updateUser(@RequestBody User user){
        userService.update(user);
        return Result.ok();
    }
}
