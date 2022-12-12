package test;

import java.util.ArrayList;
import java.util.List;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import admin.java.entities.Product;
import admin.java.models.ProductModel;



public class testmain {
	
	public static void main(String[] args) {
		Sql2o sql2o = new Sql2o("jdbc:mysql://localhost:3306/shopkeyboard","root","nhat2382002");
  		
  		final String query = "SELECT * FROM product ORDER BY idproduct ;";  
  		List<Product> list = new ArrayList<>();
  		Connection con1 = sql2o.open();
  		try(Connection con = sql2o.open()) {
  			list =  con.createQuery(query).executeAndFetch(Product.class);
  	    }
  		System.out.print(list);
	
//		int idproduct = 1;
//		String nameproduct = "8888888";
//		int price = 888888;
//		String category = "KEYCAP";
//		String image = "/imgae";
//		String MoTa = "DAY LA PHAN MO TA";
//		Product product = new Product(idproduct, nameproduct, price, category, image, MoTa);
//		
//		ProductModel.update(product);
//		
//		List<Product> list  = ProductModel.findAll();
//		
//	    System.out.print(list);
//		
//		for (Product p : list) {
//			System.out.print(p.getNameproduct());
//		}
	}
		
}
