package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.entity.TaskBean;
import model.entity.TaskListBean;

/**
 * @author Shoko Shimada
 * @author Yuta Yamanaka
 */
public class TaskListDAO {
	
	public List<TaskListBean> selectAll()
			throws SQLException, ClassNotFoundException {

		List<TaskListBean> taskList = new ArrayList<TaskListBean>();
		String sql = "SELECT t1.task_name, t2.category_name, t1.limit_date, t3.user_name, t4.status_name, t1.memo FROM t_task t1 inner join m_category t2 on t1.category_id = t2.category_id inner join m_user t3 on t1.user_id = t3.user_id inner join m_status t4 on t1.status_code = t4.status_code;";	
		
		
		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery(sql)) {

			//結果を操作??
			while (res.next()) {
				String taskName = res.getString("task_name");
				String categoryName = res.getString("category_name");
				LocalDateTime limitDate = res.getTimestamp("limit_date").toLocalDateTime();
				String userName = res.getString("user_name");
				String statusName = res.getString("status_name");
				String memo = res.getString("memo");//????
				
				TaskListBean task = new TaskListBean();
				task.setTaskName(taskName);//
				task.setCategoryName(categoryName);
				task.setLimitDate(limitDate);
				task.setUserName(userName);
				task.setStatusName(statusName);
				task.setMemo(memo);

				taskList.add(task);
			}
		}
		return taskList;
	}
	
	/**
	 * 新規タスク登録処理
	 * @param taskBean
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int taskRegister(TaskBean taskBean) throws SQLException, ClassNotFoundException{
		int count = 0;
		String sql = "INSERT INTO task_db.t_task(task_name, category_id, limit_date, user_id, status_code, memo, create_datetime, update_datetime) "
				+ "VALUES(?,?,?,?,?,?,?,?);";
		
		try(Connection con = ConnectionManager.getConnection()) {
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, taskBean.getTaskName());
			pstmt.setInt(2, taskBean.getCategoryId());
			pstmt.setDate(3, java.sql.Date.valueOf(taskBean.getLimitDate()));
			pstmt.setString(4, taskBean.getUserId());
			pstmt.setString(5, taskBean.getStatusCode());
			pstmt.setString(6, taskBean.getMemo());
			pstmt.setTimestamp(7, Timestamp.valueOf(LocalDateTime.now()));
			pstmt.setTimestamp(8, Timestamp.valueOf(LocalDateTime.now()));
			
			count = pstmt.executeUpdate();
		}
		
		return count;
	}
	
	/**
	 * タスク編集処理
	 * @param taksBean
	 * @return
	 */
	public int taskUpdate(TaskBean taksBean) {
		int count = 0;
		
		return count;
	}

}
