package com.bv.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnect {
	
	public static Connection getConnection() {
		
		// 1) Create Properties class object
		FileInputStream fileInput;
		Connection con = null;
		try {
			fileInput = new FileInputStream("C:\\Kajal\\connection.properties");
			Properties properties = new Properties();
			//Load Properties File
			properties.load(fileInput);
			//get data from properties using key
			String driverClass = properties.getProperty("driverClass");
			String url = properties.getProperty("url");
			String userName = properties.getProperty("userName");
			String password = properties.getProperty("password");
			
			Class.forName(driverClass);
			System.out.println("Driver found");
			con = DriverManager.getConnection(url, userName, password);
			System.out.println("Connection Established");
			
			
		} catch (IOException | SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;

	}

}
