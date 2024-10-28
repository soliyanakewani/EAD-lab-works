package com.itsc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class JDBCDemo {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("MySQL JDBC Driver Registered!");
			
			String databaseURL = "jdbc:mysql://localhost:3306/student_db";
			String username = "root";
			String password = "Zoli3210#sql";
			Connection connection = DriverManager.getConnection(databaseURL,username, password );
		    
			System.out.println("connection established successfully");
			
		} catch (Exception e) { 
			e.printStackTrace();// TODO: handle exception 
		} 

		
		

	}

}
