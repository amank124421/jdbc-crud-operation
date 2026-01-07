package com.jspider.jdbc_statement_curd_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class InsertStudentController {
	public static void main(String[] args) {
		
		Connection connection=null;
		
		try {
			//step-1 load/register driver software
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step-2 create connection with mysql db
			String url = "jdbc:mysql://localhost:3306/jdbc-a10";
			String username = "root";
			String password = "Aman@124421";
			
		    connection =	DriverManager.getConnection(url, username, password);
			
			
			System.out.println(connection);
			
			//create statement 
			
			Statement statement=connection.createStatement();
			
			
			//execute Query 
			String insertStudentQuery = "insert into student(id,name,email,phone,dob) values(104,'ankur','ankurkumar@gmail.com', 918383000388,'2004-04-02')";
					
			int a=statement.executeUpdate(insertStudentQuery);
			
			String msg = a!=0?"executed":"not executed";
			System.out.println(msg);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
