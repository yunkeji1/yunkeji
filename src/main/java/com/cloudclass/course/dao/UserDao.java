package com.cloudclass.course.dao;

import com.cloudclass.course.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseDao<User>{
}
