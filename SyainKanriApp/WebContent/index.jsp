<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.SyainJouhouAllEntity,java.util.List" %>
<%@ page import="beans.Const.Path" %>
<!-- 社内システム操作メイン画面 -->
<!DOCTYPE html>
<html>
<%@ include file="header.jsp"%>
<title>メイン画面</title>
</head>
<body>

<h1>IDを選択してください</h1>

<form name="showAll" action="<%= request.getContextPath() %>/SyainJouhouAllAction" method="post">

<p><input type="submit" name="all" value="全社員全情報"></p>

</form>

<form name="showName" action="<%= request.getContextPath() %>/SyainJouhouSeibetsuAction" method="post">

<p><input type="submit" name="seibetsu" value="社員名（性別）"></p>

</form>

</body>
</html>