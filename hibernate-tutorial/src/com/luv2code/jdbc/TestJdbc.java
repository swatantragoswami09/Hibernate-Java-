package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;



public class TestJdbc {

	public static void main(String[] args) {
		String jdbcUrl="jdbc:mysql://localhost:3306/hibernate_db?useSSL=false";
		String user="root";
		String pass="root";
		try {
			System.out.println("Connecting to Database :" + jdbcUrl);
			Connection myConn = DriverManager.getConnection(jdbcUrl,user,pass);
			
			System.out.println("Connection successfull!");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("not connected");
		}

	}

}
