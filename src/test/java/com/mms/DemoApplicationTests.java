package com.mms;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoApplicationTests.class })//这里加启动类
@SpringBootApplication
class DemoApplicationTests {

	/*
	 * @Test void contextLoads() { }
	 */
	@Autowired
    private DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
    	//根据配置的数据库信息获取连接，执行语句
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from sys_user");
        //打印结果
        while(resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(4);
            String account = resultSet.getString(2);
            System.out.println("id:"+id + "name:" + name + "account:"+account);
        }
    }

}
