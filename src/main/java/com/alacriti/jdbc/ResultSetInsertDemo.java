package com.alacriti.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class ResultSetInsertDemo {
	public static void main(String args[])throws Exception
	{
		Connection con=DriverManager.getConnection("jdbc:mysql://192.168.35.160:3306/trainee17", "trainee17" , "trainee@alac");
		Statement smt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=smt.executeQuery("select * from pri");
		ResultSetMetaData rm=rs.getMetaData();
		while(rs.next())
		{
			System.out.print(rs.getInt(1) +"\t");
			System.out.println(rs.getString(2));
		}
		rs.moveToInsertRow();
		rs.updateInt(1, 12);
		rs.updateString(2, "seenu");
		rs.insertRow();
		System.out.println("After updating");
		rs=smt.executeQuery("select * from pri");
		while(rs.next())
		{
			System.out.print(rs.getInt(1) +"\t");
			System.out.println(rs.getString(2));
		}
	}
}
