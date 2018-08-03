<!DOCTYPE html>
<html>
<head>
	<!-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> -->
	<!-- <meta charset="ISO-8859-1">
	<title>User Management</title>
	
	<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"> -->
</head>
<body>
	<h3>User Login Form</h3>
	<!-- <form action="j_spring_security_check"> ng-submit="processLogin()"> -->
	<!-- <form method="POST" id="login_form"  action="j_spring_security_check">
		<div class="table-responsive">
			<table class="table table-bordered" style="width: 600px">
				<tr>
					<td>User Id </td>
					<td><input type="text" name="userid" size="30"  />
					</td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" size="30"  />
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" class="btn btn-primary btn-sm"  value="Login"  />
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
									      <font color="red">
									        	Your login attempt was not successful due to <br/>
									        	<strong><c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.</strong>
									      </font>
									      <c:remove var = "SPRING_SECURITY_LAST_EXCEPTION" scope = "session" />
									</c:if>
					</td>
				</tr>
				
			</table>
		</div>
	</form> -->
</body>

<script
	src="//ajax.googleapis.com/ajax/libs/angularjs/1.6.0/angular.min.js"></script>
<script type="text/javascript">
	
</script>
</html>