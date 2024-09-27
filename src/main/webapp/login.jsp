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
			<table>
				<tr>
					<td>
						<div class="form-group">
							<label for="userId">ユーザID:</label>
							<input type="text" id="userId" name="userId">
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div class="form-group">
						<label for="password">パスワード:</label>
						<input type="password" id="password" name="password">
						</div>
					</td>
				</tr>
			</table>
			<input type="submit" value="ログイン">
		</form>
	</div>
</body>
</html>