package admin.java.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.java.entities.Product;
import admin.java.models.ProductModel;
import admin.java.utils.ServletUtils;

@WebServlet(urlPatterns= {"/ProductAddServlet","/CRUD/ADD/ProductAddServlet"})
public class ProductAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	//int idproduct = Integer.parseInt(request.getParameter(""));
		int idproduct = 1 ;
  		String nameproduct = request.getParameter("nameproduct");
  		long price = Long.parseLong(request.getParameter("price"));
  		String category =  request.getParameter("category");
  		String image =  request.getParameter("image");
  		String MoTa =  request.getParameter("description");
  		Product product = new Product(idproduct, nameproduct, price, category, image, MoTa);
    	
    	
    	boolean check = ProductModel.add(product);
    	if(check)
    		System.out.println("succcess");
    	
    	ServletUtils.redirect("/ProductCURD", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
