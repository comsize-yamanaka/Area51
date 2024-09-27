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
			
			
			<%	if(task.getLimitDate()== null ){ %>
			<td><pre>   </pre></td>
			<%
				}else{
			%>
			<td><%=task.getLimitDate()%></td>
			<%} %>
			
			
			<td><%=task.getUserName()%></td>
			<td><%=task.getStatusName()%></td>
			<td><%=task.getMemo()%></td>
			<td><%=task.getTaskId()%></td>
			<td><form action="TaskDetailServlet" method="GET"><input type ="hidden" name= "task_id" value="<%=task.getTaskId()%>"><input type="submit" value="削除"></form></td>
		</tr>
		<%
		}
		%>

	</table>


	<br>


	<!--仮にメニュー画面に飛ぶようにしてあります -->
	<div>
		<form action="menu.jsp" method="POST">
			<input type="submit" value="メニュー　本当はタスク編集画面">
		</form>
		
	</div>


</body>
</html>
