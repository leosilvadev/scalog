<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<style>
	#main-footer{
		background-color: rgba(240, 240, 240, 0.51);
		border-radius: 5px;
		padding: 10px;
		margin-top: 10px;
		border: rgba(161, 161, 161, 0.26) 1px solid;
		text-align: center;
	}
</style>
<footer id="main-footer">
	<spring:message code="app.footer.label"/>
</footer>