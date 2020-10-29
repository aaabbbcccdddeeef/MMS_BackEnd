package com.csh.mms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@MapperScan(value = "com.csh.mms.dao") //扫描的mapper
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println("锦州成功石英玻璃");
		SpringApplication.run(DemoApplication.class, args);
	}

}
