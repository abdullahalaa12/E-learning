package com.coursera.Course;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coursera.User.User;

@WebServlet(urlPatterns = "/Main")
public class MainServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		CourseDAO dao=new CourseDAO();
		User user=(User)request.getSession().getAttribute("Member");
		ArrayList<Course> array=dao.ShowCourses(user.getId());
		request.setAttribute("CoursesArray", array);
		request.getRequestDispatcher("/WEB-INF/Pages/Main.jsp").forward(request, response);
	}
	
}
