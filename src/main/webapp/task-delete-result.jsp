<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.TaskListBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク削除結果</title>
</head>
<body>
<h1>タスク削除結果</h1>
<hr>



<%
		TaskListBean taskResult = (TaskListBean) session.getAttribute("taskDetail");
		int processingNumber = (Integer) request.getAttribute("processingNumber");
		if (processingNumber > 0) {
	%>
	<h2>次のデータを削除しました。</h2>
	<br>
	<br>
	<table border="1">
		<tr>
			<th>タスクID</th>
			<td><%=taskResult.getTaskName()%></td>
		</tr>
		<tr>
			<th>カテゴリ情報</th>
			<td><%=taskResult.getCategoryName()%></td>
		</tr>
		<tr>
			<th>期限</th>
			<td><%=taskResult.getLimitDate()%></td>
		</tr>
		<tr>
			<th>担当者情報</th>
			<td><%=taskResult.getUserName()%></td>
		</tr>
		<tr>
			<th>ステータス情報</th>
			<td><%=taskResult.getStatusName()%></td>
		</tr>
		<tr>
			<th>メモ</th>
			<td><%=taskResult.getMemo()%></td>
		</tr>
	</table>

	<%
		} else {
	%>
	<h2>次のデータを削除できませんでした。</h2>
	<br>
	<br>
	<table border="1">
		<tr>
			<th>タスクID</th>
			<td><%=taskResult.getTaskName()%></td>
		</tr>
		<tr>
			<th>カテゴリ情報</th>
			<td><%=taskResult.getCategoryName()%></td>
		</tr>
		<tr>
			<th>期限</th>
			<td><%=taskResult.getLimitDate()%></td>
		</tr>
		<tr>
			<th>担当者情報</th>
			<td><%=taskResult.getUserName()%></td>
		</tr>
		<tr>
			<th>ステータス情報</th>
			<td><%=taskResult.getStatusName()%></td>
		</tr>
		<tr>
			<th>メモ</th>
			<td><%=taskResult.getMemo()%></td>
		</tr>
	</table>
	<%
		}
	%>
	<br>
	<form action="menu.jsp" method="POST">
		<input type="submit" value="メニュー画面へ">
	</form>


</body>
</html>