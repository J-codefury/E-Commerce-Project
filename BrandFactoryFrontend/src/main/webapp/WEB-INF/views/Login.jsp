<%@ page language="java" contentType="text/html"%>
<%@include file="Header.jsp" %>

<div class="container">
<form action="perform_login" method="post">
<table class="table table-bordered">


<tr bgcolor="grey">
<td colspan="12"><center><strong>Sign in Here</strong></center></td>
</tr>

<tr>
<td colspan="6"> User Name</td>
<td colspan="6"><input type="text" placeholder="Enter username" name="username"/></td>
</tr>

<tr>
<td colspan="6"> Password</td>
<td colspan="6"><input type="password" placeholder="Enter password" name="password"/></td>
</tr>


<tr>
	<td colspan="12">
		<center>
		<input type="submit" value="login" class="btn"/>
		</center>
	</td>
</tr>

</table>

<p><font color="blue">Please Login to shop Online . . .</font></p>

</form>
</div>
</body>
</html>