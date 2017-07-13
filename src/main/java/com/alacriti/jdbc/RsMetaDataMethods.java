package com.alacriti.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class RsMetaDataMethods {
	public static void main(String args[])throws SQLException
	{
		Connection con=DriverManager.getConnection("jdbc:mysql://192.168.35.160:3306/trainee17", "trainee17" , "trainee@alac");
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from Employee");
		ResultSetMetaData rsmd=rs.getMetaData();
		int numberOfColumns = rsmd.getColumnCount();
		System.out.println("number of columns :"+numberOfColumns );
		String colName;
		String tableName ;
		String name ;
		boolean caseSen;
		boolean writable;
		for (int i = 1; i <= numberOfColumns; i++) { 
			 colName = rsmd.getColumnName(i); 
			 tableName = rsmd.getTableName(i);
			name = rsmd.getColumnTypeName(i);
			caseSen = rsmd.isCaseSensitive(i);
		 writable = rsmd.isWritable(i); 
		
		System.out.println("Information for column " + colName);
		System.out.println(" Column is in table " + tableName); 
		System.out.println(" DBMS name for type is " + name); 
		System.out.println(" Is case sensitive: " + caseSen); 
		System.out.println(" Is possibly writable: " + writable); 
		System.out.println("");
		}
		
		}
	
}
