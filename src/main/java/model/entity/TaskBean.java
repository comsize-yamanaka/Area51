package model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Yuta Yamanaka
 */
public class TaskBean {
	
	/**
	 * タスクID
	 */
	private int taskId;
	
	/**
	 * タスク名
	 */
	private String taskName;
	
	/**
	 * カテゴリID
	 */
	private int categoryId;
	
	/**
	 * 期限
	 */
	private LocalDate limitDate;
	
	/**
	 * ユーザID
	 */
	private String userId;
	
	/**
	 * ステータスコード
	 */
	private String statusCode;
	
	/**
	 * メモ
	 */
	private String memo;
	
	/**
	 * 登録日時
	 */
	private LocalDateTime createDatetime;
	
	/**
	 * 更新日時
	 */
	private LocalDateTime updateDatetime;

	/**
	 * タスクID取得
	 * @return タスクID
	 */
	public int getTaskId() {
		return taskId;
	}

	/**
	 * タスクID設定
	 * @param taskId タスクID
	 */
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	/**
	 * タスク名取得
	 * @return タスク名
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * タスク名設定
	 * @param taskName タスク名
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * カテゴリID取得
	 * @return カテゴリID
	 */
	public int getCategoryId() {
		return categoryId;
	}

	/**
	 * カテゴリID設定
	 * @param categoryId カテゴリID
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * 期限取得
	 * @return 期限
	 */
	public LocalDate getLimitDate() {
		return limitDate;
	}

	/**
	 * 期限設定
	 * @param limitDate 期限設定
	 * 
	 */
	public void setLimitDate(LocalDate limitDate) {
		this.limitDate = limitDate;
	}

	/**
	 * ユーザID取得
	 * @return ユーザID
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * ユーザID設定
	 * @param userId ユーザID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * ステータスコード取得
	 * @return ステータスコード
	 */
	public String getStatusCode() {
		return statusCode;
	}

	/**
	 * ステータスコード設定
	 * @param statusCode ステータスコード
	 */
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * メモ取得
	 * @return メモ
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * メモ設定
	 * @param memo メモ
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}

	/**
	 * 登録日時取得
	 * @return 登録日時
	 */
	public LocalDateTime getCreateDatetime() {
		return createDatetime;
	}

	/**
	 * 登録日時設定
	 * @param createDatetime 登録日時
	 */
	public void setCreateDatetime(LocalDateTime createDatetime) {
		this.createDatetime = createDatetime;
	}

	/**
	 * 更新日時取得
	 * @return 更新日時
	 */
	public LocalDateTime getUpdateDatetime() {
		return updateDatetime;
	}

	/**
	 * 更新日時設定
	 * @param updateDatetime 更新日時
	 */
	public void setUpdateDatetime(LocalDateTime updateDatetime) {
		this.updateDatetime = updateDatetime;
	}
}
