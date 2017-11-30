package com.example.controller.user;

import com.example.annotation.CurrentUser;
import com.example.annotation.LoginRequired;
import com.example.controller.*;
import com.example.controller.common.ApiResult;
import com.example.controller.common.ExceptionManager;
import com.example.controller.common.GloableException;
import com.example.controller.common.PageData;
import com.example.domain.User;
import com.example.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户web
 *
 * @author  nanjishiu
 * @version 1.0, 2017/11
 */


@CrossOrigin
@RestController
@RequestMapping(value="/api/user")
public class UserController {
    private static final Logger logger = LogManager.getLogger(UserController.class);
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;
    @Autowired
    HttpSession httpSession;

    @Autowired
    ExceptionManager exceptionManager;

    @ApiOperation(value="用户登陆", notes="根据 用户名和密码 登陆用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String", paramType="query"),
            @ApiImplicitParam(name = "password", value = "用户密码", required = true, dataType = "String", paramType="query")
    })
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ApiResult login(@RequestParam(value = "username",required = false)String username,
                           @RequestParam(value = "password",required = false)String password) {
        if (username==null||password==null) {
            throw exceptionManager.create("EC10001");
        }
        logger.debug(DigestUtils.md5Hex(password));
        User m = userService.findByUsername(username);
        if (m== null){
            throw exceptionManager.create("EC10002");
        }
        if (!m.getPassword().equals(DigestUtils.md5Hex(password))){
            throw exceptionManager.create("EC10003");
        }
        httpSession.setAttribute("SESSIONDEMO",m);
        return ApiResult.jdata(m);
    }

    @ApiOperation(value="登陆用户信息", notes="登陆用户信息")
    @RequestMapping(value = "/item", method = RequestMethod.POST)
    @LoginRequired
    public ApiResult item(@CurrentUser User user) {
        return ApiResult.jdata(user);
    }
    @ApiOperation(value="添加用户信息", notes="添加用户信息")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value = "", method = RequestMethod.POST)
    @LoginRequired
    public ApiResult insert(@RequestBody User user){
        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
        logger.fatal("fatal");

        if (user.getUsername() ==null){
            throw exceptionManager.create("EC10004");
        }
        if (user.getPassword() ==null){
            throw exceptionManager.create("EC10005");
        }
        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        userService.insert(user);
        logger.debug("添加用户id：",user.getId());
        return ApiResult.jdata(user);
    }

    @ApiOperation(value="删除用户信息", notes="根据id来删除用户信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType="path")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @LoginRequired
    public ApiResult delete(@PathVariable Long id){
        if (id<=0){
            throw exceptionManager.create("EC10006");
        }
        userService.delete(id);
        return ApiResult.jmessage("删除成功");
    }

    @ApiOperation(value="更新用户信息", notes="更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType="path"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @LoginRequired
    public ApiResult update(@PathVariable Long id,@RequestBody User user)   {
        if (id<=0){
            throw exceptionManager.create("EC10006");
        }
        user.setId(id);
        userService.update(user);
        return ApiResult.jmessage("更新成功");
    }

    @ApiOperation(value="获取用户信息", notes="根据id来获取用户信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType="path")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @LoginRequired
    public ApiResult findById(@PathVariable Long id)  {
        if (id<=0){
            throw exceptionManager.create("EC10006");
        }
        User u = userService.findById(id);
        return ApiResult.jdata(u);
    }

    @ApiOperation(value="获取用户列表", notes="根据id来获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "q", value = "模糊搜索", required = false, dataType = "String",paramType="query"),
            @ApiImplicitParam(name = "name", value = "真实姓名", required = false, dataType = "String",paramType="query"),
            @ApiImplicitParam(name = "username", value = "用户名", required = false, dataType = "String",paramType="query"),
            @ApiImplicitParam(name = "status", value = "状态", required = false, dataType = "Integer",paramType="query"),
            @ApiImplicitParam(name = "page", value = "页数", required = false, dataType = "Integer",paramType="query"),
            @ApiImplicitParam(name = "pageSize", value = "条数", required = false, dataType = "Integer",paramType="query"),
    })
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @LoginRequired
    public ApiResult getList(@RequestParam(value = "q",required = false)String q,
                         @RequestParam(value = "name",required = false)String name,
                         @RequestParam(value = "username",required = false)String username,
                         @RequestParam(value = "status",required = false)Integer status,
                         @RequestParam(value = "page",required = false)Integer page,
                         @RequestParam(value = "pageSize",required = false)Integer pageSize) {
        Map<String,Object> params = new HashMap<String,Object>();
        if (page==null){
            page = 1;
        }
        params.put("page",page);
        if (pageSize==null||pageSize>=100||pageSize<=0){
            pageSize =20;
        }
        params.put("pageSize",20);
        if (q!=null){
            params.put("q","%"+q+"%");
        }
        if (name!=null){
            params.put("name","%"+name+"%");
        }
        if (username!=null) {
            params.put("username", "%"+username+"%");
        }
        if (status!=null) {
            params.put("status", status);
        }
        List<User> all=userService.getList(params);
        int total = userService.getListCount(params);
        return ApiResult.jdata(new PageData(page,pageSize,total, all));
    }
}
