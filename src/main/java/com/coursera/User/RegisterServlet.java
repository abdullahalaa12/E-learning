package com.coursera.User;

import java.io.IOException;
import java.sql.Date;

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
		String BirthDay=request.getParameter("BirthDay");
		String BirthMonth=request.getParameter("BirthMonth");
		String BirthYear=request.getParameter("BirthYear");
		Part Photo=request.getPart("Photo");
		int Educationlevel=-10;
		String Company="Doesn't exist in the signup form";
		String Joptitle="Doesn't exist in the signup form";
		String Department="Doesn't exist in the signup form";
		String Website="Doesn't exist in the signup form";
		String TypeOfUser=request.getParameter("TypeOfUser");
		String Gender=request.getParameter("Gender");

		
		boolean valid=DAO.Singup(Email, Password, FirstName, LastName, Nationality, Phone, BirthDay,
				BirthMonth,BirthYear,Photo, Educationlevel, Company, Joptitle, Department, Website, TypeOfUser,Gender);
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