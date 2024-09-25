package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.CategoryBean;

/**
 * m_categoryテーブルのDAO
 * @author Yuta Yamanaka
 */
public class CategoryDAO {
	
	public List<CategoryBean> selectAll() throws SQLException, ClassNotFoundException{
		List<CategoryBean> categoryList = new ArrayList<>();
		
		try(Connection con = ConnectionManager.getConnection()) {
			String sql = "SELECT * FROM m_category";
			Statement stmt = con.createStatement();
			
			ResultSet res = stmt.executeQuery(sql);
			while(res.next()) {
				CategoryBean cateBean = new CategoryBean();
				cateBean.setCategoryId(res.getInt("category_id"));
				cateBean.setCategoryName(res.getString("category_name"));
				cateBean.setUpdateDatetime(res.getTimestamp("update_datetime").toLocalDateTime());
				categoryList.add(cateBean);
			}
		}
		return categoryList;
	}
}
