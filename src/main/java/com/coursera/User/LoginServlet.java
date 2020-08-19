package com.coursera.User;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("/WEB-INF/Pages/Login.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String email=request.getParameter("name");
		String password=request.getParameter("password");
		
		UserDAO DAO=new UserDAO();
		DAO.Connect();
		User user = DAO.Login(email, password);
		if(user != null)
		{
			request.getSession().setAttribute("Member", user);
			response.sendRedirect("Main");
		}
		else
		{
			request.setAttribute("Message", "Invalid Email/Password !");
			request.getRequestDispatcher("/WEB-INF/Pages/Login.jsp").forward(request, response);
		}
			
	}
}
