<%@ page language="java" contentType="text/html"%>
<%@include file="/WEB-INF/views/Header.jsp" %>
<%@include file="/WEB-INF/views/Carousel.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>




<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

<div class="jumbotron text-center">
  <h1>Original Brands Smart Prices</h1>
  <p>Handpicked favourites just for you </p> 
</div>


<div class="w3-container">
  <div class="col-lg-4 col-md-4 col-xm-6 col-xs-12">
  <a href="<c:url value='/productDisplay'/>">           
  <img src="<c:url value="/resources/images/1000.jpg"/>" class="img-rounded"  alt="Cinque Terre" width="400" height="400"> </a>
 <h2><center><strong>For mobile fans,.</strong></center></h2>	
 	</div>
 	</div>
  
  <div class="w3-container">
  <div class="col-lg-4 col-md-4 col-xm-6 col-xs-12">
  <a href="<c:url value='/productDisplay'/>">  
  <img src="<c:url value="/resources/images/2000.jpg"/>" class="img-rounded"  alt="Cinque Terre" width="400" height="400"></a>
  <h2><center><strong>Communicate with tomorrow.</strong></center></h2>
  </div>
  </div>
  
  
  <div class="w3-container">
  <div class="col-lg-4 col-md-4 col-xm-6 col-xs-12">
  <a href="<c:url value='/productDisplay'/>">  
  <img src="<c:url value="/resources/images/3000.jpg"/>" class="img-rounded"  alt="Cinque Terre" width="400" height="400"></a>
  <h2><center><strong>Go on, get your cell phones out.</strong></center></h2>
  </div>
 
</div>










  
<div class="w3-container">
  <div class="row">
    <div class="col-sm-4">
      <h3>Apple</h3>
      <p> Apple, owns mobile os and the device.The most secure mobile os, developed by Apple itself.</p>
    </div>
    <div class="col-sm-4">
      <h3>SAMSUNG</h3>
      <p>Over the years, Samsung has launched various smartphones with stylish designs and high-quality features.</p>
    </div>
    <div class="col-sm-4">
      <h3>MI</h3>        
      <p>Whether you want a high-performance smartphone or a budget-friendly one, Mi has one for all your needs.</p>
    </div>
  </div>
</div>



<div class="w3-container">
  <div class="row">
    <div class="col-sm-4">
      <h3>OPPO</h3>
      <p>Oppo mobiles are best known for their impeccable cameras and stylish aesthetics . Rightly called the 'camera phone'</p>
    </div>
    <div class="col-sm-4">
      <h3>OnePlus</h3>
      <p>Never Settle is not just a slogan, but a pledge to be a better version of yourself.</p>
    </div>
    <div class="col-sm-4">
      <h3>motorola</h3>        
      <p>possibilities.performance.power.Get the features you need for the life you lead.</p>
    </div>
  </div>
</div>




<div class="w3-container">
  <div class="row">
    <div class="col-sm-4">
      <h3>realme</h3>
      <p>realme is an emerging smartphone brand which is committed to offering products with powerful performance, stylish design and sincere services.</p>
    </div>
    <div class="col-sm-4">
      <h3>HONOR</h3>
      <p>Explore latest Honor mobile phones and accessories tailor-made to be used for next-gen smartphone users.</p>
    </div>
    <div class="col-sm-4">
      <h3>Huawei</h3>        
      <p>Huawei is a leading global provider of information and communications technology (ICT) infrastructure and smart devices.</p>
    </div>
  </div>
</div>











<div class="jumbotron text-center">
  <h1>BrandFactory.com</h1>
  <p>India / Australia  /  Brazil / Canada / China / France / Germany / Italy / Japan / Mexico / Netherlands / Spain / UnitedArab / Emirates / United Kingdom / United States</p> 
</div>

</body>
</html>