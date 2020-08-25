package com.coursera.Course;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.coursera.User.User;
import com.coursera.User.UserDAO;



@WebServlet(urlPatterns = "/Main/Course/AddCourse")
@MultipartConfig(maxFileSize = 4194304)
public class AddCourseServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("/WEB-INF/Pages/Main.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		User user=(User)request.getSession().getAttribute("Member");
		UserDAO dao=new UserDAO();

		String CourseName=request.getParameter("CourseName");
		String CourseField=request.getParameter("CourseName");
		
		String StartDay=request.getParameter("StartDay");
		String StartMonth=request.getParameter("StartMonth");
		String StartYear=request.getParameter("StartYear");
		
		String EndDay=request.getParameter("EndDay");
		String EndMonth=request.getParameter("EndMonth");
		String EndYear=request.getParameter("EndYear");
		Part Photo=request.getPart("Photo");
		
		dao.AddCourse(user.getId(), CourseName, CourseField, LocalDate.of(Integer.parseInt(StartYear), Integer.parseInt(StartMonth), Integer.parseInt(StartDay)), 
				LocalDate.of(Integer.parseInt(EndYear), Integer.parseInt(EndMonth), Integer.parseInt(EndDay)), new Date(2000,1,1));
		user.setCourses(dao.ShowCourses(user.getId()));
	}
}