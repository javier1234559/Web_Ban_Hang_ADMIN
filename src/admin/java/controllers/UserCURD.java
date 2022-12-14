package admin.java.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.java.entities.User;
import admin.java.models.UserModel;
import admin.java.utils.ServletUtils;

@WebServlet(urlPatterns = { "/UserCURD", "/ADMIN/UserCURD", "/UserCURD/*" })
public class UserCURD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String path = request.getPathInfo();
		System.out.println(path);

		if (path == null || path.equals("/")) {
			path = "/Index";
		}

		switch (path) {
		case "/Index":
			List<User> list = UserModel.findAll();
			System.out.print(list);
			request.setAttribute("users", list);
			ServletUtils.forward("ADMIN/user.jsp", request, response);
			break;

		case "/Add":
			ServletUtils.redirect("/CRUD/ADD/adduserform.jsp", request, response);
			break;
		case "/Edit":
			int id = 0;
			try {
				id = Integer.parseInt(request.getParameter("id"));
			} catch (NumberFormatException e) {
			}
			System.out.print(id);
			User c = UserModel.findById(id);
			if (c != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", c);
				ServletUtils.redirect("/CRUD/EDIT/edituserform.jsp", request, response);
			} else {
				ServletUtils.forward("/Index", request, response);
			}
			break;

		default:
			System.out.println(request.getRequestURI());
			ServletUtils.redirect("/ADMIN/Error404.html", request, response);
			break;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
