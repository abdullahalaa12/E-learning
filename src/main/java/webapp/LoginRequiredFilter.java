package webapp;

import javax.servlet.Filter;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns="/Main/*")
public class LoginRequiredFilter implements Filter{

	  @Override
	  public void init(javax.servlet.FilterConfig arg0) throws javax.servlet.ServletException
	  {
		  
	  }
	  
	  @Override
	  public void doFilter(javax.servlet.ServletRequest servletRequest,
			  javax.servlet.ServletResponse servletResponse, javax.servlet.FilterChain Chain) 
					  throws java.io.IOException, javax.servlet.ServletException
	  {
		  HttpServletRequest request=(HttpServletRequest)servletRequest;
		  
		  if(request.getSession().getAttribute("username")==null)
		  {
			  request.getRequestDispatcher("/login").forward(servletRequest, servletResponse);
		  }
		  else
		  {
			  Chain.doFilter(servletRequest, servletResponse);
		  }
	  }
	  
	  @Override
	  public void destroy()
	  {
		  
	  }
}
