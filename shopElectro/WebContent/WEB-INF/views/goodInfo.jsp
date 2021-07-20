<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Подробная информация о товаре</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<script>
		function addToCart(id) {
			var str = "id_good="+id;
			$.ajax({
				type:"post",
				url: "goods",
				data: str,
				success: function(answer){
					alert(answer);
				}
			});
		}
	</script>
</head>
<body>
 	<%@ include file="header.jsp" %>
    <br>
    <h1>Наименование товара: <c:out value="${good.title}" /></h1>
	<img width="300" src="Images/${good.img}"><br>
	<a>${good.description}</a><br>
	<a>${good.price}</a><br>
	<div id="b"><button onclick="addToCart(<c:out value="${good.id}" />)">Купить</button></div>
    <%@ include file="footer.jsp" %>
</body>
</html>