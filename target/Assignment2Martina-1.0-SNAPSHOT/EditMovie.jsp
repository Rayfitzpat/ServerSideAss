<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: ray_f
  Date: 17/11/2021
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Movie</title>
</head>
<body>
<br>
<br>
<h3 style="text-align:center"> This is your edit page, ${sessionScope.name}, please enter the new details for the movie ${movieToEdit.title}, then press update button below </h3>
<h4 style="text-align:center"> Note: you may not edit a movies title</h4>
<br>
<br>

<form action = "UpdateMovieController" method="post">
    <table style="margin: auto">
        <tr>
            <td>
                Title: <br>
            </td>
            <td>
                <input readonly type="text" name="title" value = "${movieToEdit.title}"/><br>
            </td>
        </tr>

        <tr>
            <td>
                Star: <br>
            </td>
            <td>
                <input type="text" name="star" value= "${movieToEdit.star}"  /> <br>
            </td>
        </tr>

        <tr>
            <td>
                Year Released: <br>
            </td>
            <td>
                <input type="text" name="year" value= "${movieToEdit.year}"/> <br>
            </td>
        </tr>
        <tr>
        <td style="color: white">
            _
        </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="EDIT" name="submit"/> <br>
            </td>
        </tr>
        <tr>
        <td style="color: white">
            _
        </td>
        </tr>
        <tr>
            <td>
                <Button type="submit" formmethod="post" formaction="main.jsp">Return To Main Page</Button> <br>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
