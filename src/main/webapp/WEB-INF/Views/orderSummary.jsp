<%@ page import="org.simplilearn.entities.Orders" %>
<%@ page import="org.simplilearn.entities.OrderDetails" %>
<%@ page import="java.util.Set" %>
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
      background-color:violet;

}
</style>
</head>
<body>
<h2>Thanks for booking tickets ${sessionScope.cuser.uname}. Your tickets are confirmed</h2>
<br><br>
<h3 align="center">Below is the summary of your Order</h3>

<%
Orders order=(Orders)request.getAttribute("order");


%> 
<table  class="table">
<tr class="table-success">
<th>Order ID</th>
<th>Order Date</th>
<th>Total Amount Paid</th>
</tr>

<tr class="table-danger">
<th scope="row"><%=order.getOrder_id() %></th>
<td><%=order.getOrder_date() %></td>
<td><%=order.getTotal_amount() %></td>
</tr>
</table>

<br><br><br>
<h3 align="center">Below are the details of tickets bought</h3>
<table  class="table">
<tr class="table-primary">
<th>Movie ID</th>
<th>Movie Name</th>
<th>Genre</th>
<th>Language</th>
<th>Description</th>
<th>Show Date</th>
<th>Show Time</th>
<th>No. of Tickets</th>
<th>Ticket Price(in Rs.)</th>
<th>Amount</th>
</tr>


<%
    Set<OrderDetails> ordDetails =order.getOrd_details();
    
 for(OrderDetails o :ordDetails){
%>
<tr class="table-info">
<th scope="row"><%=o.getMovie().getMovieId() %></th>
<td><%=o.getMovie().getName() %></td>
<td><%=o.getMovie().getGenre().getGenreName() %></td>
<td><%=o.getMovie().getLanguage() %></td>
<td><%=o.getMovie().getDescription() %></td>
<td><%=o.getMovie().getShowDate() %></td>
<td><%=o.getMovie().getShowTime() %></td>
<td><%=o.getNoOfTickets() %></td>
<td><%=o.getMovie().getTicketprice() %></td>
<td><%=o.getAmount() %></td>
</tr>
<%
 }    //End of for
%>
</table>
<br><br>
<h3 align="center">Total Amount Paid= Rs.<%=order.getTotal_amount() %></h3>

<a href="/logout">Logout</a>
</body>
</html>