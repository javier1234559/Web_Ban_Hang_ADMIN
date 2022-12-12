package admin.java.models;


import java.util.List;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import admin.java.utils.DbUtils;
import admin.java.entities.*;

public class ProductModel {
	
	public static List<Product> findAll() {	
	    final String query = "SELECT * FROM product ORDER BY idproduct ;";	
	    
	    Connection con1 = DbUtils.getConnection();
	    try (Connection con = DbUtils.getConnection()) {
	      return con.createQuery(query).executeAndFetch(Product.class);
	    }catch(Exception e){
	    	return null ;
	    }
	  }

	public static Product findById(int id) {
	    final String query = "select * from product where idproduct = :idproduct";
	    try (Connection con = DbUtils.getConnection()) {
	      List<Product> list = con.createQuery(query).addParameter("idproduct", id).executeAndFetch(Product.class);

	      if (list.size() == 0) {
	        return null;
	      }

	      return list.get(0);
	    }
	  }

	public static void add(Product p) {
	    String insertSql = "INSERT INTO product( nameproduct, price, category, image, MoTa) VALUES (:nameproduct,:price,:category,:image,:MoTa)";
	    try (Connection con = DbUtils.getConnection()) {
	      con.createQuery(insertSql)
	        //.addParameter("idproduct", p.getIdproduct())
	        .addParameter("nameproduct",p.getNameproduct())
	        .addParameter("price", p.getPrice())
	        .addParameter("category", p.getPrice())
	        .addParameter("image", p.getImage())
	        .addParameter("MoTa", p.getMoTa())
	        .executeUpdate();
	    }
	  }

	  public static void update(Product p) {
	    String sql = "UPDATE product SET  nameproduct = :nameproduct, price = :price, category = :category, image = :image, MoTa = :MoTa WHERE idproduct = :idproduct";
	    try (Connection con = DbUtils.getConnection()) {
	      con.createQuery(sql)
	      .addParameter("nameproduct",p.getNameproduct())
	        .addParameter("price", p.getPrice())
	        .addParameter("category", p.getPrice())
	        .addParameter("image", p.getImage())
	        .addParameter("MoTa", p.getMoTa())
	        .addParameter("idproduct", p.getIdproduct())
	        .executeUpdate();
	    }
	  }

	  public static void delete(int id) {
	    String sql = "delete from product where idproduct = :idproduct";
	    try (Connection con = DbUtils.getConnection()) {
	      con.createQuery(sql)
	        .addParameter("idproduct", id)
	        .executeUpdate();
	    }
	  }
	}