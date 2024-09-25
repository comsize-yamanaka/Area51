<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー</title>
</head>
<body>
	<h1>メニュー画面</h1>
	<hr>
	<%@ include file="header.jsp" %><br>
	<input type="submit" value="タスク登録"><br>
	
	<form action="TaskListServlet" method="GET">
	<input type="submit" value="タスク一覧"><br>
	</form>
	
	<input type="submit" value="ログアウト"><br>
</body>
</html>