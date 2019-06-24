<%@ page language="java" contentType="text/html"%>
<%@include file="Header.jsp"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">

<form action="<c:url value="/addCategory"/>" method="post">
<table align="center" class="table table-bordered">
	<tr bgcolor="grey">
		<td colspan="3"><h4><center> Add Category Detail</center></h4></td>
	</tr>
	<tr>
		
		<td><h4>Category Name</h4></td>
		<td><h4>Category Description</h4></td>
		<td><h4>Operation</h4></td>
	</tr>
	<tr>
		
		<td><input type="text" name="catName" id="catName"/></td>
		<td><textarea cols=30 rows="1" name="catDesc"></textarea></td>
		<td><input type="submit" value="Add Category" class="btn"/></td>
	</tr>
	
</table>
</form>



<table align="center" class="table table-bordered">

<tr>
	<td bgcolor="grey" colspan="4"><h4><center>Category Detail</center></h4></td>
</tr>

<tr>

	<td><h4>ID</h4></td>
	
	<td><h4>Name</h4></td>
	
	<td><h4>Description</h4></td>
	
	<td><h4>Operation</h4></td>
</tr>

<c:forEach items="${listCategories}" var="category">
<tr>
	
	<td>${category.categoryid}</td>
	
	<td>${category.categoryname}</td>
	
	<td>${category.categorydesc}</td>
	
	<td>
		<a href="<c:url value="/editCategory/${category.categoryid}"/>">
		
		<input type="submit" value="EDIT" class="btn"/> &nbsp;&nbsp;&nbsp; </a>
		
		<a href="<c:url value="/deleteCategory/${category.categoryid}"/>">
		
		<input type="submit" value="DELETE" class="btn"/> </a> 
	</td>
</tr>
</c:forEach>
</table>
</div>