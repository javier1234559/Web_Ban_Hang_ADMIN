package admin.java.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import admin.java.entities.DetailProduct;
import admin.java.utils.DbUtils;

public class DetailProductModel {

	public static List<DetailProduct> findAll() {
		final String query = "SELECT * FROM image_product ;";
		List<DetailProduct> list = new ArrayList<DetailProduct>();
		try {
			ResultSet rs = DbUtils.resultSet(query);
			while (rs.next()) {
				DetailProduct product = new DetailProduct();
				product.setIdproduct(rs.getInt("idproduct"));
				product.setIdimage(rs.getInt("idimage"));
				product.setSoluong(rs.getInt("soluong"));
				product.setImage(rs.getString("image"));
				product.setColor(rs.getString("color"));
				list.add(product);
			}
			return list;
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static DetailProduct findById(int id, int idimage) {

		final String query = "SELECT * FROM image_product where idproduct = ? and idimage = ? ";
		DetailProduct product = new DetailProduct();
		try {
			PreparedStatement stmt = DbUtils.preparedStatement(query);
			stmt.setInt(1, id);
			stmt.setInt(2, idimage);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				product.setIdproduct(rs.getInt("idproduct"));
				product.setIdimage(rs.getInt("idimage"));
				product.setSoluong(rs.getInt("soluong"));
				product.setImage(rs.getString("image"));
				product.setColor(rs.getString("color"));
			}
			return product;
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static boolean add(DetailProduct p) {
		final String query = "INSERT INTO image_product( idproduct, idimage, soluong, image, color) VALUES (?,?,?,?,?)";

		try {
			PreparedStatement stmt = DbUtils.preparedStatement(query);
			stmt.setInt(1, p.getIdproduct());
			stmt.setInt(2, p.getIdimage());
			stmt.setInt(3, p.getSoluong());
			stmt.setString(4, p.getImage());
			stmt.setString(5, p.getColor());
			stmt.executeUpdate();
			return true;
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static boolean update(DetailProduct p) {
		final String query = "UPDATE image_product SET  idproduct = ?, idimage = ?,"
				+ " soluong = ?, image = ?, color = ? WHERE idproduct = ? and idimage = ? ";
		try {
			PreparedStatement stmt = DbUtils.preparedStatement(query);
			stmt.setInt(1, p.getIdproduct());
			stmt.setInt(2, p.getIdimage());
			stmt.setInt(3, p.getSoluong());
			stmt.setString(4, p.getImage());
			stmt.setString(5, p.getColor());
			stmt.setInt(6, p.getIdproduct());
			stmt.setInt(7, p.getIdimage());
			stmt.executeUpdate();
			return true;
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

	}

	public static boolean delete(int id, int idimage) {
		final String query = "delete from image_product where idproduct =? and idimage = ?";
		try {
			PreparedStatement stmt = DbUtils.preparedStatement(query);
			stmt.setInt(1, id);
			stmt.setInt(2, idimage);
			stmt.executeUpdate();
			return true;
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);

		}
	}
}
