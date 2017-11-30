package com.example.service;

import com.example.domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户业务逻辑接口类
 *
 * @author  nanjishiu
 * @version 1.0, 2017/11
 */
public interface UserService {
    /**
     *添加用户信息
     *
     */
    int insert(User user);
    /**
     * 根据用户id，删除用户信息
     *
     */
    int delete(Long id);

    /**
     * 更新用户信息
     *
     */
    int update(User user);

    /**
     * 根据用户id，查询用户信息
     *
     */
    User findById(Long id);
    /**
     * 根据用户名(唯一)，查询用户信息
     *
     */
    User findByUsername(String username);
    /**
     * 查询所有用户信息
     *
     */
    List<User> findAll();
    /**
     * 根据username查询所有用户信息
     *
     */
    List<User> getListByUsername(String username);
    /**
     * 根据参数查询所有用户信息
     *
     */
    List<User> getList(Map<String, Object> params);
    /**
     * 根据参数查询所有用户信息
     *
     */
    int getListCount(Map<String, Object> params);

}
