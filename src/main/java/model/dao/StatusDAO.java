package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.StatusBean;

/**
 * @author Yuta Yamanaka
 */

/**
 * m_statusテーブルのDAO
 */
public class StatusDAO {
	
	/**
	 * m_statusテーブルのレコードを全て取得
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<StatusBean> selectAll() throws SQLException, ClassNotFoundException{
		List<StatusBean> statusList = new ArrayList<>();
		
		try(Connection con = ConnectionManager.getConnection()) {
			String sql = "SELECT * FROM m_status";
			Statement stmt = con.createStatement();
			
			ResultSet res = stmt.executeQuery(sql);
			while(res.next()) {
				StatusBean statBean = new StatusBean();
				statBean.setStatusCode(res.getString("status_code"));
				statBean.setStatusName(res.getString("status_name"));
				statBean.setUpdateDatetime(res.getTimestamp("update_datetime").toLocalDateTime());
				statusList.add(statBean);
			}
		}
		return statusList;
	}
	
	/**
	 * ステータスコードを指定して、ステータス名を取得
	 * @param statusCode
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public String selectStatusName(String statusCode) throws SQLException, ClassNotFoundException{
		String statusName = "";
		String sql = "SELECT * FROM m_status WHERE status_code = ?";
		
		try(Connection con = ConnectionManager.getConnection()) {
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, statusCode);
			
			ResultSet res = pstmt.executeQuery();
			
			//ステータスコードに対応するステータス名がないとき
			if(res.equals(null)) {
				
			}else {
				res.next();
				statusName = res.getString("status_name");
			}
		}
		
		return statusName;
	}
}
