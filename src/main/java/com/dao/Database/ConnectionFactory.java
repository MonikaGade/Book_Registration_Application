package com.dao.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static String driver_class="com.mysql.cj.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/BookList";
	private String db_username="root";
	private String db_password="Manasa1@";
	static {
		
	try {
		Class.forName(driver_class);
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
	
	public Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(url,db_username,db_password);
		return conn;
	}

}
