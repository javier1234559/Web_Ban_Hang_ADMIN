package test;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import java.sql.Connection;

//import org.sql2o.Connection;
//import org.sql2o.Sql2o;

import admin.java.entities.Product;
import admin.java.models.ProductModel;
import admin.java.utils.*;


public class testmain {
	
	public static void main(String[] args) {
//		Sql2o sql2o = new Sql2o("jdbc:mysql://localhost:3306/shopkeyboard","root","nhat2382002");
//  		
//  		final String query = "SELECT * FROM product ORDER BY idproduct ;";  
//  		List<Product> list = new ArrayList<>();
//  		Connection con1 = sql2o.open();
//  		try(Connection con = sql2o.open()) {
//  			list =  con.createQuery(query).executeAndFetch(Product.class);
//  	    }
//  		System.out.print(list);
		
    	
//        final String query = "SELECT * FROM product ORDER BY idproduct ;"; 
//        List<Product> list = new ArrayList<Product>();
//        try {
////        	Class.forName("com.mysql.cj.jdbc.Driver");
////            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopkeyboard","root","nhat2382002");
////            System.out.print("Connnect to database successfully");
////            stmt = conn.prepareStatement(query);
////            ResultSet rs = stmt.executeQuery();
//        	ResultSet rs = DbUtils.resultSet(query);
//            while (rs.next()) {
//          	  Product product= new Product();
//	              product.setIdproduct(rs.getInt("idproduct"));
//	              product.setNameproduct(rs.getString("nameproduct"));
//	              product.setPrice(rs.getLong("price"));
//	              product.setCategory(rs.getString("category"));
//	              product.setImage(rs.getString("image"));
//	              product.setMoTa(rs.getString("MoTa"));
//	              list.add(product);
//            }
//        } catch (SQLException | ClassNotFoundException e) {
//            throw new RuntimeException(e);
//		 } 
//		List<Product> list = ProductModel.findAll();
//		
//  		for (Product product : list) {
//			System.out.print(product.image);
//		}
//  		System.out.println(list);
		
	
		int idproduct = 43;
		String nameproduct = "san pham cu";
		int price = 9999000;
		String category = "KEYCAP";
		String image = "/imgae";
		String MoTa = "DAY LA PHAN MO TA";
		Product product = new Product(idproduct, nameproduct, price, category, image, MoTa);

		ProductModel.delete(42);
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
