<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="login.css" rel="stylesheet /">
<title>ログイン</title>
</head>
<body>
	<div class="login-container">
		<h1>ログイン画面</h1>
		<hr>
		<form action="LoginServlet" method="post">
			<div class="form-group">
				<table>
					<tr>
						<td>ユーザID:<input type="text" name="userId"></td>
					</tr>
					<tr>
						<td>パスワード:<input type="password" name="password"></td>
					</tr>
				</table>
				<input type="submit" value="ログイン">
			</div>
		</form>
	</div>
</body>
</html>