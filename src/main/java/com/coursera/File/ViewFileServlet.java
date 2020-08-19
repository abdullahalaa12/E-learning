package com.coursera.File;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/Main/Course/ViewFile")
public class ViewFileServlet extends HttpServlet{
	
	private File FindFile(int FileID,ArrayList<File> Files)
	{
		for(int i=0;i<Files.size();i++)
		{
			if(Files.get(i).getFileID()==FileID)
				return Files.get(i);
		}
		return null;
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int FileID=Integer.parseInt(request.getParameter("FileID"));
		File file=FindFile(FileID,(ArrayList<File>)request.getSession().getAttribute("FilesArray"));
		if(file.getFileType().equals("Video"))
		{
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			byte[] buffer = new byte[4096];
			int bytesRead = -1;
			 
			while ((bytesRead = file.getUploadedFile().read(buffer)) != -1) {
			    outputStream.write(buffer, 0, bytesRead);
			}
			
			byte[] videoBytes = outputStream.toByteArray();
			 
			String Base64Video = "data:video/mp4;base64,"+Base64.getEncoder().encodeToString(videoBytes);
			request.setAttribute("Video", Base64Video);
			request.getRequestDispatcher("/WEB-INF/Pages/").forward(request, response);
		}
		else
		{
			response.setContentType(file.getFileType());
			response.addHeader("Content-disposition","attachment; filename=" + file.getFileTitle() );
			OutputStream outputStream = response.getOutputStream();
			byte[] buffer = new byte[4096];
			int bytesRead = -1;
			 
			while ((bytesRead = file.getUploadedFile().read(buffer)) != -1) {
			    outputStream.write(buffer, 0, bytesRead);
			}
			
		}
	}
	
}
