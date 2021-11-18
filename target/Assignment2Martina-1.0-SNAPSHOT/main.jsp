<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main</title>
</head>
<body>
<br>
<br>
<br>
<h1 style="text-align:center;"> Welcome: ${sessionScope.name} </h1>

<br>
<form>
	<table style="margin: auto">
		<tr>
			<td>
				<Button type="submit" formmethod="post" formaction="AllMovieController">Show ALL Movies</Button>
			</td>

		</tr>

		<tr>
			<td style="color: white">
				_
			</td>
		</tr>
		<tr>

			<td>
				<Button type="submit" formmethod="post" formaction="UserMovieController">Show YOUR Movies</Button>
			</td>
		</tr>

		<tr>
	</table>
</form>
<br>
<h3 style="text-align:center;">Please fill out the form and choose add your Movie to the DB</h3>

<%--		<input type="hidden" name="name" value = "${param.name}"/> <br>--%>
<%--		<input type="hidden" name="email" value="${param.email}"/><br>--%>
<%--		<input type="hidden" name="password" value="${param.password}"/> <br>--%>

	<form method="post" action="AddMovieController">
		<table style="margin: auto">
			<tr>
				<td>
					Title: <br>
				</td>
				<td>
					<input type="text" name="title" /> <br>
				</td>
			</tr>

			<tr>
				<td>
					Star: <br>
				</td>
				<td>
					<input type="text" name="star" /> <br>
				</td>
			</tr>

			<tr>
				<td>
					Year Released: <br>
				</td>
				<td>
					<input type="text" name="year" /> <br>
				</td>
			</tr>

			<tr hidden>
				<td>
					<input type="text" name="email" value="${param.email}"/> <br>
				</td>
			</tr>

			<tr>
				<td style="color: white">
					_
				</td>
			</tr>

			<tr>
				<td>
					<input type="submit" value="Add your movie to DB"/>
				</td>
			</tr>


			<td style="color: white">
				_
			</td>

			<tr>
				<td>
					<Button type="submit" formmethod="post" formaction="EditMovieController">Edit Movie</Button>
				</td>
				<td>
					<Button type="submit" formmethod="post" formaction="UserDeleteMovieController">Delete a Movie</Button>
				</td>
			</tr>

				<td style="color: white">
					_
				</td>
			</tr>
		</table>
	</form>

<h3 style="text-align:center;"> Please enter the Movie name above and select Edit or Delete</h3>
<form action="EditMovie.jsp" method = "POST">
	<table style="margin: auto">


		</table>

	</form>
</body>

</html>



