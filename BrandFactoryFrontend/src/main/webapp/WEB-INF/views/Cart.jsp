<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
    <%@include file="Header.jsp"%>
<div class="container">
<table class="table table-bordered">
<tr class="success">
<td colspan="8"> Your Cart </td>
</tr>
<tr class="warning">
<th>SL.no</th>
<th>Product Name</th>
<th>Price</th>
<th>Quantity</th>
<th>Total Price</th>
<th>Images</th>
<th></th>
</tr>
<% int i=1; %>
<c:forEach items="${cartItemList}" var="cart">

<form action="<c:url value="/updateCartItem/${cart.cartItemId}"/>">

<tr>
<td><%=i %><% i++; %></td>
<td>${cart.productname}</td>
<td>${cart.price}</td>
<td><input type="text" name="quantity" value="${cart.quantity}"/></td>
<td>${cart.price*cart.quantity}</td>
<td><img src="<c:url value="/resources/images/${cart.productid}.jpg"/>" width="40" height="40"></td>
<td>
<input type="submit" value="Update" class="btn"/> &nbsp;&nbsp;&nbsp; 
<a href="<c:url value="/deleteCartItem/${cart.cartItemId}"/>" class="btn btn-danger">DELETE</a>
</td>

</tr>
</form>

</c:forEach>
<tr class="success">
<td colspan="4"> Grand Total </td>
<td colspan="4">${grandTotal}</td>
</tr>
<tr class="success">
<td colspan="4"><a href="<c:url value='/productDisplay'/>">Continue Shopping</a>
<td colspan="4"><a href="<c:url value='/payment'/>">Payment</a>
</td>
</tr>
</table>
</div>
</body>
</html>