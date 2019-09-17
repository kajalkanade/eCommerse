package com.bv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bv.connection.DBConnect;

public class LoginDao {

	public static boolean validateUser(String userName, String password) {
		
		boolean status = false;
		String sql = "select ACC_USER_NAME, ACC_PASSWORD from Logindetails where ACC_USER_NAME = ? and ACC_PASSWORD = ?";
		Connection con = DBConnect.getConnection();
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next())
				status = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
}
