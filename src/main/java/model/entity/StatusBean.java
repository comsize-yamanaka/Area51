package model.entity;

import java.time.LocalDateTime;

/**
 * ステータス情報
 * @author Yuta Yamanaka
 */
public class StatusBean {
	
	/**
	 * ステータスコード
	 */
	private String statusCode;
	
	/**
	 * ステータス名
	 */
	private String statusName;
	
	/**
	 * 更新日時
	 */
	private LocalDateTime updateDatetime;

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
	 * ステータス名取得
	 * @return ステータス名
	 */
	public String getStatusName() {
		return statusName;
	}

	/**
	 * ステータス名設定
	 * @param statusName ステータス名
	 */
	public void setStatusName(String statusName) {
		this.statusName = statusName;
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