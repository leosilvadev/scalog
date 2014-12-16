<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<spring:url value="/resources" var="resources" scope="request"/>

<!DOCTYPE html>
<style type="text/css">
	@IMPORT url("${resources}/dist/css/bootstrap.min.css");
	@IMPORT url("${resources}/dist/css/bootstrap-theme.min.css");
	
	#login-control{
		width: 400px;
		margin-left: auto;
		margin-right: auto;
		margin-top: 100px;
	}
	
	#login-control input[type=submit]{
		width: 100%;
		margin-top: 10px;
	}
</style>
<div id="login-control">
	<div class="panel panel-primary">
		<div class="panel-heading">
			Painel de Acesso
		</div>
		<div class="panel-body">
			<form action="authentication" method="post">
				<label for="username">Usuário</label>
				<input id="username" name="username" required class="form-control">
				
				<label for="password">Senha</label>
				<input id="password" name="password" required class="form-control" type="password">
				
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				
				<input id="btn-login" class="btn btn-primary" value="Entrar" type="submit">
			</form>
		</div>
	</div>
</div>