package com.coursera.File;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(urlPatterns = "/Main/Course/AddFile")
@MultipartConfig(maxFileSize = 16777216)
public class AddFileServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("/WEB-INF/Pages/").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		FileDAO dao=new FileDAO();
		dao.Connect();
		
		Part UploadedFile=request.getPart("UploadedFile");
		//String FileTitle=request.getParameter("FileTitle");
		//String FileType=request.getParameter("FileType");
		//int CourseID=(int)request.getSession().getAttribute("CourseID");
		System.out.println(UploadedFile.getName());
		System.out.println(UploadedFile.getContentType());
		//dao.addFile(UploadedFile, FileTitle, FileType, CourseID);
		response.sendRedirect("/Main/Course");
	}
}
