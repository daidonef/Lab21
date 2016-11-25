package com.daidone.dojo;

public class Information {
	
	public static String gettingURL () {
 		return "jdbc:mysql://127.0.0.1:3306/dojo";
 	}
 	
 	public static String gettingUsername () {
 		return "root";
 	}
 	
 	public static String gettingPassword () {
 		return "Frank452389";
 	}
 	
	public static String gettingQuery(String name, String password){
		
		String str1 = "insert into dojo.students(username, password)" + 
				"values (\"" + name + "\", \"" + password + "\")";
		
		return str1;
	}
	
	public static String gettingQuery2(String name){
		
		String str1 = "select * from dojo.students where username=\"" + name + "\"";
		
		return str1;
	}

}
