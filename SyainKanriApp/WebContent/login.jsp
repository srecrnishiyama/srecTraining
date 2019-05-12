<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- ログイン画面  -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">
function checkIDandText(){

	var id = document.form1.id.value;
	var password = document.form1.password.value;

    if(id == ""){
        window.alert('ログインIDを入力してください');
        return false;
    }else if(!id.match(/^[A-Za-z0-9]+$/)){
    	window.alert('IDは半角英数のみ入力可能です')
    	return false;
    }else if(password == ""){
        window.alert('パスワードを入力してください');
        return false;
    }
}
</script>

<title>ログイン画面</title>
</head>

<body>

<h1>ログインIDとパスワードを入力してください</h1>

<form name="form1" action="<%= request.getContextPath() %>/IndexAction" method="post" onSubmit="return checkIDandText()">

<p>ID:  <input type="text" name="id"></p>
<p>PASS:<input type="password" name="password"></p>

<p><input type="submit" name="login" value="ログイン"></p>

</form>

</body>
</html>