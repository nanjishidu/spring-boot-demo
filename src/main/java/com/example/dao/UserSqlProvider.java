package com.example.dao;

import com.example.domain.User;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

/**
 * 用户SqlProvider类
 *
 * @author  nanjishiu
 * @version 1.0, 2017/11
 */
public class UserSqlProvider {

    private final static String TABLE_NAME = "user";
    private static final Logger logger = LogManager.getLogger(UserSqlProvider.class);
    /**
     * 添加用户
     */
    public String insert(final User user) {
        String sql = new SQL() {
            {
                INSERT_INTO(TABLE_NAME);
                if (user.getName() != null) {
                    VALUES("name", "#{name}");
                }
                if (user.getUsername() != null) {
                    VALUES("username", "#{username}");
                }
                if (user.getPassword() != null) {
                    VALUES("password", "#{password}");
                }
                if (user.getSex() != null) {
                    VALUES("sex", "#{sex}");
                }else{
                    VALUES("sex", "0");
                }
                if (user.getAge() != null) {
                    VALUES("age", "#{age}");
                }else{
                    VALUES("age", "0");
                }
                if (user.getCreateTime() != null) {
                    VALUES("create_time" ,"#{createTime}");
                }
                if (user.getPhone() != null) {
                    VALUES("phone", "#{phone}");
                }
                if (user.getAddress() != null) {
                    VALUES("address", "#{address}");
                }
                if (user.getDescription() != null) {
                    VALUES("description", "#{description}");
                }
                if (user.getRole() != null) {
                    VALUES("role", "#{role}");
                }else{
                    VALUES("role", "0");
                }
                if (user.getStatus() != null) {
                    VALUES("status", "#{status}");
                }else{
                    VALUES("status", "0");
                }
            }
        }.toString();
        return sql;
    }
    /**
     * 更新用户
     */
    public String update(final User user) {
        String sql = new SQL() {
            {
                UPDATE(TABLE_NAME);
                WHERE("id = #{id}");
                if (user.getName() != null) {
                    SET("name = #{name}");
                }
                if (user.getUsername() != null) {
                    SET("username = #{username}");
                }
                if (user.getPassword() != null) {
                    SET("password = #{password}");
                }
                if (user.getPhone() != null) {
                    SET("phone = #{phone}");
                }
                if (user.getAddress() != null) {
                    SET("address = #{address}");
                }
                if (user.getDescription() != null) {
                    SET("description = #{description}");
                }
                if (user.getSex() != null) {
                    SET("sex = #{sex}");
                }
                if (user.getAge() != null) {
                    SET("age = #{age}");
                }
                if (user.getCreateTime() != null) {
                    SET("create_time = #{createTime}");
                }
                if (user.getRole() != null) {
                    SET("role = #{role}");
                }
                if (user.getStatus() != null) {
                    SET("status = #{status}");
                }
            }
        }.toString();
        System.out.println(sql);
        return sql;
    }
    /**
     * 通过Username获取用户信息
     */
    public String getListByUsername(final String username) {
        return "SELECT * FROM user WHERE username =#{username}";
    }
    /**
     * 获取用户列表
     */
    public String getList(Map<String, Object> params) {
        String sql = new SQL() {{
            SELECT("*");
            FROM(TABLE_NAME);
            if (params.get("q")!=null ) {
                String q = (String) params.get("q");
                if (q!=""){
                    WHERE("name LIKE #{q} OR username LIKE #{q}");
                }
            }
            if (params.get("username")!=null) {
                String username = (String) params.get("username");
                if (username!="") {
                    WHERE("username LIKE #{username}");
                }
            }
            if (params.get("name")!=null ) {
                String name = (String) params.get("name");
                if (name!="") {
                    WHERE("name LIKE #{name}");
                }
            }
            if (params.get("phone")!=null) {
                String phone = (String) params.get("phone");
                if (phone!="") {
                    WHERE("phone = #{phone}");
                }
            }
            if (params.get("role")!=null ) {
                Integer role = (Integer) params.get("role");
                WHERE("role = #{role}");
            }
            if (params.get("status")!=null ) {
                Integer status = (Integer) params.get("status");
                WHERE("status = #{status}");
            }
            if (params.get("orderBy")!=null&&params.get("order")!=null){
                String orderBy = (String) params.get("orderBy");
                String order = (String) params.get("order");
                ORDER_BY(orderBy+" "+order);
            }
        }}.toString();
        if (params.get("pageSize")!=null&&params.get("page")!=null){
            int pageSize = (int) params.get("pageSize");
            int page = (int) params.get("page");
            sql = sql.trim() + " LIMIT " + (page - 1) * pageSize + "," + pageSize;
        }
        System.out.println(sql);
        return sql;
    }
    /**
     * 获取用户列表个数
     */
    public String getListCount(Map<String, Object> params) {
        return new SQL() {{
            SELECT("COUNT(*)");
            FROM(TABLE_NAME);
            if (params.get("q")!=null ) {
                String q = (String) params.get("q");
                if (q!=""){
                    WHERE("name LIKE #{q} OR username LIKE #{q}");
                }
            }
            if (params.get("username")!=null) {
                String username = (String) params.get("username");
                if (username!="") {
                    WHERE("username LIKE #{username}");
                }
            }
            if (params.get("name")!=null ) {
                String name = (String) params.get("name");
                if (name!="") {
                    WHERE("name LIKE #{name}");
                }
            }
            if (params.get("phone")!=null) {
                String phone = (String) params.get("phone");
                if (phone!="") {
                    WHERE("phone = #{phone}");
                }
            }
            if (params.get("role")!=null ) {
                Integer role = (Integer) params.get("role");
                WHERE("role = #{role}");
            }
            if (params.get("status")!=null ) {
                Integer status = (Integer) params.get("status");
                WHERE("status = #{status}");
            }
        }}.toString();
    }
}
