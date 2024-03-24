package control;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;


public class SessionTimeoutFilter implements Filter {

	  private static final int SESSION_TIMEOUT_MINUTES = 1; // Set timeout to 1 minute

	  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	    HttpServletRequest httpRequest = (HttpServletRequest) request;
	    HttpServletResponse httpResponse = (HttpServletResponse) response;

	    HttpSession session = httpRequest.getSession(false); // Don't create a new session

	    if (session != null && session.isNew()) {
	      // Session timed out, redirect to login
	      session.invalidate();
	      httpResponse.sendRedirect(httpRequest.getContextPath() + "/loginn.jsp");
	      return;
	    } else if (session != null) {
	      // Check for inactivity using lastAccessedTime
	      long lastAccessedTime = session.getLastAccessedTime();
	      long currentMillis = System.currentTimeMillis();
	      long inactiveInterval = currentMillis - lastAccessedTime;

	      if (inactiveInterval > (SESSION_TIMEOUT_MINUTES * 60 * 1000)) {
	        // Session timed out due to inactivity, redirect to login
	        session.invalidate();
	        httpResponse.sendRedirect(httpRequest.getContextPath() + "/loginn.jsp");
	        return;
	      }
	    }

	    chain.doFilter(request, response); // Continue with request processing
	  }

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	  // Other filter lifecycle methods (init, destroy)
	}
