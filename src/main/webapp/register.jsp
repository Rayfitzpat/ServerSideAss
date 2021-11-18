<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 12/11/2021
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body text-align="center">
<br>
<br>
<br>
<br>
<h1 style="text-align:center; color: red">REGISTER</h1>
<br>
<br>
<h3 style="text-align:center">Hey ${param.name}, Please take a minute to register:</h3>
<c:set var="email" value="${email}" scope="session"/>
<form method="post" action="RegisterController">
    <table style="margin: auto">
        <tr>
            <td> Name:</td>   <td> <input type="text" name="name" value="${param.name}"/></td>
        </tr>
        <tr>
            <td> Email:</td>   <td> <input type="email" name="email" value="${param.email}"/></td>
        </tr>

        <tr><td> Password: </td>  <td><input type="password" name="password" value="${param.password}"/></td> </tr>

        <tr><td colspan="2">
            <textarea disabled rows = "1" cols = "60" minlength="200" name="message" style="border: none" backgroundcolor="white"></textarea>
        </td></tr>

        <tr></tr>
        <tr></tr>
        <tr>
            <td> <input type = "Submit" name="submit" value="Register"/></td>

        </tr>
    </table>
</form>
<br>
<br>
</body>
</html>
