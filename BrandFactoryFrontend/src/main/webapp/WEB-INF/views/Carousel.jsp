<%@ page language="java"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<div class="w3-container">
  <h2>Hello, ${sessionScope.username}</h2>  
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
      <li data-target="#myCarousel" data-slide-to="4"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active" >
        <img src="<c:url value="/resources/images/apple.jpg"/>"alt="Apple" style="width:100%;">
      </div>

      <div class="item">
        <img src="<c:url value="/resources/images/samsung.jpg"/>" alt="Samsung" style="width:100%;">
      </div>
    
      <div class="item">
        <img src="<c:url value="/resources/images/mi.jpg"/>" alt="MI" style="width:100%;">
      </div>
        <div class="item">
        <img src="<c:url value="/resources/images/oneplus.jpg"/>" alt="Oneplus" style="width:100%;">
      </div>
        <div class="item">
        <img src="<c:url value="/resources/images/oppo.jpg"/>" alt="oppo" style="width:100%;">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    
    
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>



<p></p>

  
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