package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.StatusBean;

/**
 * @author Yuta Yamanaka
 */
public class StatusDAO {
	
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
}
