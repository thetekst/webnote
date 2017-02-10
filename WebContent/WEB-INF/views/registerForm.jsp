<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<spring:url value="/resources/lib/bootstrap/css/bootstrap.min.css" var="bootstrapCss" />
	<link href="${bootstrapCss}" rel="stylesheet" />
	<title>Registration</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h1>Registration</h1>
			<p>Total records: ${userCount}</p>
			<div class="col-sm-3">
				<form:form method="POST" modelAttribute="user">
					<div class="form-group">
						<label for="login">Login:</label>
						<form:input path="login" class="form-control" placeholder="login" />
						<form:errors path="login" />
					</div>
					<div class="form-group">
						<label for="email">Email:</label>
						<form:input path="email" type="email" class="form-control" placeholder="Email" />
						<form:errors path="email" />
					</div>
					
					<div class="form-group">
						<label for="password">Password:</label>
						<form:password path="password" class="form-control" placeholder="Password" />
						<form:errors path="password" />
					</div>
					
					<div class="checkbox">
						<label>
							<form:checkbox path="rememberMe" /> Check me out
						</label>
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form:form>
			</div>
		</div>
		<p><a href="/note">Note</a></p>
	</div>
</body>
</html>