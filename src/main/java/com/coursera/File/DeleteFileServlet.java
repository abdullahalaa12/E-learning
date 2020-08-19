package com.coursera.File;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.coursera.File.File;
import com.coursera.File.FileDAO;

@WebServlet(urlPatterns = "/Main/Course/DeleteFile")
public class DeleteFileServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int FileID=Integer.parseInt(request.getParameter("FileID"));
		FileDAO dao=new FileDAO();
		dao.Connect();
		dao.deleteFile(FileID);
		response.sendRedirect("/Main/Course");
	}
	
}
