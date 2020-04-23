package com.sp.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnDBMySql {
	private Connection ct=null;
	public Connection getConn(){
		try{
		Class.forName("com.mysql.jdbc.Driver");              //加载驱动
	    ct=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee?characterEncoding=UTF-8","root","123456");   //连接数据库，并设置编码格式
		}catch(Exception e){
			e.printStackTrace();
		}
	    return ct;
	}
}
