package com.jspider.jdbc_statement_curd_operation.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class DisplayAllStudentController {
	
	public static void main(String[] args) {
		
		Connection connection = null;
		
	try {
		//step-1 load/register driver software
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//step-2 create connection with mysql db
		String url = "jdbc:mysql://localhost:3306/jdbc-a10";
		String username = "root";
		String password = "Aman@124421";
		
	    connection =	DriverManager.getConnection(url, username, password);
		
		System.out.println(connection);
		
		//step-3 create statement 
		
		Statement statement=connection.createStatement();
		
		
		//step-4 execute Query 
		String displayQuery = "Select * from student";
				
		ResultSet resultSet = statement.executeQuery(displayQuery);
		
			while(resultSet.next()) {
				
				int id = resultSet.getInt("id");
			
				System.out.println("id = " + id);
			
			//	Date date=resultSet.getDate(id);
				
			//	LocalDate dob=date.toLocalDate()
				
				String name = resultSet.getString("name");
			
				LocalDate dob = resultSet.getDate(id).toLocalDate();
				
				System.out.println("dob = " +dob);
				
				}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			
		}
	
//		finally {
//			try {
//				connection.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
		
	}
}