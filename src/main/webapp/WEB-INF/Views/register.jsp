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
<h1>Register</h1>
<form action="/registerUser" method="post">

Name:<input type=text name="name" class="form-control"><br>
     
            
Password:<input type=password name="pwd" class="form-control">
               <br>
Email:<input type=email name="email" class="form-control"><br><br>
Phone:<input type=text name="phone" class="form-control"><br>
UserType:<select  class="custom-select" name="userType">

         <option value="Customer">Customer</option>
         <option value="Admin">Admin</option>

</select>
<br><br>
<button class="btn btn-primary">Register</button>

</form>
<br><br>
<h3>${msg}</h3>
</body>
</html>