package admin.java.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.java.entities.User;
import admin.java.models.UserModel;
import admin.java.utils.ServletUtils;


@WebServlet(urlPatterns= {"/UserAddServlet","/CRUD/ADD/UserAddServlet"})
public class UserAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = 0 ;
  		String uname = request.getParameter("uname");
  		String upwd =request.getParameter("upwd");
  		String uemail =  request.getParameter("uemail");
  		String umobile =  request.getParameter("umobile");
  		String DiaChi =  request.getParameter("DiaChi");
  		String role =  request.getParameter("role");
  		User user = new User(id, uname, upwd, uemail, umobile, DiaChi ,role);
    	
    	
    	boolean check = UserModel.add(user);
    	if(check)
    		System.out.println("succcess");
    	
    	ServletUtils.redirect("/UserCURD", request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
