<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, java.util.List" %>
<%@ page import="model.entity.*, model.dao.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録完了</title>
</head>
<body>
	<h1>以下の情報を登録しました。</h1>
	<hr>
	<%
		TaskBean taskBean = (TaskBean)request.getAttribute("taskBean");
		
		CategoryDAO cateDAO = new CategoryDAO();
		StatusDAO statusDAO = new StatusDAO();
		UserDAO userDAO = new UserDAO();
	%>
	<table>
		<tr>
			<td>タスク名:</td>
			<td><%= taskBean.getTaskName() %></td>
		</tr>
		<tr>
			<td>カテゴリ情報:</td>
			<td><%= cateDAO.selectCategoryName(taskBean.getCategoryId()) %></td>
		</tr>
		<tr>
			<td>期限:</td>
			<td><%= taskBean.getLimitDate() %></td>
		</tr>
		<tr>
			<td>担当者:</td>
			<td><%= userDAO.selectUserName(taskBean.getUserId()) %></td>
		</tr>
		<tr>
			<td>ステータス情報:</td>
			<td><%= statusDAO.selectStatusName(taskBean.getStatusCode()) %></td>
		</tr>
		<tr>
			<td>メモ:</td>
			<td><%= taskBean.getMemo() %></td>
		</tr>
	</table>
</body>
</html>