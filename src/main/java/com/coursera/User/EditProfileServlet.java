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
@MultipartConfig(maxFileSize = 4194304)
public class EditProfileServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.sendRedirect("Main");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String column=request.getParameter("column");
		String value=request.getParameter("Value");
		User user=(User)request.getSession().getAttribute("Member");
		System.out.println(value);
		
		UserDAO dao=new UserDAO();

		switch(column)
		{
		case "Photo":
			Part Photo=request.getPart("Photo");
			dao.editPhoto(user.getId(),Photo);
			user.setPhoto(dao.getBase64Img(Photo.getInputStream()));
			break;
		case "FullName":
			dao.editfullname(user.getId(), value);
			user.setFullname(value);
			break;
		case "Email":
			if(dao.editEmail(user.getId(), value))
				user.setEmail(value);
			else
				request.setAttribute("Message", "this email already exists!");
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
		request.getRequestDispatcher("/WEB-INF/Pages/Main.jsp").forward(request, response);
	}
}