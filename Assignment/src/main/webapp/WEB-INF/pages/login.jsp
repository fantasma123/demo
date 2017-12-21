<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
	<title>Login</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style-login.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/my_javascript.js"></script>
</head>
<body>
	<div class="body_container">
		 <div class="h_container">
			<p><strong>LOGIN TO YOUR ACCOUNT</strong></p>
		  </div>

			
		<form action="handlingLogin" method="post" name="myForm" >
		  <div class="b_container">
		  	<p id="message"> ${message}</p>
		    <input type="text" placeholder="Enter Username" name="username" required>
		    <br>
		    <input type="password" placeholder="Enter Password" name="password" required>
		     <br>
		    <input type="submit" value="Login" id="button">
		  </div>
		</form>
	</div>
</body>
</html>

