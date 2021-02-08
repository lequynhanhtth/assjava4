<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<c:choose>
	<c:when test="${page.css == true}">
		<meta charset="UTF-8">
		<meta name="viewport"
			content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="stylesheet"
			href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
		<!-- Bootstrap CSS -->
		<link rel="stylesheet"
			href="https://code.jquery.com/jquery-3.3.1.slim.min.js">
		<link rel="stylesheet" href="views/css/style.css">
		<link rel="stylesheet"
			href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
			integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
			crossorigin="anonymous">
		<link rel="stylesheet"
			href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
		<link rel="preconnect" href="https://fonts.gstatic.com">
		<link
			href="https://fonts.googleapis.com/css2?family=Anton&display=swap"
			rel="stylesheet">
	</c:when>
	<c:otherwise>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!--===============================================================================================-->
		<link rel="icon" type="image/png"
			href="views/images/icons/favicon.ico" />
		<!--===============================================================================================-->
		<link rel="icon" type="image/png"
			href="views/images/icons/favicon.ico" />
		<!--===============================================================================================-->
		<link rel="stylesheet" type="text/css"
			href="views/vendor/bootstrap/css/bootstrap.min.css">
		<!--===============================================================================================-->
		<link rel="stylesheet" type="text/css"
			href="views/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
		<!--===============================================================================================-->
		<link rel="stylesheet" type="text/css"
			href="views/fonts/iconic/css/material-design-iconic-font.min.css">
		<!--===============================================================================================-->
		<link rel="stylesheet" type="text/css"
			href="views/vendor/animate/animate.css">
		<!--===============================================================================================-->
		<link rel="stylesheet" type="text/css"
			href="views/vendor/css-hamburgers/hamburgers.min.css">
		<!--===============================================================================================-->
		<link rel="stylesheet" type="text/css"
			href="views/vendor/animsition/css/animsition.min.css">
		<!--===============================================================================================-->
		<link rel="stylesheet" type="text/css"
			href="views/vendor/select2/select2.min.css">
		<!--===============================================================================================-->
		<link rel="stylesheet" type="text/css"
			href="views/vendor/daterangepicker/daterangepicker.css">
		<!--===============================================================================================-->
		<link rel="stylesheet" type="text/css" href="views/css/util.css">
		<link rel="stylesheet" type="text/css" href="views/css/main.css">

		<!--===============================================================================================-->
	</c:otherwise>
</c:choose>

<title>${page.title}</title>
</head>
<body>
	<c:if test="${not empty page.head }">
		<jsp:include page="${page.head}"></jsp:include>
	</c:if>
	<jsp:include page="${page.contenUrl }"></jsp:include>
	<c:if test="${not empty page.scriptUrl }">
		<jsp:include page="${page.scriptUrl}"></jsp:include>
	</c:if>
</body>
</html>