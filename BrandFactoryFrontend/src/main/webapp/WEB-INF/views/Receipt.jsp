<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@include file="Header.jsp"%>

<div class="container">
<table class="table table-bordered">
<tr bgcolor="grey">
<td colspan="4" class="text-center"><h3>Invoice</h3></td>
</tr>
<tr class="success">
	<td>ORDERID</td>
	<td>ORD${orderDetail.orderId}</td>
	<td>Customer Name</td>
	<td>${orderDetail.username}</td>
</tr>
<tr class="orange">
<td>Shopping Amount</td>
<td>${grandTotal}</td>
<td>Order Date</td>
<td>${orderDetail.orderDate}</td>
</tr>


<tr>
<td colspan="4">
<table class="table table-bordered responsive">
<tr class="success">
<td colspan="8" class="text-center">Ordered Items</td>
</tr>
<tr class="warning">
<th>SL.no</th>
<th>Product Name</th>
<th>Price</th>
<th>Quantity</th>
<th>Total Price</th>
<th>Images</th>
</tr>
<% int i=1; %>
<c:forEach items="${cartItemList}" var="cart">
<tr>
<td><%=i %><% i++; %></td>
<td>${cart.productname}</td>
<td>${cart.price}</td>
<td>${cart.quantity}</td>
<td>${cart.price * cart.quantity}</td>
<td><img src="<c:url value="/resources/images/${cart.productid}.jpg"/>" width="40" height="40"></td>
</tr>
</c:forEach>
</table>
</td>
</tr>
<tr class="success">
<td colspan="8">Address</td>
</tr>
<tr>
<td colspan="8">${user.address}</td>
</tr>
</table>
</div>