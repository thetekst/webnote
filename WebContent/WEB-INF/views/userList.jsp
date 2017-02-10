<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<spring:url value="/resources/lib/bootstrap/css/bootstrap.min.css" var="bootstrapCss" />
	<link href="${bootstrapCss}" rel="stylesheet" />
	<title>User list</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h1>User list</h1>
			
			<c:if test="${not empty users}">
				<table class="table">
					<tr>
						<th>#</th>
						<th>login</th>
						<th>edit</th>
						<th>remove</th>
					</tr>
					
					<c:forEach var="user" items="${users}">
						<tr>
							<td>${user.getId()}</td>
							<td>${user.getLogin()}</td>
							<td><a href="#edit"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a></td>
							<td><a href="#remove"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></td>
						</tr>
					</c:forEach>
					
				</table>
			</c:if>
		</div>
	</div>
</body>
</html>