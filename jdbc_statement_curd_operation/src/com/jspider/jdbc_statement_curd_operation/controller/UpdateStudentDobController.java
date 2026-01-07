package com.jspider.jdbc_statement_curd_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class UpdateStudentDobController {
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
			String updateQuery = "update student set dob='2004-04-03', phone= 6306323085 where id=101";
					
			int a=statement.executeUpdate(updateQuery);
			
			if(a!=0) {
				System.out.println("data update");
			}
			else {
				System.out.println("something went wrong check your id");
			}
				
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}	
//			 finally {
//				try {
//					connection.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
				
			}
			
		}

}
