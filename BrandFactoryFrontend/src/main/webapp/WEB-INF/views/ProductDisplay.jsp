
<%@ page language="java"%>
<%@ page isELIgnored="false"%>
<%@include file="Header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="w3-container">

<div class="row text-center text-lg-left">
	<c:forEach items="${productlist}" var="product">
		<div class="col-lg-4 col-md-4 col-xm-6 col-xs-12">
		<a href="<c:url value="/totalproductdisplay/${product.productid}"/>">
		<img class="img-fluid img-rounded" src="<c:url value="/resources/images/${product.productid}.jpg"/>" width="250" height="250"/>
		</a>
		<h4><strong>${product.productname}</strong></h4>
		<p>Price :INR ${product.price}/-</p>
		
		<p>Stock : <c:if test="${product.stock > 0}">
					${product.stock}
					</c:if>
					<c:if test="${product.stock <= 0}">
					<font color="red">Out Of Stock</font>
					</c:if>
					</p>
		</div>
		
	</c:forEach>
</div>

</div>
</body>
</html>