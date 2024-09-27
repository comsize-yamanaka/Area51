<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.TaskListBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除タスク確認画面</title>
</head>
<body>

	<%
		TaskListBean taskDetail = (TaskListBean) session.getAttribute("taskDetail");
	%>
	<h1>削除タスク確認画面</h1>
	<hr>
	
	以下のタスクを削除しますか？
	<table border="1">
		<tr>
			<th>タスク名</th>
			<td><%=taskDetail.getTaskName()%></td>
		</tr>
		<tr>
			<th>カテゴリ情報</th>
			<td><%=taskDetail.getCategoryName()%></td>
		</tr>
		<tr>
			<th>期限</th>
			<td><%=taskDetail.getLimitDate()%></td>
		</tr>
		<tr>
			<th>担当者情報</th>
			<td><%=taskDetail.getUserName()%></td>
		</tr>
		<tr>
			<th>ステータス情報</th>
			<td><%=taskDetail.getStatusName()%></td>
		</tr>
			<tr>
			<th>メモ</th>
			<td><%=taskDetail.getMemo()%></td>
		</tr>
		
	</table>
	<br>
	<table>
	<tr>
	
	<td>

		
		<form action="TaskDeleteServlet" method="POST"><input type ="hidden" name= "taskId" value="<%=taskDetail.getTaskId()%>"><input type="submit" value="削除"></form></td>
		
	
	</td>
	
	<td>
	<form action="TaskListServlet" method="GET">
		<input type="submit" value="一覧表示">
	</form>
	</td>
	</tr>
	</table>
</body>
</html>