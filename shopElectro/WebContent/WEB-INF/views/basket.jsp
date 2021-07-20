<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Корзина</title>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
        <%@ include file="header.jsp" %>
        <br>
        
        <table border ="0" align="center" cellspacing="10" padding="1" id="mainCategory" text-align= "center">
		<c:forEach var="category" items="${categories}" varStatus="counter">
			<td>
				<a href="Goods?id_cat=${category.id}">
				<img width="300" src="Images/${category.img}"><br>
				<c:out value="${category.name}" />
				</a>
			</td>
		</c:forEach>      
        </table>
        
        <%@ include file="footer.jsp" %>
</body>
</html>