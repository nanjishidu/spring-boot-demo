package com.example.domain;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;


/**
 * 用户实体类
 *
 * @author  nanjishiu
 * @version 1.0, 2017/11
 */
/**
 *  @JsonIgnoreProperties json返回自动忽略某字段
 */
public class User {
    /**
     *ID
     */
    private Long id;
    /**
     *真实姓名
     */
    private String name;
    /**
     *用户名
     */
    private String username;
    /**
     *密码
     */
    @JSONField(serialize = false)
    private String password;
    /**
     *手机号
     */
    private String phone;
    /**
     *性别
     */
    private Integer sex;
    /**
     *年龄
     */
    private Integer age;
    /**
     *地址
     */
    private String address;
    /**
     *创建时间
     */
    private Date createTime;
    /**
     *用户描述
     */
    private String description;
    /**
     *用户角色
     */
    private Integer role;
    /**
     *状态 0 为启用 1 为禁用
     */
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
