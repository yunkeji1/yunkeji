package com.cloudclass.course.controller;

import com.cloudclass.course.entity.User;
import com.cloudclass.course.service.UserService;
import com.cloudclass.course.util.JwtUtils;
import com.cloudclass.course.util.PhoneCode;
import com.cloudclass.course.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户登录、登出与注册
 * @author ss
 * @date 2020-6-12
 */
@RestController
public class LoginController {
    @Autowired
    UserService userService;
    @Autowired
    JwtUtils jwtUtils;

    /**
     *获取验证码以及接收短信
     */
    @RequestMapping("/getVerficationCode")
    public Result getVerficationCode(HttpServletRequest req){
        String phone = req.getParameter("phone");
        String verficationCode = PhoneCode.getPhonemsg(phone);
        return Result.ok().put("verficationCode", verficationCode);
    }

    @RequestMapping("/login")
    public Result login(@RequestBody User user){
        String phone = userService.login(user);
        String token = jwtUtils.generateToken(phone);
        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("expire", jwtUtils.getExpire());
        return Result.ok(map);
    }
}
