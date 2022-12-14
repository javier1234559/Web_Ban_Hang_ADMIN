package main.java.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.entities.User;




/**
 * Servlet implementation class Login
 */
@WebServlet(urlPatterns = {"/login", "/Home/login"})
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uemail = request.getParameter("username");
		String upwd = request.getParameter("password");
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		
		if(uemail == null || uemail.equals("")) {
			request.setAttribute("status","invalidEmail" );
			dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
		if(upwd == null || upwd.equals("")) {
			request.setAttribute("status","invalidPassword" );
			dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		} 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://b060c3fa72ae89:0e6af735@us-cdbr-east-06.cleardb.net/heroku_9921352427430fd?reconnect=true","b060c3fa72ae89","0e6af735");
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopkeyboard","root","nhat2382002");
			PreparedStatement pst = con.prepareStatement("select * from users where uemail = ? and upwd = ?");
			pst.setString(1, uemail);
			pst.setString(2, upwd);
			
			
			ResultSet rs = pst.executeQuery();
			//System.out.print(rs.next());
			//System.out.print(rs.getString("uemail"));

			if(rs.next()) {
				session.setAttribute("name", rs.getString("uname"));
				//session.setAttribute("mail", rs.getString("uemail"));

				if(session.getAttribute("userSession")==null) {
				User User2 =new User(rs.getString("uname"),rs.getString("uemail"),rs.getInt("id"),rs.getString("umobile"),"");
					
				session.setAttribute("userSession",User2 );
				}
				
				
				dispatcher = request.getRequestDispatcher("index.jsp");
			}else {
				request.setAttribute("status", "failed");
				dispatcher = request.getRequestDispatcher("login.jsp");
			}
			dispatcher.forward(request, response);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
		RequestDispatcher dispatcher = null;

		dispatcher = req.getRequestDispatcher("login.jsp");
		dispatcher.forward(req, resp);
	}

}
