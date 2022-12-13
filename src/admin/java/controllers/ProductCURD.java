package admin.java.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import admin.java.entities.Product;
import admin.java.models.ProductModel;
import admin.java.utils.ServletUtils;

@WebServlet(urlPatterns = { "/ProductCURD", "/ADMIN/ProductCURD", "/ProductCURD/*" })
public class ProductCURD extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getPathInfo();
		System.out.println(path);

		if (path == null || path.equals("/")) {
			path = "/Index";
		}

		switch (path) {
		case "/Index":
			List<Product> list = ProductModel.findAll();
			System.out.print(list);
			request.setAttribute("products", list);
			ServletUtils.forward("ADMIN/product.jsp", request, response);
			break;

		case "/Add":
			ServletUtils.redirect("/CRUD/ADD/addproductform.jsp", request, response);
			break;
		case "/Edit":
			int id = 0;
			try {
				id = Integer.parseInt(request.getParameter("id"));
			} catch (NumberFormatException e) {
			}
			System.out.print(id);
			Product c = ProductModel.findById(id);
			if (c != null) {
				HttpSession session = request.getSession();
				session.setAttribute("product", c);
				ServletUtils.redirect("/CRUD/EDIT/editproductform.jsp", request, response);
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
