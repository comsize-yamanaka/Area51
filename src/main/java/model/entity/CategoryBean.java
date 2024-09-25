package model.entity;

import java.time.LocalDateTime;

/**
 * カテゴリ情報
 * @author Yuta Yamanaka
 */
public class CategoryBean {
	
	/**
	 * カテゴリID
	 */
	private int categoryId;
	
	/**
	 * カテゴリ名
	 */
	private String categoryName;
	
	/**
	 * 更新日時
	 */
	private LocalDateTime updateDatetime;

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
	 * カテゴリ名取得
	 * @return カテゴリ名
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * カテゴリ名設定
	 * @param categoryName カテゴリ名
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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
