<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
  
<title>Insert title here</title>
<style>
*{
   font-family: "Times New Roman", Times, serif;
}
body{
      background-color:aqua;

}
</style>
</head>
<body>
<h1><i>Welcome to My Movie Plan, An Online Movie ticket Booking Web Application</i></h1>
<nav class="nav">
<a class="nav-link active" href="/register"><i>Register</i></a><br><br>
<a  class="nav-link" href="/login"><i>Sign In</i></a><br><br>
</nav>
<br><br>
<h2>${msg }</h2>

</body>
</html>