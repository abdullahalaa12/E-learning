package com.coursera.Course;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coursera.User.User;
import com.coursera.User.UserDAO;


@WebServlet(urlPatterns = "/Main/Course/DeleteCourse")
public class DeleteCourseServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int CourseID=Integer.parseInt(request.getParameter("CourseID"));
		UserDAO dao=new UserDAO();
		User user=(User)request.getSession().getAttribute("Member");
		System.out.println(CourseID);
		
		dao.DeleteCourse(CourseID);
		user.setCourses(dao.ShowCourses(user.getId()));
		response.sendRedirect("/Main");
	}
	
}
