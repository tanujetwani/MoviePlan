<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>

<title>Admin Dashboard</title>
<style>
body{ background-color:peachpuff;}
</style>
</head>
<body>

<h1 align="center">Welcome ${sessionScope.cuser.uname} to Admin Portal </h1>

<a href="/addGenre">Add Genre To the Application</a><br><br>
<a href="/removeGenre">Remove Genres from Application</a><br><br>
<a href="/editDetails">Edit Movie Details</a><br><br>
<a href="/enableorDisable">Enable or Disable movie shows</a><br><br><br><br>

<a href="/logout">Logout</a>
</body>
</html>