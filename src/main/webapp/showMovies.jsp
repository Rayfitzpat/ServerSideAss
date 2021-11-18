<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Movie List</title>
</head>
<body>

<h1>Hey ${sessionScope.name}, this is a list of all Movies</h1>
	<c:forEach items="${allMovieList}" var="movie">
		Movie Title: <c:out value="${movie.title }"/><br>
		Movie Star: <c:out value="${movie.star}"/><br>
		Movie Year: <c:out value="${movie.year}"/><br>
		Email: <c:out value="${movie.email}"/><br>
		<br>
	</c:forEach>

<form action = "main.jsp" method="get">
	<input type="submit" value="Return to Main Page">
</form>
</body>
</html>