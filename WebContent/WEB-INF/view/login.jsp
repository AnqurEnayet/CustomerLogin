<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Customer Login</title>
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>Customer Login Page</h2>
		</div>
	</div>

	<div id="container">
	
		<form:form action="verifyCustomer" modelAttribute="customer" method="Post">
          	<input type=?email? name="email" placeholder="Username or Email" class="email"><br>
         	<input type="password" name="password" placeholder="password" class="password"><br>
          	<input type="submit" name="" value="Log In" class="login">
		</form:form>
	</div>

</body>

</html>