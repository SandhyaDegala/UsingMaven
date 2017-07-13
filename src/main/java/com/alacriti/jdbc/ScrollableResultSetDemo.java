package com.alacriti.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ScrollableResultSetDemo {
	public static void main(String args[])throws Exception
	{
		Connection con=DriverManager.getConnection("jdbc:mysql://192.168.35.160:3306/trainee17", "trainee17" , "trainee@alac");
		Statement smt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=smt.executeQuery("select * from pri");
		while(rs.next())
		{
			System.out.print(rs.getInt(1) +"\t");
			System.out.println(rs.getString(2));
		}
		rs.absolute(4);
		int rowno=rs.getRow();
		System.out.println("the row no is:"+rowno);
		rs.relative(-2);
		rowno=rs.getRow();
		System.out.println("the row no is:"+rowno);
		rs.relative(2);
		rowno=rs.getRow();
		System.out.println("the row no is:"+rowno);
		rs.absolute(1);
		rowno=rs.getRow();
		System.out.println("the row no is:"+rowno);
		rs.isAfterLast(); 
		System.out.println("After !isAfterLast");
		
		if (!rs.isAfterLast()) {
			int id = rs.getInt("id"); 
			String name= rs.getString("name");
			
			System.out.println(id+"  "+name);
			/*while(rs.next()) {
			int id = rs.getInt("id"); 
			String name= rs.getString("name");
			
			System.out.println(id+"  "+name);
		}*/
		}
		rs.afterLast();
		System.out.println("after afterLast");
		while (rs.previous()) {
			int id = rs.getInt("id"); 
			String name= rs.getString("name");
			
			System.out.println(id+"  "+name);
		
		}
	}
}
