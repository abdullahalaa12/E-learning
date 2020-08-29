package com.coursera.User;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet(urlPatterns = "/Register")
@MultipartConfig(maxFileSize = 4194304)
public class RegisterServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("/WEB-INF/Pages/SignUp.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		UserDAO DAO=new UserDAO();

		String Email=request.getParameter("Email");
		String Password=request.getParameter("Password");
		String FirstName=request.getParameter("FirstName");
		String LastName=request.getParameter("LastName");
		String Nationality=request.getParameter("Nationality");
		String Phone=request.getParameter("Phone");
		Part Photo=request.getPart("Photo");
		int Educationlevel=-10;
		String TypeOfUser=request.getParameter("TypeOfUser");
		String Gender=request.getParameter("Gender");
		LocalDate BirthDate=LocalDate.parse(request.getParameter("Birthday"));
		
		boolean valid=DAO.Singup(Email, Password, FirstName, LastName, Nationality, Phone, BirthDate,
				Photo, Educationlevel, TypeOfUser,Gender);
		if(valid==true)
		{
			System.out.println("Registerd");
			response.sendRedirect("login");
		}
		else
		{
			request.setAttribute("Message", "invlaid data!");
			request.getRequestDispatcher("/WEB-INF/Pages/SignUp.jsp").forward(request, response);
		}
	}
}