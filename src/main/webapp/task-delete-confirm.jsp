<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.TaskListBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク削除確認</title>
</head>
<body>

<%
	TaskListBean itemDetail = (TaskListBean) session.getAttribute("itemDetail");
	%>

<h1>タスク削除確認</h1>
<hr>

</body>
</html>