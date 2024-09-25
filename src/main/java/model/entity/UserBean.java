package model.entity;

import java.util.Date;

/**
 * @author Yuta Yamanaka
 * 
 */
public class UserBean {
	/**
	 * ユーザID
	 */
	private String userId;
	/**
	 * パスワード
	 */
	private String password;
	/**
	 * ユーザ名
	 */
	private String userName;
	/**
	 * 更新日時
	 */
	private Date updateDateTime;
	
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
	 * パスワード取得
	 * @return パスワード
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * パスワード設定
	 * @param password パスワード
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * ユーザ名取得
	 * @return　ユーザ名
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * ユーザ名設定
	 * @param userName ユーザ名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * 更新日時取得
	 * @return
	 */
	public Date getUpdateDateTime() {
		return updateDateTime;
	}
	
	/**
	 * 更新日時設定
	 * @param updateDateTime 更新日時
	 */
	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}
}
