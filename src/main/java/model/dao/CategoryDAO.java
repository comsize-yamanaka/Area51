package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	
	/**
	 * m_categoryテーブルのレコードを全て取得
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
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
	
	/**
	 * 指定したカテゴリIDに対応するカテゴリ名を取得
	 * @param categoryId
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public String selectCategoryName(int categoryId) throws SQLException, ClassNotFoundException{
		String categoryName = "";
		String sql = "SELECT * FROM m_category WHERE category_id = ?";
		try(Connection con = ConnectionManager.getConnection()) {
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, categoryId);
			
			ResultSet res = pstmt.executeQuery();
			
			//指定したカテゴリIDに対応するカテゴリ名がないとき
			if(res.equals(null)) {
				
			}else {
				res.next();
				categoryName = res.getString("category_name");
			}
		}
		
		return categoryName;
	}
}
