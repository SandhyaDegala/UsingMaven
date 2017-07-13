package com.alacriti.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TypeConcurrencyDemo {
	public static void main(String args[])throws Exception
	{
		Connection con=DriverManager.getConnection("jdbc:mysql://192.168.35.160:3306/trainee17", "trainee17" , "trainee@alac");
		Statement smt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=smt.executeQuery("select * from pri");
		int type = rs.getType();
		System.out.println("rs is type " + type); 
		int concur =rs.getConcurrency();
		System.out.println("rs has concurrency " + concur);
		while(rs.next())
		{
			int id=rs.getInt(1);
			String name=rs.getString(2);
			System.out.println(id+"  "+name);
		}
    }
}
