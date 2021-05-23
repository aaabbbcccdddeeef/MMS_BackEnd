package com.csh.mms.config;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.csh.mms.dto.PermissionDto;
import com.csh.mms.dto.RoleDto;
import com.csh.mms.dto.UserRoleDto;
import com.csh.mms.service.LoginService;

/**
 * 
 * @ClassName  CustomRealm 
 * @Description TODO
 * @author csh
 * @date  2020年10月25日 下午6:13:34 
 *
 */
public class CustomRealm extends AuthorizingRealm {

	@Autowired
    private LoginService loginService;

	
    /**
     * @MethodName doGetAuthorizationInfo
     * @Description 权限配置类
     * @Param [principalCollection]
     * @Return AuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录用户名
        String account = (String) principalCollection.getPrimaryPrincipal();
        //查询用户名称
//        SysUser user = loginService.getUserByAccount(account);
        UserRoleDto user = loginService.getUserByAccount(account);
        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        for (RoleDto role : user.getRoles()) {
            //添加角色
            simpleAuthorizationInfo.addRole(role.getRoleName());
            //添加权限
            for (PermissionDto permission : role.getPermissions()) {
                simpleAuthorizationInfo.addStringPermission(permission.getPermissionName());
            }
        }
//        Session session = SecurityUtils.getSubject().getSession();
//        session.setAttribute("user", user);
//        session.setAttribute("userInfo", simpleAuthorizationInfo);
//        SimpleAuthorizationInfo userInfo = (SimpleAuthorizationInfo) SecurityUtils.getSubject().getSession().getAttribute("userInfo");
//        System.out.println("123:"+userInfo);
        return simpleAuthorizationInfo;
    }

    /**
     * @MethodName doGetAuthenticationInfo
     * @Description 认证配置类
     * @Param [authenticationToken]
     * @Return AuthenticationInfo
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        if (StringUtils.isEmpty(authenticationToken.getPrincipal())) {
            return null;
        }
        //获取用户信息
        String account = authenticationToken.getPrincipal().toString();
//        SysUser user = loginService.getUserByAccount(account);
        UserRoleDto user = loginService.getUserByAccount(account);
        if (user == null) {
            //这里返回后会报出对应异常
            return null;
        } else {
            //这里验证authenticationToken和simpleAuthenticationInfo的信息
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(account, user.getPassword().toString(), getName());
            Session session = SecurityUtils.getSubject().getSession();
//            session.setAttribute("userInfo", simpleAuthorizationInfo);
//            customRealm.getAuthorizationCache().get(SecurityUtils.getSubject().getPrincipals());
//            SimpleAuthorizationInfo userInfo = (SimpleAuthorizationInfo) SecurityUtils.getSubject().getSession().getAttribute("userInfo");
            session.setAttribute("user", user);
//            session.setAttribute("userInfo", simpleAuthenticationInfo);
            return simpleAuthenticationInfo;
        }
    }
}
