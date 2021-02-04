package com.csh.mms.config;


import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class SysExceptionHandler {
	@ExceptionHandler
	@ResponseBody
	public String ErrorHandler(AuthorizationException e) {
		return "没有通过权限验证！";
	}
}
