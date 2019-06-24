<%@ page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="Header.jsp" %>



<div class="container">
<form action="registerUser" method="post">
<table class="table table-bordered">

    
   
<tr bgcolor="grey">
<td colspan="12"><center><strong>Sign up Here</strong></center></td>
</tr>   
   
   
   
   
    
<tr>
<td colspan="6"> User Name</td>
<td colspan="6"><input type="text" placeholder="Enter username" name="username" pattern="^[a-z0-9_-]{3,15}$" title="3 to 15 characters with any lower case character, digit or special symbol '_-' only" required/></td>
</tr>


<tr>
<td colspan="6"> E-mail ID</td>
<td colspan="6"><input type="text" placeholder="Enter E-mail Id" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" title="example:xyz@xyz.com" required/></td>
</tr>


<tr>
<td colspan="6"> Address</td>
<td colspan="6"><input type="text" placeholder="Enter Address" name="address" required/></td>
</tr>


<tr>
<td colspan="6"> Mobile.No</td>
<td colspan="6"><input type="text" placeholder="Enter Mobile.No" name="mobile" pattern="^\d{10}$" title="must contain 10 digits" required/></td>
</tr>


<tr>
<td colspan="6"> Password</td>
<td colspan="6"><input type="password" placeholder="Enter Password" name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"required/></td>
</tr>
    
    
    
<tr>
	<td colspan="12">
		<center>
		<input type="submit" value="Register" class="btn"/>
		</center>
	</td>
</tr>
    

</table>


<div class="container signin">
    <p>Already have an account? <a href="login">Sign in</a>.</p>
</div>


</form>
</div>




</body>
</html>

