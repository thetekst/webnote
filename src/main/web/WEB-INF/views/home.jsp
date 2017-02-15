<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<spring:url value="/resources/lib/bootstrap/css/bootstrap.min.css" var="bootstrapCss" />
	<link href="${bootstrapCss}" rel="stylesheet" />
	<title>Home</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h1>Home</h1>
			<a href="/webnote/note">Note</a>
		</div>
	</div>
</body>
</html>