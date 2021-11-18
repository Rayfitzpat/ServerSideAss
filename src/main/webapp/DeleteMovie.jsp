<%--
  Created by IntelliJ IDEA.
  User: ray_f
  Date: 17/11/2021
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- This form is not used at present--%>
<html>
<head>
    <title>Delete Movie</title>
</head>
<body>
<form>
  <table style="margin: auto">
    <tr>
      <td>
        Title: <br>
      </td>
      <td>
        <input type="text" name="title"/> <br>
      </td>
    </tr>

    <tr>
      <td>
        Star: <br>
      </td>
      <td>
        <input type="text" name="star"/> <br>
      </td>
    </tr>

    <tr>
      <td>
        Year Released: <br>
      </td>
      <td>
        <input type="text" name="year"/> <br>
      </td>
    </tr>

    <tr>
      <td>
        <input type="submit" value="DELETE"name="year"/> <br>
      </td>
    </tr>
  </table>
</form >
<form action = "main.jsp" method="get">

  <input type="submit" value="Return to Main Page">
</form>
</body>
</html>
