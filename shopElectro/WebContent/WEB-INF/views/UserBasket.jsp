<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="UTF-8">
<title>Корзинка</title>
<style>
	body{
		text-align: center
	}
</style>
<script>
		function promote(id) {
			var str = "id_good="+id;
			$.ajax({
				type:"post",
				url: "Basket",
				data: str,
				success: function(answer){
					alert(answer);
				}
			});
		}
		function drop(id) {
			var str1 = "id_good_drop="+id;
			$.ajax({
				type:"post",
				url: "Basket",
				data: str1,
				success: function(answer){
					alert(answer);
				}
			});
		}
	</script>
</head>
<body>
        <%@ include file="header.jsp" %>
       	<h1>Корзинка</h1>
     	<table style="margin:0 auto;" width="50%" border="1px">
		<tr>
			<th>Номер</th>
			<th>Название</th>
			<th>Стоимость</th>
			<th>Статус</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach var="bas" items="${basket}" varStatus="num">
			<tr>
				<td>${num.count}</td>
				<td>${bas.title}</td>
				<td>${bas.price}</td>
				<td>${bas.status}</td>
				<td><div id="b"><button onclick="promote(<c:out value="${bas.id}" />)">Оплатить</button></div></td>
				<td><div id="b"><button onclick="drop(<c:out value="${bas.id}" />)">Удалить</button></div></td>
			</tr>
		</c:forEach>
		</table>
        <%@ include file="footer.jsp" %>
</body>
</html>