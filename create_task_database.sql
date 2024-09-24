/* DB 作成 */
DROP DATABASE IF EXISTS task_db;
CREATE DATABASE task_db CHARACTER SET utf8 COLLATE utf8_general_ci;

/* AUTOCOMMIT無効 */
SET AUTOCOMMIT=0;

/* DB選択 */
USE task_db;

/* 既存テーブルがある場合は削除 */
DROP TABLE IF EXISTS task_db.m_user;
DROP TABLE IF EXISTS task_db.m_category;
DROP TABLE IF EXISTS task_db.m_status;
DROP TABLE IF EXISTS task_db.t_task;


/* ユーザマスタ作成 */
CREATE TABLE task_db.m_user
(
    user_id             VARCHAR(24) NOT NULL,
    password            VARCHAR(32) NOT NULL,
    user_name           VARCHAR(20) NOT NULL,
    update_detetime     TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY         (user_id),
    UNIQUE KEY          (user_name)
);

/* カテゴリマスタ作成 */
CREATE TABLE task_db.m_category
(
    category_id         INT NOT NULL AUTO_INCREMENT,
    category_name       VARCHAR(20) NOT NULL,
    update_datetime     TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY         (category_id),
    UNIQUE KEY          (category_name)
);

/* ステータスマスタ作成 */
CREATE TABLE task_db.m_status
(
    status_code         CHAR(2) NOT NULL,
    status_name         VARCHAR(20) NOT NULL,
    update_datetime     TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY         (status_code),
    UNIQUE KEY          (status_name)
);

/* タスクマスタ作成 */
CREATE TABLE task_db.t_task
(
    task_id             INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    task_name           VARCHAR(50) NOT NULL,
    category_id         INT NOT NULL,
    limit_date          DATE,
    user_id             VARCHAR(24) NOT NULL,
    status_code         CHAR(2) NOT NULL,
    memo                VARCHAR(100),
    create_datetiime    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_datetime     TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY(category_id) REFERENCES task_db.m_category(category_id),
    FOREIGN KEY(user_id) REFERENCES task_db.m_user(user_id),
    FOREIGN KEY(status_code) REFERENCES task_db.m_status(status_code)
);
