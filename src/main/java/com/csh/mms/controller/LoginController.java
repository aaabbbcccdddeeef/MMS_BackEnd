package com.csh.mms.controller;

import java.util.Arrays;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csh.mms.domain.SysUser;
import com.csh.mms.dto.UserRoleDto;
import com.csh.mms.service.InventoryInfoService;

/**
 * 
 * @ClassName LoginController
 * @Description 登录
 * @author csh
 * @date 2020年11月4日 下午9:44:38
 *
 */
@RestController
@RequestMapping("/login")
public class LoginController {


	@PostMapping("/login")
	public Map<String, Object> login(@RequestBody UserRoleDto dto) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (StringUtils.isEmpty(dto.getAccount()) || StringUtils.isEmpty(dto.getPassword())) {
			resultMap.put("code", 0);
			resultMap.put("msg", "请输入用户名和密码！");
			return resultMap;
		} 
		// 用户认证信息 
		Subject	subject = SecurityUtils.getSubject();
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(dto.getAccount(), dto.getPassword());
		try { // 进行验证，这里可以捕获异常，然后返回对应信息
			subject.login(usernamePasswordToken);
			boolean[] results = subject.hasRoles(Arrays.asList("admin", "businessRole", "query", "add", "edit", "delete"));
			System.out.println(results[0] ? "拥有role1这个角色" : "没有role1这个角色");
		    System.out.println(results[1] ? "拥有role2这个角色" : "没有role2这个角色");
		    System.out.println(results[2] ? "拥有role3这个角色" : "没有role3这个角色");
		    
		    System.out.println(subject.hasAllRoles(Arrays.asList("admin", "businessRole", "query", "add", "edit", "delete")) ? "有角色"
		            : "没有角色");
//			subject.checkRole("admin");
//			subject.checkPermissions("query", "add");
		    System.out.println("+++++++++");
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
