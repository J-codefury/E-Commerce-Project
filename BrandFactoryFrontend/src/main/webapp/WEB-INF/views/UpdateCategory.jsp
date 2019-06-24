<%@include file="Header.jsp"%>


<div class="container">
<form action="<c:url value="/updateCategory"/>" method="post">
<table class="table table-bordered">

	<tr bgcolor="grey">
	<td colspan="12"><h4><center><strong>Category Detail</strong></center></h4></td>
	</tr>
	
	<tr>
		<td>Category Id</td>
		<td><input type="number" name="catId" value="${category.categoryid}"readonly/></td>
	</tr>
	<tr>
		<td>Category Name</td>
		<td><input type="text" name="catName" value="${category.categoryname}"/></td>
	</tr>
	<tr>
		<td>Category Description</td>
		<td><textarea cols=30 rows="6" name="catDesc">${category.categorydesc}</textarea></td>
	</tr>
	<tr>
		<td colspan="2">
		<center>
		<input type="submit" value="Update Category" class="btn"/>
		</center>
		</td>
	</tr>
</table>
</form>


</body>
</html>