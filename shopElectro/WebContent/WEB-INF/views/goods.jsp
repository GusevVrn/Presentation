<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Товары</title>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
 		 <%@ include file="header.jsp" %>
        <br>
        <table border = "0" align="center" cellspacing="10" padding="1" id="mainCategory" text-align= "center">
		<c:forEach var="good" items="${goods}" varStatus="counter">
			<td>
				<a href="goods?id=${good.id}">
				<img width="150" src="Images/${good.img}"><br>
				<c:out value="${good.title}" />
				</a>
			</td>
		</c:forEach>      
        </table>
        <%@ include file="footer.jsp" %>
</body>
</html>