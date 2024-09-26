package model.entity;

import java.time.LocalDateTime;

/**
 * @author Shoko Shimada
 * 
 */
public class TaskListBean {
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
	private LocalDateTime limitDate;
	
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

	public LocalDateTime getLimitDate() {
		return limitDate;
	}

	public void setLimitDate(LocalDateTime limitDate) {
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