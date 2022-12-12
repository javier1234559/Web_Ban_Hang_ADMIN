package admin.java.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.sql2o.Connection;
import org.sql2o.Sql2o;

import admin.java.entities.Product;
import admin.java.models.ProductModel;
import admin.java.utils.ServletUtils;


@WebServlet(urlPatterns = {"/ProductCURD", "/ADMIN/ProductCURD"})
public class ProductCURD extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hellllllo");
		String path = request.getPathInfo();
	    if (path == null || path.equals("/")) {
	      path = "/Index";
	    }

	    switch (path) {
	      case "/Index":
//	       List<Product> list = ProductModel.findAll();
	    	  
	    	Sql2o sql2o = new Sql2o("jdbc:mysql://localhost:3306/shopkeyboard","root","nhat2382002");
	  		
	  		final String query = "SELECT * FROM product ORDER BY idproduct ;";  
	  		List<Product> list = new ArrayList<>();
	  		Connection con1 = sql2o.open();
	  		try(Connection con = sql2o.open()) {
	  			list =  con.createQuery(query).executeAndFetch(Product.class);
	  	    }
	  		System.out.print(list);
	  		
//	    	int idproduct = 1;
//	  		String nameproduct = "8888888";
//	  		int price = 888888;
//	  		String category = "KEYCAP";
//	  		String image = "/imgae";
//	  		String MoTa = "DAY LA PHAN MO TA";
//	  		Product product = new Product(idproduct, nameproduct, price, category, image, MoTa);
//	    	List<Product> list =  new ArrayList<Product>();
//	    	
//	    	list.add(product)  ;
//	    	
	    	
	        request.setAttribute("products", list);
	        ServletUtils.forward("ADMIN/product.jsp", request, response);
	        break;

	      // case "/Add":
	      //   ServletUtils.forward("/views/vwCategory/Add.jsp", request, response);
	      //   break;
	      //
	      // case "/Edit":
	      //   int id = 0;
	      //   try {
	      //     id = Integer.parseInt(request.getParameter("id"));
	      //   } catch (NumberFormatException e) {
	      //   }
	      //
	      //   Category c = CategoryModel.findById(id);
	      //   if (c != null) {
	      //     request.setAttribute("category", c);
	      //     ServletUtils.forward("/views/vwCategory/Edit.jsp", request, response);
	      //   } else {
	      //     ServletUtils.redirect("/Admin/Category", request, response);
	      //     // ServletUtils.forward("/views/204.jsp", request, response);
	      //   }
	      //   break;

	      default:
	        ServletUtils.forward("/ADMIN/404.jsp", request, response);
	        break;
	    }
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
