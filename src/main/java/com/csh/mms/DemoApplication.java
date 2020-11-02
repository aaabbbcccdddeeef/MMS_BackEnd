package com.csh.mms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;



@MapperScan(value = "com.csh.mms.dao") //扫描的mapper
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println("锦州成功石英玻璃");
		SpringApplication.run(DemoApplication.class, args);
	}

	@Configuration  
	public class CorsConfig {  
	    private CorsConfiguration buildConfig() {  
	        CorsConfiguration corsConfiguration = new CorsConfiguration();  
	        corsConfiguration.addAllowedOrigin("*"); // 1允许任何域名使用
	        corsConfiguration.addAllowedHeader("*"); // 2允许任何头
	        corsConfiguration.addAllowedMethod("*"); // 3允许任何方法（post、get等） 
	        return corsConfiguration;  
	    }  
	  
	    @Bean  
	    public CorsFilter corsFilter() {  
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();  
	        source.registerCorsConfiguration("/**", buildConfig()); // 4  
	        return new CorsFilter(source);  
	    }  
	}
}
