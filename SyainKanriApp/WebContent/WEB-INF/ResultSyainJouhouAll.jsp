<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.SyainJouhouAllEntity,java.util.List" %>
<%@ page import="beans.Const.Path" %>

<%
	//リクエストスコープに保存されたユーザー情報を取得
	//List<SyainJouhouAllEntity> syainJouhouAllEntityList = (List<SyainJouhouAllEntity>)request.getAttribute(Path.SYAIN_JOUHOU_ALL_SCOPE);
    //セッションスコープに保存されたユーザー情報を取得
    List<SyainJouhouAllEntity> syainJouhouAllEntityList = (List<SyainJouhouAllEntity>)request.getAttribute(Path.SESSION_SCOPE_NAME);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>選択結果</title>
</head>
<body>

<table border="1">
<tr>
<th>社員ID</th><th>名前</th><th>読み仮名</th><th>性別</th><th>出身地</th><th>現住所</th><th>住宅手当有無</th><th>職位</th><th>年収</th><th>入社年月</th><th>勤続年数</th>
</tr>

<% for(SyainJouhouAllEntity syainJouhouAllEntity : syainJouhouAllEntityList){%>
	<tr>
	<td><%= syainJouhouAllEntity.getId()%></td>
	<td><%= syainJouhouAllEntity.getName() %></td>
	<td><%= syainJouhouAllEntity.getYomigana() %></td>
	<td><%= syainJouhouAllEntity.getSeibetsu() %></td>
	<td><%= syainJouhouAllEntity.getSyussinn() %></td>
	<td><%= syainJouhouAllEntity.getJuusyo() %></td>
	<td><%= syainJouhouAllEntity.getJutakuTeateUmu() %></td>
	<td><%= syainJouhouAllEntity.getShokui() %></td>
	<td><%= syainJouhouAllEntity.getSalary() %></td>
	<td><%= syainJouhouAllEntity.getNyuusyaNengetsu() %></td>
	<td><%= syainJouhouAllEntity.getKinzokuNennsuu() %></td>
	</tr>
<% }%>

</table>
 
<p>
<a href="/SyainKanriApp/index.jsp">戻る</a>
</p>
</body>
</html>