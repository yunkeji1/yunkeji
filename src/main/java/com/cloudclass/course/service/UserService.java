package com.cloudclass.course.service;

import com.cloudclass.course.entity.User;

public interface UserService {
    User queryObject(String id);

    void save(User user);

    void update(User user);

    int delete(String id);

    int deleteBatch(String[] ids);

    String login(User user);
}
