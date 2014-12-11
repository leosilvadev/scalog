<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
	<head>
		<title>
			<spring:message code="index.title"/>
		</title>
		<style type="text/css">
			@IMPORT url("resources/dist/css/bootstrap.min.css");
			@IMPORT url("resources/dist/css/bootstrap-theme.min.css");
			.error-message{
				color: red;
				font-style: italic;
			}
			
			.flag{
				padding-top: 11px !important;
				padding-left: 5px !important;
				padding-right: 5px !important;
			}
		</style>
	</head>
	
	<body class="container">
		<jsp:include page="templates/online/header.jsp"/>
		<section>
			<h1>
				<spring:message code="index.message"/>
			</h1>
		</section>
		<jsp:include page="templates/online/footer.jsp"/>
	</body>
</html>