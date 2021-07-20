<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<meta charset="UTF-8">
<title>Вход</title>
<style>
	body{
		text-align: center
	}
</style>
</head>
<body>
<script>
function send(){
	var username = $('#username').val();
	var password = $('#password').val();
    var str = "username="+username+"&password="+password;
	$.ajax(
			{
			type: "POST",
			url: "Login",
			data: str,
			success:function(answer){
				if(answer){
					window.location='mainpage';
				}
				else{
					alert("Неверный логин или пароль");
				}
				}
			}
	);
}
</script>
        <%@ include file="header.jsp" %>
        <div class="container">
       	 <h1>Авторизация</h1>
       	 <form name=form>
     		  <input name="username" type="text" placeholder="Введите ваше имя" id="username" required><br><br>
      		  <input name="password" type="text" placeholder="Введите пароль" id="password" required><br><br>
      		  <button class = "enter" onclick="send()">Войти</button><br>     		  
     	</form>
     	</div>       
        <%@ include file="footer.jsp" %>
</body>
</html>