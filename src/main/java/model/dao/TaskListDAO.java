package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.entity.TaskBean;
import model.entity.TaskListBean;

/**
 *
 * @author Shoko Shimada
 * m_user,m_category,m_status,t_taskにアクセスするDAO
 */

public class TaskListDAO {

	/**
	 *タスク一覧を返します
	 * @return タスク一覧　taskList
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<TaskListBean> selectAll()
			throws SQLException, ClassNotFoundException {

		List<TaskListBean> taskList = new ArrayList<TaskListBean>();
		String sql = "SELECT t1.task_id,t1.task_name, t2.category_name, t1.limit_date, t3.user_name, t4.status_name, t1.memo FROM t_task t1 inner join m_category t2 on t1.category_id = t2.category_id inner join m_user t3 on t1.user_id = t3.user_id inner join m_status t4 on t1.status_code = t4.status_code;";

		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery(sql)) {

			//結果を操作??
			while (res.next()) {
				int taskId = res.getInt("task_id");
				String taskName = res.getString("task_name");
				String categoryName = res.getString("category_name");

				LocalDate limitDate;
				if (res.getDate("limit_date") == null) {
					limitDate = null;
				} else {
					limitDate = res.getDate("limit_date").toLocalDate();
				}

				String userName = res.getString("user_name");
				String statusName = res.getString("status_name");
				String memo = res.getString("memo");//????

				TaskListBean task = new TaskListBean();
				task.setTaskId(taskId);
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
	 * 指定されたタスクを削除処理します
	 * @author Shoko Shimada
	 * @param taskId
	 * @return 処理件数
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int deleteTask(int taskId) throws SQLException, ClassNotFoundException {

		String sql = "DELETE FROM t_task WHERE task_id = ?;";
		int processingNumber = 0; //処理件数
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			// プレースホルダへの値の設定
			pstmt.setInt(1, taskId);
			processingNumber = pstmt.executeUpdate();
		}
		return processingNumber;
	}

	/**
	 * 指定されたタスクIDのタスクを1件返します
	 * @param taskId
	 * @return 処理件数
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public TaskListBean selectTask(int taskId) throws SQLException, ClassNotFoundException {

		String sql = "SELECT t1.task_id,t1.task_name, t2.category_name, t1.limit_date, t3.user_name, t4.status_name, t1.memo FROM t_task t1 inner join m_category t2 on t1.category_id = t2.category_id inner join m_user t3 on t1.user_id = t3.user_id inner join m_status t4 on t1.status_code = t4.status_code where task_id=?;";

		TaskListBean taskDetail = new TaskListBean();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			// プレースホルダへの値の設定
			pstmt.setInt(1, taskId);

			// SQLステートメントの実行
			ResultSet res = pstmt.executeQuery();

			//結果を操作??
			while (res.next()) {
				String taskName = res.getString("task_name");
				String categoryName = res.getString("category_name");
				LocalDate limitDate;
				if (res.getDate("limit_date") == null) {
					limitDate = null;
				} else {
					limitDate = res.getDate("limit_date").toLocalDate();
				}
				String userName = res.getString("user_name");
				String statusName = res.getString("status_name");
				String memo = res.getString("memo");
				
				taskDetail.setTaskName(taskName);
				taskDetail.setCategoryName(categoryName);
				taskDetail.setLimitDate(limitDate);
				taskDetail.setUserName(userName);
				taskDetail.setStatusName(statusName);
				taskDetail.setMemo(memo);
			}
			
		}
		return taskDetail;
	}

	/**
	 * タスク登録処理
	 * @param taskBean
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int taskRegister(TaskBean taskBean) throws SQLException, ClassNotFoundException {
		int count = 0;
		String sql = "";

		if (taskBean.getLimitDate() != null) {
			sql = "INSERT INTO task_db.t_task(task_name, category_id, limit_date, user_id, status_code, memo, create_datetime, update_datetime) "
					+ "VALUES(?,?,?,?,?,?,?,?);";

			try (Connection con = ConnectionManager.getConnection()) {
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

		} else {
			sql = "INSERT INTO task_db.t_task(task_name, category_id, user_id, status_code, memo, create_datetime, update_datetime) "
					+ "VALUES(?,?,?,?,?,?,?);";

			try (Connection con = ConnectionManager.getConnection()) {
				PreparedStatement pstmt = con.prepareStatement(sql);

				pstmt.setString(1, taskBean.getTaskName());
				pstmt.setInt(2, taskBean.getCategoryId());
				pstmt.setString(3, taskBean.getUserId());
				pstmt.setString(4, taskBean.getStatusCode());
				pstmt.setString(5, taskBean.getMemo());
				pstmt.setTimestamp(6, Timestamp.valueOf(LocalDateTime.now()));
				pstmt.setTimestamp(7, Timestamp.valueOf(LocalDateTime.now()));

				count = pstmt.executeUpdate();
			}
		}

		return count;
	}

	/**
	 * タスク編集処理
	 * @param taskBean
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int updateTask(TaskBean taskBean2, int taskId) throws SQLException, ClassNotFoundException {
		int count = 0;
		String sql = "";
		
			sql = "update t_task set "
					+ "task_name =?,category_id=?,limit_date=?,user_id=?,status_code=?,memo=?,create_datetime=?, update_datetime=? where task_id=?;";

			try (Connection con = ConnectionManager.getConnection()) {
				PreparedStatement pstmt = con.prepareStatement(sql);

				pstmt.setString(1, taskBean2.getTaskName());
				pstmt.setInt(2, taskBean2.getCategoryId());
				
				//nullかチェック
				if (taskBean2.getLimitDate() != null) {
					pstmt.setDate(3, java.sql.Date.valueOf(taskBean2.getLimitDate()));
				}else {
					pstmt.setDate(3, null);
				}
				
				pstmt.setString(4, taskBean2.getUserId());
				pstmt.setString(5, taskBean2.getStatusCode());
				pstmt.setString(6, taskBean2.getMemo());
				pstmt.setTimestamp(7, Timestamp.valueOf(LocalDateTime.now()));
				pstmt.setTimestamp(8, Timestamp.valueOf(LocalDateTime.now()));
				pstmt.setInt(9, taskId);

				count = pstmt.executeUpdate();
			}

		
		return count;
	}

	//	public int updateTask(TaskListBean itemResult,int taskId)
	//			throws SQLException, ClassNotFoundException {
	//		int processingNumber = 0; //処理件数
	//
	//		String sql = "UPDATE m_item SET item_name = ?, category_code = ?, price = ? WHERE item_code = ?";
	//
	//		try (Connection con = ConnectionManager.getConnection();
	//				PreparedStatement pstmt = con.prepareStatement(sql);) {
	//			// プレースホルダへの値の設定
	//			pstmt.setString(1, itemResult.getItemName());
	//			pstmt.setInt(2, itemResult.getCategoryCode());
	//			pstmt.setInt(3, itemResult.getPrice());
	//			pstmt.setInt(4, itemResult.getItemCode());
	//			processingNumber = pstmt.executeUpdate();
	//		}
	//		return processingNumber;
	//	}
	//	

}
