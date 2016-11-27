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
		
		String fullname = request.getParameter("lastname") + ", " + request.getParameter("firstname");
		String username1 = request.getParameter("username1");
		String pass1 = request.getParameter("password");
		
		model.addAttribute("firstname", request.getParameter("firstname"));
		model.addAttribute("lastname", request.getParameter("lastname"));
		model.addAttribute("fullname", fullname);
		model.addAttribute("username1", username1);
		model.addAttribute("email", request.getParameter("email"));
		model.addAttribute("dojo", request.getParameter("dojo"));
		model.addAttribute("passdojo", request.getParameterValues("passdojo"));
		
		try {
			Database.inputStudent(username1, pass1);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return "home";
	}
	
	@RequestMapping(value = "/owner", method = RequestMethod.POST)
	public String ownerinfo(Model model, HttpServletRequest request) {
		
		model.addAttribute("ownername", request.getParameter("ownername"));
		
		return "ownerinfo";
	}
	
	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public String studentinfo(Model model, HttpServletRequest request) {
		
		String student = request.getParameter("studentuser");
		String studentInfo = "";
		
		try {
			studentInfo = Database.gettingStudentInfo(student);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		model.addAttribute("student", student);
		model.addAttribute("info", studentInfo);
		
		return "studentinfo";
	}
	
}
