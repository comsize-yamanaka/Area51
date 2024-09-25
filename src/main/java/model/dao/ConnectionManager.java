package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * データベースに接続
 * @author Yuta Yamanaka
 */
public class ConnectionManager {
	private final static String URL = "jdbc:mysql://localhost:3306/task_db";
	private final static String USER = "root";
	private final static String PASSWORD = "root";
	
	/**
	 * 指定したURLのデータベースに接続
	 * @return データベースに接続(Connection型)
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
