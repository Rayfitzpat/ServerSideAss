<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <title>Title</title>
    </head>

    <body text-align="center">
        <br>
        <br>
        <br>
        <br>
        <h1 style="text-align:center;">Welcome to Ray's Movie Emporium</h1>
        <br>
        <br>
        <h3 style="text-align:center;">Please login or register:</h3>
        <form method="post" action="UserController">
            <table style="margin:auto">
                <tr>
                    <td>
                        Name:
                    </td>
                    <td>
                        <input type="text" name="name" value="${param.name}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Email:</td>   <td> <input type="email" name="email" value="${param.email}"/>
                    </td>
                </tr>

                <tr>
                    <td>
                        Password: </td>  <td><input type="password" name="password" value="${param.password}"/>
                    </td>
                </tr>

                <tr>
                    <td colspan="2">
                        <textarea disabled rows = "1" cols = "60" minlength="200" name="message" style="border: none" backgroundcolor="white" id="message"></textarea>
                    </td>
                </tr>

                <tr></tr>
                <tr></tr>
                <tr>
                    <td> <input type = "Submit" name="submit"/></td>
                    <td><button type = "Submit" formaction="register.jsp" formmethod="post">Register</button></td>
                </tr>
            </table>
        </form>
        <br>
        <br>
    </body>
</html>
<c:set var="email" value="${email}" scope="session"/>
<c:set var="name" value="${name}" scope="session"/>
<c:set var="password" value="${password}" scope="session"/>