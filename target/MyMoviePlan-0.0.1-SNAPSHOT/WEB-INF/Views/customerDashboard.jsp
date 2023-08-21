<%@ page import="java.util.List" %>
<%@ page import="org.simplilearn.entities.Movie2" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
<style>
body{
   
   background-color:pink;

}


</style>


<title>Customer Dashboard</title>
</head>
<body>
<h2 class="text-center">Welcome ${sessionScope.cuser.uname} to Customer Dashboard</h2>
<h2 class="text-center">Search Form</h2>
<br><br>
<div align="center">
<form action="/searchkeyword" method="get">
Enter a keyword:<input type=text name="keyword">
<button class="btn btn-primary btn-sm">Search</button>

</form>
</div>
<br><br><br>
<h3 class="text-center">${msg}</h3>

<%

List<Movie2> movies=(List<Movie2>)request.getAttribute("listofmovies");

if (movies!=null){
	
%>
<h3 align="center">Search Results with keyword "${keyword}"</h3>

<table class="table">
<tr class="table-success">

<th>Movie Name</th>
<th><a href="/sortByGenre">Genre</a></th>
<th><a href="sortByLanguage">Language</a></th>
<th>Description</th>
<th><a href="/sortByDate">Show Date</a></th>
<th>Show Time</th>
<th>Ticket Price(in Rs.)</th>

</tr>


<%
for (Movie2 m: movies){

%>
<tr class="table-danger"> 
<th scope="row"><%=m.getName() %></th>
<td><%=m.getGenre().getGenreName() %></td>
<td><%=m.getLanguage() %></td>
<td><%=m.getDescription() %></td>
<td><%=m.getShowDate() %></td>
<td><%=m.getShowTime() %></td>
<td><%=m.getTicketprice() %></td>
<td>

<form action="/addtoCart" method="post">
<input type=hidden name="movieid" value="<%=m.getMovieId() %>">
<button class="btn btn-primary btn-sm" name="button1">Add To Cart</button>
</form>
</td>

<td>
<form action="removefromCart" method="post">
<input type=hidden name="movieid" value="<%=m.getMovieId() %>">
<button class="btn btn-primary btn-sm">Remove from Cart</button>

</form>
</tr>

<%
}  //End of for

%>


</table> 



<h4 align="center">Clicking on the links of Table column headings will sort the result</h4>

<h4 align="center">${msg1 }</h4>



<%

}  //End of if
%>

<div align="center">
<form action="/viewcart">
<button class="btn btn-primary">View Cart</button>
</form>
</div>

</body>
</html>