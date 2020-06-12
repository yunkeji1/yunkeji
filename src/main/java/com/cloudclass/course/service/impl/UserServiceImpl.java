package com.cloudclass.course.service.impl;

import com.cloudclass.course.dao.UserDao;
import com.cloudclass.course.entity.User;
import com.cloudclass.course.exception.MyException;
import com.cloudclass.course.service.UserService;
import com.cloudclass.course.util.PhoneCode;
import com.cloudclass.course.util.StringUtils;
import com.cloudclass.course.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User queryObject(String id) {
        return userDao.queryObject(id);
    }

    @Override
    public void save(User user) {
        user.setId(Utils.uuid());
        user.setCreateTime(new Date());
        userDao.save(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public int delete(String id) {
        return userDao.delete(id);
    }

    @Override
    public int deleteBatch(String[] ids) {
        return userDao.deleteBatch(ids);
    }

    @Override
    public String login(User user) {
        if(StringUtils.isEmpty(user.getPhone())){
            throw new MyException("登录手机号不能为空！");
        }
        if(StringUtils.isEmpty(user.getVerificationCode())){
            throw new MyException("验证码不能为空");
        }
        user = queryObject(user.getPhone());
        if(user == null){
            throw new MyException("手机号或验证码错误");
        }
        if(!user.getVerificationCode().equals(PhoneCode.vcode())){
            throw new MyException("验证码输入错误");
        }
        return user.getPhone();
    }
}
