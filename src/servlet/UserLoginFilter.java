package servlet;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
   
public class UserLoginFilter extends HttpServlet implements javax.servlet.Filter {    
   
  private static final long serialVersionUID = 1L;    
   
  public void doFilter(ServletRequest request, ServletResponse response,    
      FilterChain chain) throws ServletException, IOException {    
    HttpServletRequest req = (HttpServletRequest) request;    
    HttpServletResponse res = (HttpServletResponse) response;    
    HttpSession session = req.getSession();    
   
    if (session.getAttribute("user") == null) {      
      res.sendRedirect("userlogin.jsp");    
      return;    
    } else {    
      chain.doFilter(request, response);    
    }    
   
  }    
   
  public void init(FilterConfig filterConfig) {    
    System.out.println("OnlineFilter initialized.");    
  }    
   
  public void destroy() {    
    System.out.println("OnlineFilter destroied");    
  }    
   
}    
