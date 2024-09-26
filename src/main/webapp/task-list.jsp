<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List, model.entity.TaskListBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク一覧</title>
</head>
<body>

	<%
	List<TaskListBean> taskList = (List<TaskListBean>) session.getAttribute("taskList");
	
	%>

	<h1>タスク一覧</h1>
	<hr>

	<form action="TaskDetailServlet" method="GET">
	<table border="1">
		<tr>
			<th>タスク名</th>
			<th>カテゴリ情報</th>
			<th>期限</th>
			<th>担当者情報</th>
			<th>ステータス情報</th>
			<th>メモ</th>
		</tr>

		<%
		for (TaskListBean task : taskList) {
		%>
		<tr>
			<td><%=task.getTaskName()%></td>
			<td><%=task.getCategoryName()%></td>
			<td><%=task.getLimitDate()%></td>
			<td><%=task.getUserName()%></td>
			<td><%=task.getStatusName()%></td>
			<td><%=task.getMemo()%></td>
			<td><input type="submit" value="削除"></td>
		</tr>
		<%
		}
		%>

	</table>
	</form>

	<br>


	<!--仮にメニュー画面に飛ぶようにしてあります -->
	<div>
		<form action="menu.jsp" method="POST">
			<input type="submit" value="メニュー　本当はタスク編集画面">
		</form>
		
		<form action="task-delete.jsp" method="POST">
			<input type="submit" value="タスク削除画面">
		</form>
	</div>


</body>
</html>
