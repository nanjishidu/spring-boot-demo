package com.example.service.impl;


import com.example.dao.UserDao;
import com.example.domain.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 用户逻辑实现类
 *
 * @author  nanjishiu
 * @version 1.0, 2017/11
 */
@Service
//@Qualifier 当你创建多个具有相同类型的 bean 时，并且想要用一个属性只为它们其中的一个进行装配，在这种情况下，你可以使用 @Qualifier 注释和 @Autowired 注释通过指定哪一个真正的 bean 将会被装配来消除混乱
@Qualifier("userServiceImpl")
public class UserServiceImpl implements UserService {

     @Autowired
     private UserDao userDao;
    /**
     *添加用户信息
     *
     */
    public int insert(User user) {
        return userDao.insert(user);
    }
    /**
     * 根据用户id，删除用户信息
     *
     */
    public int delete(Long id) {
        return userDao.delete(id);
    }

    /**
     * 更新用户信息
     *
     */
    public int update(User user) {
        return userDao.update(user);
    }

    /**
     * 根据用户id，查询用户信息
     *
     */
    public User findById(Long id) {
        return userDao.findById(id);
    }
    /**
     * 根据用户名(唯一)，查询用户信息
     *
     */
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
    /**
     * 查询所有用户信息
     *
     */
    public List<User> findAll() {
        return userDao.findAll();
    }
    /**
     * 根据username查询所有用户信息
     *
     */
    public List<User> getListByUsername(String username) {
        return userDao.getListByUsername(username);
    }
    /**
     * 根据参数查询所有用户信息
     *
     */
    public List<User> getList(Map<String, Object> params) {
        return userDao.getList(params);
    }
    /**
     * 根据参数查询所有用户信息
     *
     */
    public int getListCount(Map<String, Object> params) {
        return userDao.getListCount(params);
    }

}
