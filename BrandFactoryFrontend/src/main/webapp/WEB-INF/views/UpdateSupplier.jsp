<%@include file="Header.jsp"%>


<div class="container">
<form action="<c:url value="/updateSupplier"/>" method="post">
<table class="table table-bordered">
	
	
	<tr bgcolor="grey">
		<td colspan="12"><h4><center><strong>Supplier Detail</strong></center></h4></td>
	</tr>
	
	<tr>
		<td>Supplier Id</td>
		<td><input type="number" name="supId" value="${supplier.supplierid}"readonly/></td>
	</tr>
	<tr>
		<td>Supplier Name</td>
		<td><input type="text" name="supName" value="${supplier.suppliername}"/></td>
	</tr>
	<tr>
		<td>Supplier Address</td>
		<td><textarea cols=30 rows="6" name="supAddr">${supplier.supplieraddr}</textarea></td>
	</tr>
	<tr>
		<td colspan="2">
		<center>
		<input type="submit" value="Update Supplier" class="btn"/>
		</center>
		</td>
	</tr>
</table>
</form>


</body>
</html>