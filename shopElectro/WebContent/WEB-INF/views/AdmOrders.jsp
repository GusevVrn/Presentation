<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="UTF-8">
<title>Все заказы: Админка</title>
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
				url: "Orders",
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
       	<h1>Все заказы</h1>
     	<table style="margin:0 auto;" width="50%" border="1px">
		<tr>
			<th>Номер</th>
			<th>Название</th>
			<th>Стоимость</th>
			<th>Имя</th>
			<th>Телефон</th>
			<th>Статус</th>
			<th></th>
		</tr>
		<c:forEach var="bas" items="${basket}" varStatus="num">
			<tr>
				<td>${bas.id}</td>
				<td>${bas.title}</td>
				<td>${bas.price}</td>
				<td>${bas.user}</td>
				<td>${bas.phone}</td>
				<td>${bas.status}</td>
				<td><div id="b"><button onclick="promote(<c:out value="${bas.id}" />)">Promote</button></div></td>
			</tr>
		</c:forEach>
		</table>
        <%@ include file="footer.jsp" %>
</body>
</html>