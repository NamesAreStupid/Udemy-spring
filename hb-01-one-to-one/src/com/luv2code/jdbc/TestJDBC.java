package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.StreamSupport;

public class TestJDBC {

	
	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost/hb_student_tracker?useSSL=false";
		String user ="hbstudent";
		String pass= "hbstudent";
		try {			Connection con = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("success");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
}
