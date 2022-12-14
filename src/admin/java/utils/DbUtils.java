package admin.java.utils;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

public class DbUtils {
	private static final String DB_URL = "jdbc:mysql://b060c3fa72ae89:0e6af735@us-cdbr-east-06.cleardb.net/heroku_9921352427430fd?reconnect=true";
    private static final String ID = "b060c3fa72ae89";
    private static final String PASS = "0e6af735";
//	private static final String DB_URL = "jdbc:mysql://localhost:3306/shopkeyboard";
//	private static final String ID = "root";
//	private static final String PASS = "nhat2382002";

	public static Connection connection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(DB_URL, ID, PASS);
		System.out.print("Connnect to database successfully");
		return conn;
	}

	public static PreparedStatement preparedStatement(String query) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(DB_URL, ID, PASS);
		System.out.print("Connnect to database successfully");
		PreparedStatement stmt = conn.prepareStatement(query);
		return stmt;
	}

	public static ResultSet resultSet(String query) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(DB_URL, ID, PASS);
		System.out.print("Connnect to database successfully");
		PreparedStatement stmt = conn.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		return rs;
	}

}