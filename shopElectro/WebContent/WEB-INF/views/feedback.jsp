<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<meta charset="UTF-8">
<title>Обратная связь</title>
<style>
	body{
		text-align: center
	}
</style>
</head>
<body>
<script>
function send(){
	var name = $('#name').val();
	var email = $('#email').val();
	var message = $('#message').val();
	var check = /[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?/;
	var valid = check.test(email);
	if (valid){
    var str = "name="+name+"&email="+email+"&message="+message;
	$.ajax(
			{
			type: "POST",
			url: "FeedbackPage",
			data: str,
			success:function(answer){
				if(answer==="Ваше сообщение отправлено"){
					alert(answer);
					window.location='mainPage';
				}
				else{
					alert(answer);
				}
				}
			}
	);
    }
    else{
    	alert('Почтовый адрес введен неправильно');
    }
}
</script>
        <%@ include file="header.jsp" %>
        <div class="container">
       	 <h1>Форма обратной связи</h1>
       	 <form name=form>
     		   <input name="name" type="text" placeholder="Введите ваше имя" id="name" required><br><br>
      		  <input name="email" type="text" placeholder="Введите ваш почтовый адрес" id="email" required><br><br>
      		  <textarea cols="32" name="message" rows="5" placeholder="Текст сообщения" id="message" required></textarea> <br> <br>
      		  <button class = "enter" onclick="send()">Отправить</button><br>
     	</form>
     	</div>       
        <%@ include file="footer.jsp" %>
</body>
</html>