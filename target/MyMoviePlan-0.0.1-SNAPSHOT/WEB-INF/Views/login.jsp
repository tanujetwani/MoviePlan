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
*{
   font-family: "Times New Roman", Times, serif;
}
body{
    background-color:aqua;

}
</style>
</head>
<body>
<h1><i>Sign In</i></h1>
<form action="/loginUser">
Username:<input type=text name="uname" class="form-control"><br>
Password:<input type=password name="upwd" class="form-control"><br>
<button class="btn btn-primary">Log in</button>


</form>
<br><br><br>
<h4>${msg1}</h4>

</body>
</html>