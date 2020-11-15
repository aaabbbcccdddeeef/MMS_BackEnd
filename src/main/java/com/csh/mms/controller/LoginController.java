package com.csh.mms.controller;


import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.csh.mms.domain.SysUser;

/**
 * 
 * @ClassName  LoginController 
 * @Description 登录
 * @author csh
 * @date  2020年11月4日 下午9:44:38 
 *
 */
@RestController
public class LoginController {

    @PostMapping("/login")
   	public Map<String, Object> login(@RequestBody SysUser user) {
    	Map<String, Object> resultMap = new HashMap<String, Object>();
    	if (StringUtils.isEmpty(user.getAccount()) || StringUtils.isEmpty(user.getPassword())) {
    		resultMap.put("code", 0);
    		resultMap.put("msg", "请输入用户名和密码！");
            return resultMap;
        }
        //用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getAccount(), user.getPassword());
        try {
            //进行验证，这里可以捕获异常，然后返回对应信息
            subject.login(usernamePasswordToken);
        } catch (UnknownAccountException e) {
        	resultMap.put("code", 1);
    		resultMap.put("msg", "用户名不存在！");
    		return resultMap;
        } catch (AuthenticationException e) {
        	resultMap.put("code", 2);
    		resultMap.put("msg", "账号或密码错误！");
        	return resultMap;
        } catch (AuthorizationException e) {
        	resultMap.put("code", 3);
    		resultMap.put("msg", "没有权限！");
        	return resultMap;
        }
        resultMap.put("code", 200);
		resultMap.put("msg", "登录成功！");
        return resultMap;
    }

    @RequiresRoles("admin")
    @GetMapping("/admin")
    public String admin() {
        return "admin success!";
    }

    @RequiresPermissions("query")
    @GetMapping("/index")
    public String index() {
        return "index success!";
    }

    @RequiresPermissions("add")
    @GetMapping("/add")
    public String add() {
        return "add success!";
    }
}