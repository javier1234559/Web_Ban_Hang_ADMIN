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

import admin.java.entities.DetailProduct;
import admin.java.models.DetailProductModel;
import admin.java.utils.ServletUtils;


@WebServlet(urlPatterns = { "/DetailProductCURD", "/ADMIN/DetailProductCURD", "/DetailProductCURD/*" })
public class DetailProductCURD extends HttpServlet {
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
			List<DetailProduct> list = DetailProductModel.findAll();
			System.out.print(list);
			request.setAttribute("products", list);
			ServletUtils.forward("ADMIN/detailproduct.jsp", request, response);
			break;

		case "/Add":
			ServletUtils.redirect("/CRUD/ADD/adddetailproductform.jsp", request, response);
			break;
		case "/Edit":
			int id = 0;
			int idimage =  0 ;
			try {
				id = Integer.parseInt(request.getParameter("id"));
				idimage = Integer.parseInt(request.getParameter("idimage"));
			} catch (NumberFormatException e) {
			}
			System.out.print(id);
			System.out.print(idimage);
			DetailProduct c = DetailProductModel.findById(id,idimage);
			if (c != null) {
				HttpSession session = request.getSession();
				session.setAttribute("product", c);
				ServletUtils.redirect("/CRUD/EDIT/editdetailproductform.jsp", request, response);
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
