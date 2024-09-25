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
	<form>
		<input type="submit" formaction="TaskRegisterServlet" formmethod="get" value="タスク登録"><br>
		<input type="submit" formaction="TaskListServlet" formmethod="get" value="タスク一覧"><br>
		<input type="submit" formaction="LogoutServlet" formmethod="post" value="ログアウト"><br>
	</form>
</body>
</html>