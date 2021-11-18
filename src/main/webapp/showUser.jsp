<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Users</title></title>
</head>
<body>
<h1> Hey ${sessionScope.name}, These are all the current users</h1>

<%--Cycles through array list of users and prints them out.--%>
<c:forEach items="${user}" var="user">
	<c:out value="${user.name}"/>
	<c:out value="${user.email}"/> <br>
	<c:out value="${user.password}"/> <br>
</c:forEach>

</body>
</html>