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
<h1>Edit Details of Movies</h1>

<form action="/searchMovie">
Enter Id of the movie:<input type=text name="movieId" ><br><br><br>
<button class="btn btn-primary btn-sm">Search Movie</button>
</form>
<br><br><br>


<%

Movie2 movie=(Movie2)request.getAttribute("movie");

if(movie!=null){
%>
<form action="/editMovieDetails" method="post">
Id:<b><%=movie.getMovieId() %></b><br><br>
Name:<b><%=movie.getName() %></b><input type=text name="mname"><br><br>
Language:<b><%=movie.getLanguage() %></b><input type=text name="language"><br><br>
Description:<b><%=movie.getDescription() %></b><input type=text name="description"><br><br>
Show Date:<b><%=movie.getShowDate() %></b><input type="date" name="showDate"><br><br>
Show Time:<b><%=movie.getShowTime() %></b><input type="time" name="ShowTime"><br><br>
Ticket Price:<b><%=movie.getTicketprice() %></b><input type=text name="price" ><br><br>
<button class="btn btn-primary">Edit Movie Details</button>
</form>

<%

}  //End of if
%>

<h2>${msg }</h2>
<br><br><br>
<a href="/gotoadminhome">Go To Admin Home</a>
</body>
</html>