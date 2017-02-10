<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<spring:url value="/resources/lib/bootstrap/css/bootstrap.min.css" var="bootstrapCss" />
	<link href="${bootstrapCss}" rel="stylesheet" />
	<title>Note</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h1>Note</h1>
			<table class="table">
				<tr>
					<th>#</th>
					<th>title</th>
					<th>note</th>
					<th>edit</th>
					<th>remove</th>
				</tr>
				<tr>
					<td>...</td>
					<td>...</td>
					<td>...</td>
					<td>...</td>
					<td>...</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>