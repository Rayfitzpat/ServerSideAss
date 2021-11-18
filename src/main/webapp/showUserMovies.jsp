<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 15/11/2021
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UsersMovieList</title>
</head>
<body>

<h1>Hey ${sessionScope.name}, These are all the movies you have rented</h1>

<%--Cycles through array list and prints them out.  The variable userMovieList is set in UserMovieController--%>
<c:forEach items="${userMovieList}" var="movie">
    Movie Title: <c:out value="${movie.title }"/><br>
    Movie Star: <c:out value="${movie.star}"/><br>
    Movie Year: <c:out value="${movie.year}"/><br>
<%--    Email: <c:out value="${movie.email}"/><br>--%>
    <br>
</c:forEach>
 <br>
<form action = "main.jsp" method="get">
    <input type="submit" value="Return to Main Page">
</form>

</body>
</html>
