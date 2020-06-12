package com.cloudclass.course.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 类BaseDao的功能描述:
 * 基础Dao
 * @auther ss
 * @date 2020-6-10
 */
@Mapper
public interface BaseDao<T> {
    int save(T t);

    int save(Map<String, Object> map);

    int saveBatch(List<T> list);

    int update(T t);

    int update(Map<String, Object> map);

    int delete(Object id);

    int delete(Map<String, Object> map);

    int deleteBatch(Object[] ids);

    T queryObject(Object id);

    List<T> queryList(Map<String, Object> map);

    List<T> queryList();

    List<T> queryListByBean(T t);

    List<T> queryList(Object id);

    int queryTotal(Map<String, Object> map);

    int queryTotal();
}
