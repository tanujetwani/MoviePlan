<%@ page import="java.util.List"%>
<%@ page import="org.simplilearn.entities.Cart"%>
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
body{
    
    background-color:lightblue;

}

</style>
</head>
<body>
<h1 class="text-center">Cart Details of user ${sessionScope.cuser.uname}</h1><br><br>
<%
List<Cart> carts=(List<Cart>)request.getAttribute("listofcarts");

if(carts.size()>0){

%>
<table  class="table">
<tr class="table-primary">

<th>Movie Id</th>
<th>Movie Name</th>
<th>Genre</th>
<th>Language</th>
<th>Description</th>
<th>Show Date</th>
<th>Show Time</th>
<th>Ticket Price(in Rs.)</th>
<th>No.of Tickets</th>

</tr>


<%
           
        	  
          for(Cart c:carts){
        	
%>
<tr class="table-danger">
<th scope="row"><%=c.getMovie().getMovieId() %></th>
<td><%=c.getMovie().getName() %></td>
<td><%=c.getMovie().getGenre().getGenreName() %></td>
<td><%=c.getMovie().getLanguage() %></td>
<td><%=c.getMovie().getDescription() %></td>
<td><%=c.getMovie().getShowDate() %></td>
<td><%=c.getMovie().getShowTime() %></td>
<td><%=c.getMovie().getTicketprice() %></td>
<td><%=c.getNooftickets() %></td>
<td>
<form action="/remfromcart" method="post">
<input type=hidden name="movieid" value="<%=c.getMovie().getMovieId() %>">
<button class="btn btn-primary">Remove From Cart</button>
</form>
</td>
</tr>


<%
          } //End of for
          
%>
</table>
<br><br><br>
<h2 align="center">${msg}</h2>
<br><br>
<div align="center">
<form action="buyTickets">
<button class="btn btn-primary">Purchase Tickets </button>
</form>
</div>

<%

          }  //End of if
          
          else{
        	  
%>
<br><br>
<h2 align="center">Cart is Empty</h2>
<%
          }//End of else
%>
<br><br><br>




<div align="center">
<form action="/gotosearchform">
<button class="btn btn-primary">Go Back To Search Form</button>
</form>
</div>

<br><br>
<a href="/logout">Logout</a>
</body>
</html>