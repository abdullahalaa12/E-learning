package com.coursera.Course;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coursera.User.User;
import com.coursera.User.UserDAO;

@WebServlet(urlPatterns = "/Main/Course/Enroll")
public class CourseEnrollServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.sendRedirect("/Main");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int CourseID=Integer.parseInt(request.getParameter("CourseID"));
		UserDAO dao=new UserDAO();
		User user=(User)request.getSession().getAttribute("Member");
		
		//dao.enroll(CourseID,user.getId());
		user.setCourses(dao.ShowCourses(user.getId()));
		response.sendRedirect("/Main/Course");
	}
	
}
