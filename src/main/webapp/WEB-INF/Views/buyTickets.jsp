<%@ page import="java.util.List"%>
<%@ page import="org.simplilearn.entities.Cart"%>
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
body{
    
    background-color:tomato;

}

</style>
</head>
<body>
<h1 align="center">Summary of Tickets to be bought</h1>
<table  class="table">
<tr class="table-danger">

<th>Movie ID</th>
<th>Movie Name</th>

<th>Genre</th>
<th>Language</th>
<th>Description</th>
<th>Show Date</th>
<th>Show Time</th>
<th>No. of tickets</th>
<th>Ticket Price/person(in Rs.)</th>
<th>Amount</th>

</tr>


<%
List<Cart> carts=(List<Cart>)request.getAttribute("listofcarts1");

for(Cart c: carts){
%>
<tr class="table-warning">
<th scope="row"><%=c.getMovie().getMovieId() %></th>
<td><%=c.getMovie().getName() %></td>


<td><%=c.getMovie().getGenre().getGenreName() %></td>
<td><%=c.getMovie().getLanguage() %></td>
<td><%=c.getMovie().getDescription() %></td>
<td><%=c.getMovie().getShowDate() %></td>
<td><%=c.getMovie().getShowTime() %></td>

<td><%=c.getNooftickets() %></td>
<td><%=c.getMovie().getTicketprice() %></td>
<td><%=c.getMovie().getTicketprice()*c.getNooftickets()%></td>
</tr>

<%
}   //End of for
%>
</table> 
<br><br>
<h2 align="center">Total amount to be paid =Rs. ${total_amount}</h2>

<br><br>
<div align="center">
<form action="/submitcardDetails" method="get">
<button  class="btn btn-primary" style="background-color:green;">Pay Amount</button>
</form>
</div>
<br><br><br>
<div align="center">
<form action="/gotosearchform">
<button class="btn btn-primary btn-sm">Go Back to Search Form</button>
</form>
</div>
<br><br><br>
<div align="center">
<form action="/viewcart">
<button class="btn btn-primary btn-sm">Go Back To Cart</button>
</form>
</div>
<br><br><br>
<a href="/logout">Logout</a>
</body>
</html>