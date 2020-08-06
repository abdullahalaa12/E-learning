package webapp;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("/WEB-INF/JSP/Main.jsp").forward(request, response);
		System.out.println("Get is called");
		System.out.println("Testing git");
		Service.Register("abdullah", "456");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		if(Service.LoginValidation(new User(name, password)))
		{
		request.setAttribute("name", name);
		request.setAttribute("password", password);
		request.getRequestDispatcher("/WEB-INF/JSP/Welcome.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("ErrorMsg","Invalid Username/passwor !!");
			request.getRequestDispatcher("/WEB-INF/JSP/Main.jsp").forward(request, response);
		}
		System.out.println("Post is called");
	}
}
