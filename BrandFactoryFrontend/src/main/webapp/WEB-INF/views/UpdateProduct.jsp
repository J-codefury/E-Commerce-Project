<%@include file="Header.jsp"%>


<div class="container">
<form action="<c:url value="/UpdateProduct"/>" method="post" enctype="multipart/form-data">
<table class="table table-bordered">

	<tr bgcolor="grey">
	<td colspan="12"><h4><center><strong>Product Detail</strong></center></h4></td>
	</tr>
	
	<tr>
		<td>Product Id</td>
		<td><input type="number" name="proId" value="${product.productid}"readonly/></td>
	</tr>
	
	
	<tr>
		<td>Product Name</td>
		<td><input type="text" name="productName" value="${product.productname}"/></td>
	</tr>
	
	
	<tr>
		<td>Product Description</td>
		<td><input type="text" name="productDesc" value="${product.productdesc}"/></td>
	</tr>
	
	<tr>
		<td>Product Stock</td>
		<td><input type="text" name="stock" value="${product.stock}"/></td>
	</tr>
	
	<tr>
		<td>Product Price</td>
		<td><input type="text" name="price" value="${product.price}"/></td>
	</tr>
	
	<tr>
		<td>Category</td>
		<td>
		<select name='categoryId'>
		<c:forEach items='${categoryList}' var="category">
		<option value='${category.key}'>
		${category.value}
		</option>
		</c:forEach>
		</select> 
		</td>
	</tr>
	
	<tr>
		<td>Supplier</td>
		<td>
		
		<select name='supplierId'>
		<c:forEach items='${supplierList}' var="supplier">
		<option value='${supplier.key}'>
		${supplier.value}
		</option>
		</c:forEach>
		</select> 
		</td>
	</tr>
	
	
	
	
	<tr>
		<td>Product Image</td>
		<td><input type="file" name="pimage"></td>
	</tr>
	
	
	<tr>
		<td colspan="2">
		<center>
		<input type="submit" value="Update Product" class="btn"/>
		</center>
		</td>
	</tr>
</table>
</form>


</body>
</html>