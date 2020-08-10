package webapp;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("/WEB-INF/Pages/Login.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 
       try {
    	   	
    	   	String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=testdb;integratedSecurity=true;";
    	   Connection conn= DriverManager.getConnection(dbURL);
				if (conn != null) {
	                System.out.println("Connected");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
		
		request.getRequestDispatcher("/WEB-INF/Pages/Welcome.jsp").forward(request, response);
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
