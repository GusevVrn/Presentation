<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="UTF-8">
<title>Обратная связь: админка</title>
<style>
	body{
		text-align: center
	}
</style>
</head>
<body>
        <%@ include file="header.jsp" %>
       	<h1>Все отзывы</h1>
     	<table style="margin:0 auto;" width="50%" border="1px">
		<tr>
			<th>Номер</th>
			<th>Имя</th>
			<th>Email</th>
			<th>Текст</th>
		</tr>
		<c:forEach var="feedback" items="${feedbacks}" varStatus="num">
			<tr>
				<td>${num.count}</td>
				<td>${feedback.name}</td>
				<td>${feedback.email}</td>
				<td>${feedback.text}</td>
			</tr>
		</c:forEach>
		</table>
     	
        <%@ include file="footer.jsp" %>
</body>
</html>