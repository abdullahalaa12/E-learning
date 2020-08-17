package com.coursera.Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coursera.Service.Course;
import com.coursera.Service.User;
import com.coursera.Service.UserDAO;
import com.coursera.Service.UserInteract;

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
		UserInteract UI = new UserInteract();
		UI.Connect();
		ArrayList<Course> courses =	UI.ShowCourses(user);
		if(courses.size() != 0)
		{
			request.setAttribute("Courses", courses);
		}
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
		
		
			
			/*try {
    	   	
    	   	String DataBaseURL = "jdbc:sqlserver://localhost:1433;databaseName=testdb;integratedSecurity=true;";
    	   	Connection conn= DriverManager.getConnection(DataBaseURL);
			if (conn != null) {
				System.out.println("Connected");
			}
            
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("select * from Video");
			for(int i=0;i<7;i++) rs.next();
			
			Blob blob = rs.getBlob("File");
			response.setContentType("application/vnd.openxmlformats-officedocument.presentationml.presentation");
			//response.setHeader("Content-disposition","attachment; filename=" + "Example.pptx" );
			response.addHeader("Content-Disposition", "attachment; filename=" + "Example.pptx");
			InputStream inputStream = blob.getBinaryStream();
			OutputStream outputStream = response.getOutputStream();
			byte[] buffer = new byte[4096];
			int bytesRead = -1;
			 
			while ((bytesRead = inputStream.read(buffer)) != -1) {
			    outputStream.write(buffer, 0, bytesRead);
			}
			 
			
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
	}
}
