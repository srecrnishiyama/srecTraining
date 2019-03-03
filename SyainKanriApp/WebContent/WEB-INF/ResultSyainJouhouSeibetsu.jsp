<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.SyainSeibetsuEntity,java.util.List" %>
<%@ page import="beans.Const.Path" %>

<%
	//セッションスコープに保存されたユーザー情報を取得
	List<SyainSeibetsuEntity> syainSeibetsuEntityList = (List<SyainSeibetsuEntity>)request.getAttribute("session");
%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="../header.jsp"%>
<title>選択結果</title>
</head>
<body>

<table border="1">
<tr>
<th>社員ID</th><th>名前</th><th>性別</th>
</tr>

<% for(SyainSeibetsuEntity syainSeibetsuEntity : syainSeibetsuEntityList){%>
	<tr><td><%= syainSeibetsuEntity.getId()%></td>
	<td><%= syainSeibetsuEntity.getName() %></td>
	<td><%= syainSeibetsuEntity.getSeibetsu() %></td></tr>
<% }%>

</table>

<p>
<a href="/SyainKanriApp/index.jsp">戻る</a>
</p>
</body>
</html>