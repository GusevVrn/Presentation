<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<meta charset="UTF-8">
<title>Регистрация</title>
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
	var phone = $('#phone').val();
	var check = /^((8|\+7)[\- ]?)?(\(?\d{3}\)?[\- ]?)?[\d\- ]{7,10}$/;
	var valid = check.test(phone);
	if (valid){
    var str = "username="+username+"&password="+password+"&phone="+phone;
	$.ajax(
			{
			type: "POST",
			url: "Registration",
			data: str,
			success:function(answer){
				if(answer){
					window.location='login';
				}
				else{
					alert("Логин занят или номер уже зарегистрирован");
				}
				}
			}
	);
}
    else{
    	alert('Номер введен неправильно');
    }
}
</script>
        <%@ include file="header.jsp" %>
        <div class="container">
       	 <h1>Регистрация</h1>
       	 <form name=form>
     		  <input name="username" type="text" placeholder="Введите ваше имя" id="username" required><br><br>
      		  <input name="password" type="text" placeholder="Введите пароль" id="password" required><br><br>
      		  <input name="phone" type="text" placeholder="Введите телефон" id="phone" required><br><br>
      		  <button class = "enter" onclick="send()">Регистрация</button><br>
     	</form>
     	</div>       
        <%@ include file="footer.jsp" %>
</body>
</html>