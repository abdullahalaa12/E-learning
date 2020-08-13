package webapp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(urlPatterns = "/login")
//@MultipartConfig(maxFileSize = 16177215)
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("/WEB-INF/Pages/Welcome.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		/*InputStream FileStream=null;
		Part FilePart=request.getPart("photo");
		if (FilePart != null) {
            // prints out some information for debugging
			System.out.println("File part work");
            System.out.println(FilePart.getName());
            System.out.println(FilePart.getSize());
            System.out.println(FilePart.getContentType());
             
            // obtains input stream of the upload file
            FileStream = FilePart.getInputStream();
        }
       try {
    	   	
    	   	String DataBaseURL = "jdbc:sqlserver://localhost:1433;databaseName=testdb;integratedSecurity=true;";
    	   	Connection conn= DriverManager.getConnection(DataBaseURL);
			if (conn != null) {
				System.out.println("Connected");
			}
			
			
			PreparedStatement st=conn.prepareStatement("INSERT INTO Video ([File]) values (?)");
			if(FileStream!=null)st.setBlob(1, FileStream);
			System.out.println(st.executeUpdate()+" : Rows affected");
			
			st.close();
			conn.close();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		
			/*try {
    	   	
    	   	String DataBaseURL = "jdbc:sqlserver://localhost:1433;databaseName=testdb;integratedSecurity=true;";
    	   	Connection conn= DriverManager.getConnection(DataBaseURL);
			if (conn != null) {
				System.out.println("Connected");
			}
            
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("select * from Video");
			for(int i=0;i<6;i++) rs.next();
			
			Blob blob = rs.getBlob("File");
			InputStream inputStream = blob.getBinaryStream();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			byte[] buffer = new byte[4096];
			int bytesRead = -1;
			 
			while ((bytesRead = inputStream.read(buffer)) != -1) {
			    outputStream.write(buffer, 0, bytesRead);
			}
			 
			byte[] imageBytes = outputStream.toByteArray();
			 
			String base64Image = Base64.getEncoder().encodeToString(imageBytes);
			request.setAttribute("photo", base64Image);
			inputStream.close();
			outputStream.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		
			try {
    	   	
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
			}
			
			
		/*String name=request.getParameter("name");
		String password=request.getParameter("password");
		if(Service.LoginValidation(new User(name, password)))
		{
		request.setAttribute("name", name);
		request.setAttribute("password", password);
		request.getRequestDispatcher("/WEB-INF/Pages/Welcome.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("ErrorMsg","Invalid Username/password !!");
			request.getRequestDispatcher("/WEB-INF/Pages/Login.jsp").forward(request, response);
		}
		System.out.println("Post is called");*/
	}
}
