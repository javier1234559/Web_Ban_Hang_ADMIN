package admin.java.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import admin.java.utils.DbUtils;
import admin.java.entities.Product;

public class ProductModel {

	public static List<Product> findAll() {
		final String query = "SELECT * FROM product ORDER BY idproduct ;";
		List<Product> list = new ArrayList<Product>();
		try {
			ResultSet rs = DbUtils.resultSet(query);
			while (rs.next()) {
				Product product = new Product();
				product.setIdproduct(rs.getInt("idproduct"));
				product.setNameproduct(rs.getString("nameproduct"));
				product.setPrice(rs.getLong("price"));
				product.setCategory(rs.getString("category"));
				product.setImage(rs.getString("image"));
				product.setMoTa(rs.getString("MoTa"));
				list.add(product);
			}
			return list;
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static Product findById(int id) {

		final String query = "SELECT * FROM product WHERE idproduct =?";
		Product product = new Product();
		try {
			PreparedStatement stmt = DbUtils.preparedStatement(query);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				product.setIdproduct(rs.getInt("idproduct"));
				product.setNameproduct(rs.getString("nameproduct"));
				product.setPrice(rs.getLong("price"));
				product.setCategory(rs.getString("category"));
				product.setImage(rs.getString("image"));
				product.setMoTa(rs.getString("MoTa"));
			}
			return product;
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static boolean add(Product p) {
		final String query = "INSERT INTO product( nameproduct, price, category, image, MoTa) VALUES (?,?,?,?,?)";

		try {
			PreparedStatement stmt = DbUtils.preparedStatement(query);
			stmt.setString(1, p.getNameproduct());
			stmt.setLong(2, p.getPrice());
			stmt.setString(3, p.getCategory());
			stmt.setString(4, p.getImage());
			stmt.setString(5, p.getMoTa());
			stmt.executeUpdate();
			return true;
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static boolean update(Product p) {
		final String query = "UPDATE product SET  nameproduct = ?, price = ?, category = ?, image = ?, MoTa = ? WHERE idproduct = ?";
		try {
			PreparedStatement stmt = DbUtils.preparedStatement(query);
			stmt.setString(1, p.getNameproduct());
			stmt.setLong(2, p.getPrice());
			stmt.setString(3, p.getCategory());
			stmt.setString(4, p.getImage());
			stmt.setString(5, p.getMoTa());
			stmt.setInt(6, p.getIdproduct());
			stmt.executeUpdate();
			return true;
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

	}

	public static boolean delete(int id) {
		final String query = "delete from product where idproduct =?";
		try {
			PreparedStatement stmt = DbUtils.preparedStatement(query);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			return true;
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);

		}
	}
}