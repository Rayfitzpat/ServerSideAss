<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 18/11/2021
  Time: 00:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Hey ${sessionScope.name}, this is a list of all Users</h1>
<c:forEach items="${allUserList}" var="user">
    User Name: <c:out value="${user.name }"/><br>
    User Email: <c:out value="${user.email}"/><br>
    <br>
</c:forEach>

<form action = "main.jsp" method="get">
    <input type="submit" value="Return to Main Page">
</form>
</body>
</html>
