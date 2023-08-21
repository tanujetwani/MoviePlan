<%@ page import="org.simplilearn.entities.Movie2" %>
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
<h1>Enable or Disable Movie shows</h1>
<br><br><br>
<form action="/searchMovies">
Enter Id of Movie:<input type=text name="movieid"><br>
<button class="btn btn-primary">Search Movie</button>
</form>
<br><br><br>
<%
Movie2 movie=(Movie2)request.getAttribute("enablemovie");

if(movie!=null){

%>
<h3>Name of Movie: <%=movie.getName() %></h3><br><br>
<form action="/enableMovies" method="post">
<div class="form-check form-check-inline">
<input class="form-check-input" type=radio name="enableMovies" value="true"><label>Enable</label>
</div>
<div class="form-check form-check-inline">
<input class="form-check-input" type=radio name="enableMovies" value="false"><label>Disable</label>
</div>
<button class="btn btn-primary">Submit</button>
</form>
<br><br><br>

<!-- <h2>${ msg}</h2> -->

<%

}  //End of if
%>
<h2>${ msg}</h2> 
<br><br><br>
<a href="/gotoadminhome">Go To Admin Home</a>
</body>
</html>