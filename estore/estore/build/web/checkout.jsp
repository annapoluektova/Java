<%-- 
    Document   : checkout
    Created on : Oct 4, 2014, 7:02:26 PM
    Author     : nisaenko
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="store.*, java.text.*, java.util.*" %>
<% ProductCatalog catalog = new ProductCatalog(); %>
<% ShoppingCart cart = (ShoppingCart) session.getAttribute("cart"); %>
<% DecimalFormat df = new DecimalFormat("#.00");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your Order</title>
</head>
<body>
	<h1>Order</h1>
	<% if(cart.numProducts()>0) {%>
	
        <table cellpadding="5" cellspacing="2">
		<tr>
			
			<th>
			Item Name
			</th>
                        <th>
			# of Items
			</th>
			<th>
			Item Cost
			</th>
		</tr>
		<%Iterator<String> iter = cart.getIterator(); %>
		<%while(iter.hasNext()) { %>
			<%String id = iter.next(); %>
			<%Product p = catalog.getProductByID(id); %>
			<tr>
				<td>
					<%=p.getName()%>
				</td>
				<td>
					 <%=cart.numProductByID(id)%>
				</td>
                                
				<td>
					$<%=df.format(p.getPrice()) %>
				</td>
			</tr>
		<%} %>
		<tr>
			<td>
			<div></div>
			</td>
			<td>
			
			</td>
			<td>
			Total: $<%= df.format(cart.calculateTotalCost()) %>
			</td>
		</tr>
	</table>
        <p>
	<h1><br><br>Thank you for your shopping!</h1>
        </p>
        
	<% } else { %>
		<p>
		Your order is empty
		</p>
	<% } %>
	
</body>
</html>