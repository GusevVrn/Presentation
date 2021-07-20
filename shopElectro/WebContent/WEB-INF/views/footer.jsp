<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<style>
    #footer, #footer li {
        margin: 0; /* убрать внутренние отступы */
        padding: 0; /* убрать внешние отступы */
    }
    #footer {
  		text-align: center;
        background: #8BCBD1; /* цвет фона навигационной панели */
    }
    #footer li{
       display:inline-block; /* расположить пункты горизонтально */
       text-align: center; /* текст горизонтально по центру */
    }
    #footer a {
        display: block; /* ссылка растягивается на весь пункт li */
        padding: 5px 15px; /* задаем внутренние отступы */
        color: #fff; /* цвет текста */
        text-decoration: none; /* убрать нижнее подчёркивание у ссылок */
    }
    #footer a:hover {
        background: #63ABB2; /* фон пунктов при наведении */
    }
	</style>
</head>
<body>
	<footer id="footer">
		<div class="contaoner">
			<div class = "main_footer">
				<ul>
					<li><a href="FeedbackPage">Обратная связь</a></li>
					<li><a href="About">О нас</a></li>
				</ul>
			</div>
			<p>
				8-800-00-00-000	<span>(c 00:00 до 00:00)</span>
			</p>
		</div>
	</footer>
</body>
</html>