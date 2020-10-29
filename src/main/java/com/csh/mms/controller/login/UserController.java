package com.csh.mms.controller.login;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csh.mms.domain.UserDomain;
import com.csh.mms.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

    @GetMapping("/getUser")
    public String login(UserDomain user) {
        if (StringUtils.isEmpty(user.getAccount()) || StringUtils.isEmpty(user.getPassword())) {
            return "请输入用户名和密码！";
        }
        UserDomain resultUser = new UserDomain();
        String account = user.getAccount();
        System.out.println(account);
        //用户认证信息
//        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getAccount(), user.getPassword());
        resultUser = userService.getUserByAccount(account);
		/*
		 * try { //进行验证，这里可以捕获异常，然后返回对应信息 subject.login(usernamePasswordToken); //
		 * subject.checkRole("admin"); // subject.checkPermissions("query", "add"); }
		 * catch (UnknownAccountException e) { // log.error("用户名不存在！", e); return
		 * "用户名不存在！"; } catch (AuthenticationException e) { // log.error("账号或密码错误！", e);
		 * return "账号或密码错误！"; } catch (AuthorizationException e) { // log.error("没有权限！",
		 * e); return "没有权限"; }
		 */
        return "login success";
    }

}
