<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>

<style>
body{ background-color:peachpuff;

}
</style>
</head>
<body>
<h1 align="center">Add Genres</h1>

<form action="/addmovieGenres" method="post">
Genre Name:<input type=text name="genrename">
<br><br>

<button class="btn btn-primary">Add Genre</button>
</form>
<br><br>
<h2>${msg}</h2><br><br><br>
<a href="/gotoadminhome">Go To Admin Home</a>
</body>
</html>