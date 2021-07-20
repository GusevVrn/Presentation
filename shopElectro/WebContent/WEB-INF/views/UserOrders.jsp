<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="UTF-8">
<title>Все заказы</title>
<style>
	body{
		text-align: center
	}
</style>
</head>
<body>
        <%@ include file="header.jsp" %>
       	<h1>Все заказы</h1>
     	<table style="margin:0 auto;" width="50%" border="1px">
		<tr>
			<th>Номер</th>
			<th>Название</th>
			<th>Стоимость</th>
			<th>Статус</th>
		</tr>
		<c:forEach var="bas" items="${basket}" varStatus="num">
			<tr>
				<td>${num.count}</td>
				<td>${bas.title}</td>
				<td>${bas.price}</td>
				<td>${bas.status}</td>
			</tr>
		</c:forEach>
		</table>
        <%@ include file="footer.jsp" %>
</body>
</html>