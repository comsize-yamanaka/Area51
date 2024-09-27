package model.entity;

import java.time.LocalDate;

/**
 * @author Shoko Shimada
 * 
 */
public class TaskListBean {
	
	/**
	 * タスクID
	 */
	private int taskId;
	
	
	/**
	 * タスク名
	 */
	private String taskName;
	
	/**
	 * カテゴリ情報
	 */
	private String categoryName;
	
	/**
	 * 期限
	 */
	private LocalDate limitDate;
	
	/**
	 * 担当者情報
	 */
	private String userName;
	
	/**
	 * ステータス情報
	 */
	private String statusName;
	
	/**
	 * メモ
	 */
	private String memo;

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public LocalDate getLimitDate() {
		return limitDate;
	}

	public void setLimitDate(LocalDate limitDate) {
		this.limitDate = limitDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

		
}
