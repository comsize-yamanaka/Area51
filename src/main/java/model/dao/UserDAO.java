package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.UserBean;


/**
 * m_userテーブルのDAO
 * @author Yuta Yamanaka
 */
public class UserDAO {
	
	/**
	 * ログイン判定
	 * @param userId
	 * @param password
	 * @return ログインしたユーザ情報
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	
	public UserBean loginJudge(String userId, String password) throws SQLException, ClassNotFoundException {
		UserBean ub = new UserBean();

		try (Connection con = ConnectionManager.getConnection()) {

			String sql = "SELECT * FROM m_user WHERE user_id = ? AND password = ?";

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, password);

			ResultSet res = pstmt.executeQuery();
			res.next();
			
			ub.setUserId(res.getString("user_id"));
			ub.setPassword(res.getString("password"));
			ub.setUserName(res.getString("user_name"));
			ub.setUpdateDateTime(res.getTimestamp("update_datetime").toLocalDateTime());
		}

		return ub;
	}
	
	public List<UserBean> selectAll() throws SQLException, ClassNotFoundException{
		List<UserBean> userList = new ArrayList<>();
		String sql = "SELECT * FROM m_user";
		
		try(Connection con = ConnectionManager.getConnection()) {
			Statement stmt = con.createStatement();
			
			ResultSet res = stmt.executeQuery(sql);
			while(res.next()) {
				UserBean ub = new UserBean();
				ub.setUserId(res.getString("user_id"));
				ub.setPassword(res.getString("password"));
				ub.setUserName(res.getString("user_name"));
				ub.setUpdateDateTime(res.getTimestamp("update_datetime").toLocalDateTime());
				userList.add(ub);
			}
		}
		
		return userList;
	}
}
