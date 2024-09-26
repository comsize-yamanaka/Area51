<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList, java.util.List, java.time.LocalDate" %>
<%@page import="model.entity.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="task-register.css" rel="stylesheet /">
<title>タスク登録</title>
</head>
<body>
	<h1>タスク登録画面</h1>
	<hr>
	<%
		@SuppressWarnings("unchecked")
		List<CategoryBean> categoryList = (List<CategoryBean>)request.getAttribute("categoryList");
		
		@SuppressWarnings("unchecked")
		List<StatusBean> statList = (List<StatusBean>)request.getAttribute("statusList");
		
		@SuppressWarnings("unchecked")
		List<UserBean> userList = (List<UserBean>)request.getAttribute("userList");
	%>
	<form action="TaskRegisterServlet" method="post">
	<table>
		<tr>
			<td>タスク名:</td>
			<td><input type="text" name="taskName" required></td>
		</tr>
		<tr>
			<td>カテゴリ情報:</td>
			<td>
				<select name="categoryId">
					<% for(CategoryBean cb : categoryList){ %>
						<option value="<%= cb.getCategoryId() %>"><%= cb.getCategoryName() %></option>
					<% } %>
				</select>
			</td>
		</tr>
		<tr>
			<td>期限:</td><!-- 期限の入力なしでも通るようにする -->
			<td><input type="date" min="<%= LocalDate.now() %>" name="limitDate"></td>
		</tr>
		<tr>
			<td>担当者:</td>
			<td>
				<select name="userId">
					<% for(UserBean userBean : userList){ %>
						<option value="<%= userBean.getUserId() %>"><%= userBean.getUserName() %></option>
					<% } %>
				</select>
			</td>
		</tr>
		<tr>
			<td>ステータス情報:</td>
			<td>
				<select name="statusCode">
					<% for(StatusBean sb : statList){ %>
						<option value="<%= sb.getStatusCode() %>"><%= sb.getStatusName() %></option>
					<% } %>
				</select>
			</td>
		</tr>
		<tr>
			<td>メモ:</td>
			<td><textarea name="memo" cols="20" rows="5"></textarea></td>
		</tr>
	</table>
	<input type="submit" value="登録">
	</form>
</body>
</html>