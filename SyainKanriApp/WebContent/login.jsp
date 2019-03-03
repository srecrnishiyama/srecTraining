<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン画面</title>
</head>

<body>

<h1>ログインIDとパスワードを入力してください。</h1>

<form action="<%= request.getContextPath() %>/IndexAction" method="post">

<p>ID:  <input type="text" name="id"></p>
<p>PASS:<input type="password" name="password"></p>

<p><input type="submit" name="login" value="ログイン"></p>

</form>

</body>
</html>