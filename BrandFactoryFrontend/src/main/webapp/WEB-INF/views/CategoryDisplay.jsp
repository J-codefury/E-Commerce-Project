<%@ page language="java"%>
<%@include file="Header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<div class="w3-container">

<div class="row text-center text-lg-left">

	<c:forEach items="${categorylist}" var="category">
		<div class="col-lg-4 col-md-4 col-xm-6 col-xs-12">
			 	<a href="<c:url value="/productCategoryWise/${category.categoryid}"/>">
			 	<img class="img-fluid img-rounded" src="<c:url value="/resources/images/${category.categoryid}.jpg"/>" width="250" height="250"/>
			 	</a>
			 	<h4><strong>${category.categoryname}</strong></h4>
			 	</div>
			 	</c:forEach>
			 	
			 	
</div>
</div>