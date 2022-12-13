package admin.java.utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletUtils {
	public static void forward(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    RequestDispatcher rd = request.getRequestDispatcher(url);
	    System.out.println(url);
	    rd.forward(request, response);
	  }

	  public static void redirect(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.sendRedirect(request.getContextPath() + url);
	  }
	  
//	  public static void Contextforward(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		  System.out.println(request.getContextPath() );  
//		  System.out.println("-------" );  
//		  System.out.print(request.getContextPath() + url );  
//		  RequestDispatcher rd = request.getRequestDispatcher(url);
//		    rd.forward(request, response);
//		  }

}
