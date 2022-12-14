package admin.java.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import admin.java.entities.User;
import admin.java.utils.DbUtils;

public class UserModel {

	public static List<User> findAll() {
		final String query = "SELECT * FROM users ;";
		List<User> list = new ArrayList<User>();
		try {
			ResultSet rs = DbUtils.resultSet(query);
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUname(rs.getString("uname"));
				user.setUpwd(rs.getString("upwd"));
				user.setUemail(rs.getString("uemail"));
				user.setDiaChi(rs.getString("DiaChi"));
				user.setRole(rs.getString("role"));
				list.add(user);
				System.out.println(user.getDiaChi());
			}
			return list;
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static User findById(int id) {

		final String query = "SELECT * FROM users WHERE id = ?";
		User user = new User();
		try {
			PreparedStatement stmt = DbUtils.preparedStatement(query);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setUname(rs.getString("uname"));
				user.setUpwd(rs.getString("upwd"));
				user.setUemail(rs.getString("uemail"));
				user.setUmobile(rs.getString("umobile"));
				user.setDiaChi(rs.getString("DiaChi"));
				user.setRole(rs.getString("role"));
			}
			return user;
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static boolean add(User p) {
		final String query = "INSERT INTO users( uname, upwd, uemail, umobile, DiaChi , role) VALUES (?,?,?,?,?, ?)";

		try {
			PreparedStatement stmt = DbUtils.preparedStatement(query);
			stmt.setString(1, p.getUname());
			stmt.setString(2, p.getUpwd());
			stmt.setString(3, p.getUemail());
			stmt.setString(4, p.getUmobile());
			stmt.setString(5, p.getDiaChi());
			stmt.setString(6, p.getRole());
			stmt.executeUpdate();
			return true;
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static boolean update(User p) {
		final String query = "UPDATE users SET  uname = ?, upwd = ?,uemail = ?, umobile = ?, DiaChi = ?, role = ? WHERE id = ?";
		try {
			PreparedStatement stmt = DbUtils.preparedStatement(query);
			stmt.setString(1, p.getUname());
			stmt.setString(2, p.getUpwd());
			stmt.setString(3, p.getUemail());
			stmt.setString(4, p.getUmobile());
			stmt.setString(5, p.getDiaChi());
			stmt.setString(6, p.getRole());
			stmt.setInt(7, p.getId());
			stmt.executeUpdate();
			return true;
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

	}

	public static boolean delete(int id) {
		final String query = "delete from users where id =?";
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
