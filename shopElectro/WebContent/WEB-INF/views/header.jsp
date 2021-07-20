<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<style>
	body 
	{
	background: url(Images/fon.jpg); 
	}
    #menu, #menu li {
        margin: 0; /* убрать внутренние отступы */
        padding: 0; /* убрать внешние отступы */
    }
    #menu {
  		text-align: center;
        background: #8BCBD1; /* цвет фона навигационной панели */
    }
    #menu li{
       display:inline-block; /* расположить пункты горизонтально */
       text-align: center; /* текст горизонтально по центру */
    }
    #menu a {
        display: block; /* ссылка растягивается на весь пункт li */
        padding: 5px 15px; /* задаем внутренние отступы */
        color: #fff; /* цвет текста */
        text-decoration: none; /* убрать нижнее подчёркивание у ссылок */
    }
    #menu a:hover {
        background: #63ABB2; /* фон пунктов при наведении */
    }
	</style>
</head>
<body>
		<ul id="menu">
			<li><a href="MainPage">Главная</a></li>
			<li><a href="Goods">Товары</a></li>
			<%session = request.getSession();
			
			if (session.getAttribute("username")!=null && session.getAttribute("password")!=null){
				if (session.getAttribute("username").equals("admin")){
					out.println("<li><a href='Orders'>Все Заказы</a></li>");
					out.println("<li><a href='FeedbackPage'>Отзывы</a></li>");
				}
				else{
					out.println("<li><a href='Orders'>Мои заказы</a></li>");
					out.println("<li><a href='Basket'>Корзина</a></li>");
				}
				out.println("<li><a href='Exit'>Выход</a></li>");
			}
			else{
				out.println("<li><a href='Login'>Войти</a></li>");
				out.println("<li><a href='Registration'>Регистрация</a></li>");
			}
			%>
		</ul>
</body>
</html>