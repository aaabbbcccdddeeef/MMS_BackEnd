package com.csh.mms;

import java.util.Properties;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.github.pagehelper.PageHelper;



@MapperScan(value = "com.csh.mms.dao") //扫描的mapper
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		System.out.println("锦州成功石英玻璃");
		SpringApplication.run(Application.class, args);
	}
	/**
	 * 
	 * @ClassName  CorsConfig 
	 * @Description 后台跨域配置
	 * @author csh
	 * @date  2020年11月15日 下午10:14:55 
	 *
	 */
	@Configuration  
	public class CorsConfig {  
	    private CorsConfiguration buildConfig() {  
	        CorsConfiguration corsConfiguration = new CorsConfiguration();  
	        corsConfiguration.addAllowedOrigin("*"); // 1允许任何域名使用
	        //corsConfiguration.addAllowedOrigin("http://192.168.10.107:8080"); //允许跨越发送cookie  
	        corsConfiguration.addAllowedHeader("*"); // 2允许任何头
	        corsConfiguration.addAllowedMethod("*"); // 3允许任何方法（post、get等） 
	        corsConfiguration.setAllowCredentials(true); //放行全部原始头信息
	        return corsConfiguration;  
	    }  
	  
	    @Bean  
	    public CorsFilter corsFilter() {  
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();  
	        source.registerCorsConfiguration("/**", buildConfig()); // 4  
	        return new CorsFilter(source);  
	    }  
	}
	//配置mybatis的分页插件pageHelper
    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum","true");
        properties.setProperty("pageSizeZero", "true");//分页尺寸为0时查询所有纪录不再执行分页
        properties.setProperty("rowBoundsWithCount","true");
        properties.setProperty("reasonable","true");
        properties.setProperty("dialect","mysql");//配置mysql数据库的方言
        pageHelper.setProperties(properties);
        return pageHelper;
    }
}
