package com.masai.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {
	public static Connection provideConnection() {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/carbooking";
		String username="root";
		String pass="root";
		
		try {
			conn =  DriverManager.getConnection(url, username, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return conn;
	}

}
