<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メイン画面</title>
</head>
<body>

<h1>IDを選択してください</h1>

<form action="<%= request.getContextPath() %>/SyainJouhouAllAction" method="post">

<p><input type="submit" name="all" value="全社員全情報"></p>

</form>

<form action="<%= request.getContextPath() %>/SyainJouhouSeibetsuAction" method="post">

<p><input type="submit" name="seibetsu" value="社員名（性別）"></p>

</form>

</body>
</html>