package com.daidone.dojo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/enroll", method = RequestMethod.POST)
	public String home(Model model, HttpServletRequest request) {
		
		model.addAttribute("firstname", request.getParameter("firstname"));
		model.addAttribute("lastname", request.getParameter("lastname"));
		model.addAttribute("email", request.getParameter("email"));
		model.addAttribute("dojo", request.getParameter("dojo"));
		model.addAttribute("passdojo", request.getParameterValues("passdojo"));
		
		try {
			database();
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return "home";
	}
	
	public static void database () throws ClassNotFoundException, SQLException{
		
		String url = "jdbc:mysql://127.0.0.1:3306/dojo";
		String username = "root";
		String password = "Frank452389";
		String query = gettingQuery();
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(url, username, password);
		
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery(query);
		
		st.close();
		con.close();
		
	}
	
	public static String gettingQuery(){
		
		String name = "tank";
		String password = "Frank";
		
		
		String str1 = "insert into students(username, password)" + 
				"values (\"" + name + ", " + password + ")\"";
		
		return str1;
	}
	
}
