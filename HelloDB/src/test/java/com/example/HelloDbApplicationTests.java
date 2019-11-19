package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class HelloDbApplicationTests {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/MyDB" +
									"?useSSL=false&serverTimezone=Asia/Seoul";
	
	private static final String USER = "tmdwo99";
	private static final String PW = "Thwlro7282";
	
	private static Connection conn;

	@Test
	public void contextLoads() {
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PW);
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Student");
			
			log.info("*********************************************************");
			while(rs.next()) {
				log.info("[DB] name : {}, id : {}, department : {}",
						rs.getString("name"), rs.getString("id"), rs.getString("department"));
				log.info("---------------------------------------------------------");
			}
			log.info("*********************************************************");
		}catch (ClassNotFoundException e){
			log.info("JDBC 드라이버 로드 에러 : {}", e.getMessage());
		}catch (SQLException e) {
			log.info("DB 연결 오류 : {}", e.getMessage());		
		}
		
	}

}
