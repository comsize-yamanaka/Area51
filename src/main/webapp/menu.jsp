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
	<form method="post">
		<input type="submit" formaction="" value="タスク登録"><br>
		<input type="submit" formaction="" value="タスク一覧"><br>
		<input type="submit" formaction="LogoutServlet" value="ログアウト"><br>
	</form>
</body>
</html>