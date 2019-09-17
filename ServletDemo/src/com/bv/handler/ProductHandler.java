package com.bv.handler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bv.connection.DBConnect;
import com.bv.model.Products;

public class ProductHandler {
	
	private static Connection con;
	
	public static int addProducts(Products products) {
		con = DBConnect.getConnection();
		int status = 0;
		String sql = "insert into products(productname,manufacturername,price) values(?,?,?)";
		try {
			PreparedStatement prestatement = con.prepareStatement(sql);
			prestatement.setString(1, products.getProductname());
			prestatement.setString(2, products.getManufacturername());
			prestatement.setDouble(3, products.getPrice());
			status = prestatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;				
	}
	
	public static int updateProducts(Products product) {
		con = DBConnect.getConnection();
		int status = 0;
		String sql = "update products set productname = ?,manufacturername = ?,price = ? where id = ? ";
		try {
			PreparedStatement prestatement = con.prepareStatement(sql);
			prestatement.setString(1, product.getProductname());
			prestatement.setString(2, product.getManufacturername());
			prestatement.setDouble(3, product.getPrice());
			prestatement.setInt(4, product.getId());
			status = prestatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	public static int deleteProdFromId(int productId) {
		con = DBConnect.getConnection();
		int status = 0;
		String sql = "delete from products  where id = ? ";
		try {
			PreparedStatement prestatement = con.prepareStatement(sql);
			prestatement.setInt(1, productId);

			status = prestatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	public static List<Products> getAllProducts(){
		List <Products> productList = new ArrayList<>();
		con = DBConnect.getConnection();
		String sql = "select* from products";
		try {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				Products product = new Products();

				product.setId(rs.getInt("id"));
				product.setProductname(rs.getString("productname"));
				product.setManufacturername(rs.getString("manufacturername"));
				product.setPrice(rs.getDouble(4));
				
				productList.add(product);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
	}
	
	public static Products getProductById(int productId) {
		con = DBConnect.getConnection();
		Products product = new Products();
		String sql = "select * from products  where id = ? ";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, productId);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				product.setId(rs.getInt("id"));
				product.setProductname(rs.getString("productname"));
				product.setManufacturername(rs.getString("manufacturername"));
				product.setPrice(rs.getDouble("price"));
				System.out.println(product.getManufacturername());

				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}
}
