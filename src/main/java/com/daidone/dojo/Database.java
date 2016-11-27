package com.daidone.dojo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	
	public static void inputStudent (String str1, String pass) throws ClassNotFoundException, SQLException{
		
		String url = Information.gettingURL();
		String username = Information.gettingUsername();
		String password = Information.gettingPassword();
		String query = Information.gettingQuery(str1, pass);
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(url, username, password);
		
		Statement st = con.createStatement();
		
		st.executeUpdate(query);
		
		st.close();
		con.close();
		
	}
	
	public static String gettingStudentInfo (String str1) throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://127.0.0.1:3306/movies";
		String username = "root";
		String password = "Frank452389";
		String query = Information.gettingQuery2(str1);
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(url, username, password);
		
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery(query);
		
		String str2 = "Student is not enrolled!";
		
		if (rs.next()) {
		
			String name = rs.getString("username");
			String pass = rs.getString("password");
		
			str2 = name + " " + pass;
		}
		
		st.close();
		con.close();
		
		return str2;

	}

}
