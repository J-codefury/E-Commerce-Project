<%@include file="Header.jsp"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">
	<br>  
	 
<hr>
<div class="card">
	<div class="row">
		<aside class="col-sm-5 border-right">
<article class="gallery-wrap"> 
<div class="img-big-wrap">
  <div> <a href="#">
  <img src="<c:url value="/resources/images/${product.productid}.jpg"/>" width="400"></a>
  </div>
  </div>
</article>

 <!-- gallery-wrap .end// -->
		</aside>
		<aside class="col-sm-7">
<article class="card-body p-5">
	<h3 class="title mb-3">${product.productname}</h3>

<p class="price-detail-wrap"> 
	<span class="price h3 text-warning"> 
		<span class="currency">INR  </span><span class="num">${product.price}</span>
	</span> 
	 
</p> <!-- price-detail-wrap .// -->
<dl class="item-property">
  <dt>Description</dt>
  <dd>
  <p>${product.productdesc} </p>
  </dd>
</dl>
<dl class="param param-feature">
  <dt>Stock</dt>
  <dd>${product.stock}</dd>
</dl>  <!-- item-property-hor .// -->
<dl class="param param-feature">
  <dt>Supplier</dt>
  <dd>${product.supplierid}</dd>
</dl>  <!-- item-property-hor .// -->
<dl class="param param-feature">
<dt>Category</dt>
<dd>${product.categoryid}</dd>
</dl>
<hr>
<c:if test="${sessionScope.role=='ROLE_USER'}">
<form action="<c:url value="/addToCart/${product.productid}"/>">

	<div class="row">
		<div class="col-sm-5">
			<dl class="param param-inline">
			  <dt>Quantity: </dt>
			  <dd>
			  	<select name="quantity" class="form-control form-control-sm" style="width:70px;">
			  		<option> 1 </option>
			  		<option> 2 </option>
			  		<option> 3 </option>
			  	</select>
			  </dd>
			  </dl>
		</div> 

	</div> 
		<hr>
		<input type="submit"
	 class="btn btn-lg btn-outline-primary text-uppercase" value="Add To Cart">
	 </form>
	 </c:if>
	 <c:if test="${sessionScope.role=='ROLE_ADMIN'}">
		<a href="<c:url value='/login'/>"class="btn btn-lg btn-outline-primary text-uppercase"><span class="glyphicon glyphicon-shopping-cart"></span>Add to Cart</a>
	 </c:if>
	 
	 <c:if test="${!sessionScope.loggedIn}">
		<a href="<c:url value='/login'/>"class="btn btn-lg btn-outline-primary text-uppercase"><span class="glyphicon glyphicon-shopping-cart"></span>Add to Cart</a>
	 </c:if>
	 
</article> 
<!-- card-body.// -->
		</aside> <!-- col.// -->
	</div> <!-- row.// -->
</div> <!-- card.// -->


</div>
<!--container.//-->


<br>
<br>
<br>

<br>
<br>
<br>