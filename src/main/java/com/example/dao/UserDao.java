package com.example.dao;

import com.example.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;

import static org.apache.ibatis.type.JdbcType.TIMESTAMP;

/**
 * 用户Dao接口类
 *
 * @author  nanjishiu
 * @version 1.0, 2017/11
 */
// 标志为 Mybatis 的 Mapper
@Mapper
public interface UserDao {

    /**
     *添加用户信息
     *
     */
    @InsertProvider(type = UserSqlProvider.class, method = "insert")
//    @SelectKey(statement="select t_user_sequence.nextval from dual",keyProperty="id", keyColumn = "id", before = true, resultType=long.class)
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    //@Options注解 在插入记录时，一般是定义主键自增(auto_increment)，但是在某些情况下，我们插入一条记录后，还想得到这条记录的自增主键ID，useGeneratedKeys=true就是定义数据库返回主键ID的，
    int insert(User user);

    /**
     * 根据用户id，删除用户信息
     *
     */
    @Delete("DELETE FROM t_user WHERE id =#{id}")
    int delete(Long id);

    /**
     * 更新用户信息
     *
     */
    @UpdateProvider(type = UserSqlProvider.class, method = "update")
    int update(User user);

    /**
     * 根据用户id，查询用户信息
     *
     */
    @Select("SELECT * FROM t_user WHERE id = #{id}")
    // 返回 Map 结果集
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "age", column = "age"),
            @Result(property = "createTime", column = "create_time", jdbcType = TIMESTAMP),
            @Result(property = "desc", column = "desc"),
            @Result(property = "address", column = "address"),
            @Result(property = "role", column = "role"),
            @Result(property = "status", column = "status"),
    })
    User findById(Long id);
    /**
     * 根据用户名(唯一)，查询用户信息
     *
     */
    @Select("SELECT * FROM t_user WHERE username = #{username}")
    // 返回 Map 结果集
    @Results({
            @Result(property = "createTime", column = "create_time", jdbcType = TIMESTAMP),
    })
    User findByUsername(String username);
    /**
     * 查询所有用户信息
     *
     */
    @Select("SELECT * FROM t_user")
    @Results({
            @Result(property = "createTime", column = "create_time", jdbcType = TIMESTAMP),
    })
    List<User> findAll();
    /**
     * 根据username查询所有用户信息
     *
     */
    @SelectProvider(type = UserSqlProvider.class, method = "getListByUsername")
    @Results({
            @Result(property = "createTime", column = "create_time", jdbcType = TIMESTAMP),
    })
    List<User> getListByUsername(String username);
    /**
     * 根据参数查询所有用户信息
     *
     */
    @SelectProvider(type = UserSqlProvider.class, method = "getList")
    @Results({
            @Result(property = "createTime", column = "create_time", jdbcType = TIMESTAMP),
    })
    List<User> getList(Map<String, Object> params);
    /**
     * 根据参数查询所有用户信息
     *
     */
    @SelectProvider(type = UserSqlProvider.class, method = "getListCount")
    int getListCount(Map<String, Object> params);

}