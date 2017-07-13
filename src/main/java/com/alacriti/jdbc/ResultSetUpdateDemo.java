package com.alacriti.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetUpdateDemo {
public static void main(String args[])throws SQLException
{
	Connection con=DriverManager.getConnection("jdbc:mysql://192.168.35.160:3306/trainee17", "trainee17" , "trainee@alac");
	Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	ResultSet rs=stmt.executeQuery("select * from pri where id=3");
	ResultSetMetaData rsmd=rs.getMetaData();
	int n = rsmd.getColumnCount();
	System.out.println("before update values");
	while(rs.next())
	{
		System.out.println(rs.getInt(1));
		System.out.println(rs.getString(2));
	}
	/*int m=stmt.executeUpdate("update pri set name=\"sonu\" where id=2");
	System.out.println();
	 rs=stmt.executeQuery("select * from pri");*/
	rs.moveToInsertRow();
	//rs.first();
	rs.updateInt(1, 6);
	//rs.updateString(2, "abc");
	rs.insertRow();
	/*rs.updateString(2, "jgfua");
	
	rs.updateRow();
*/
	//ResultSetMetaData rsmd1=rs.getMetaData();
	
	/*while(rs.next())
	{
		System.out.println(rs.getInt(1));
		System.out.println(rs.getString(2));
	}*/
}
}
