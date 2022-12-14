package admin.java.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.java.entities.DetailProduct;
import admin.java.models.DetailProductModel;
import admin.java.utils.ServletUtils;


@WebServlet(urlPatterns= {"/DetailProductEditServlet","/CRUD/EDIT/DetailProductEditServlet"})
public class DetailProductEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		int idproduct = Integer.parseInt(request.getParameter("idproduct")) ;
		int idimage = Integer.parseInt(request.getParameter("idimage")) ;
		int soluong = Integer.parseInt(request.getParameter("soluong")) ;
  		String image =  request.getParameter("image");
  		String color =  request.getParameter("color");
  		
  		System.out.println(soluong);
  		DetailProduct product = new DetailProduct(idproduct, idimage, soluong, image, color);
    	

    	boolean check = DetailProductModel.update(product);
    	if(check)
    		System.out.println("succcess");
    	
    	ServletUtils.redirect("/DetailProductCURD", request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
