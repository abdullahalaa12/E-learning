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


@WebServlet(urlPatterns = "/EditProfile")
public class EditProfileServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("/WEB-INF/Pages/Main.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String column=request.getParameter("column");
		String value=request.getParameter("Value");
		User user=(User)request.getSession().getAttribute("Member");
		System.out.println(value);
		
		UserDAO dao=new UserDAO();
		dao.Connect();
		switch(column)
		{
		case "FullName":
			dao.editfullname(user.getId(), value);
			user.setFullname(value);
			break;
		case "Email":
			dao.editEmail(user.getId(), value);
			user.setEmail(value);
			break;
		case "Password":
			dao.editPassword(user.getId(), value);
			user.setPassword(value);
			break;
		case "Phone":
			dao.editPhone(user.getId(), value);
			user.setPhone(value);
			break;
		case "Website":
			dao.editWebsite(user.getId(), value);
			user.setWebsite(value);
			break;
		case "Company":
			dao.editCompany(user.getId(), value);
			user.setCompany(value);
			break;
		case "Joptitle":
			dao.editJoptitle(user.getId(), value);
			user.setJoptitle(value);
			break;
		case "Department":
			dao.editDepartment(user.getId(), value);
			user.setDepartment(value);
			break;
		default:
			System.out.println("Error edit");

		}
		response.sendRedirect("Main");
	}
}