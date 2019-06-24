<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@include file="Header.jsp"%>

<div class="container">
<form action="<c:url value="/receipt"/>" method="post">
<table class="table table-bordered">
<tr class="success">
<td colspan="4"><center><strong>Payment Details</strong></center></td>
</tr>


<tr>
<td colspan="2">
<center>
<input type="radio" name="pmode" value="COD">COD
<input type="radio" name="pmode" value="CC">CC
</center>
</td>
</tr>


<tr>
<td colspan="2"> Card No</td>
<td colspan="2"><input type="text" placeholder="Enter Card number" name="card.No" /></td>
</tr>


<tr>
<td> CVV</td>
<td><input type="text" placeholder="Enter CVV number" name="cvv"/></td>
<td> Valid Upto</td>
<td><input type="text" placeholder="MM/YY" name="valid"/></td>
</tr>


<tr>
<td colspan="4">
<center>
<input type="submit" value="Payment" class="btn"/>
</center>
</td>
</tr>


</table>
</form>
</div>