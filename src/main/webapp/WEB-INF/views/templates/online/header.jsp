<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<spring:url value="/logs" var="url_list" />
<spring:url value="/" var="url_index" />

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
	
	tfoot tr{
		text-align: right;
	}
</style>

<nav class="navbar navbar-default" role="navigation">
	<div>
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#main-navbar-collapse">
				<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${url_index}">
				<spring:message code="app.name"/>
			</a>
		</div>
	
		<div class="collapse navbar-collapse" id="main-navbar-collapse">
			<ul class="nav navbar-nav">
				<li>
					<a href="${url_list}">
						<spring:message code="app.online.header.menu.logs"/>
					</a>
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li>
					<a href="?lang=pt_BR" class="flag">
						<img alt="Português" src="resources/img/flag_bra.png">
					</a>
				</li>
				<li>
					<a href="?lang=en_US" class="flag">
						<img alt="English" src="resources/img/flag_usa.png">
					</a>
				</li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
						<spring:message code="app.online.header.menu.options"/> <span class="caret"></span>
					</a>
					<ul class="dropdown-menu" role="menu">
						<li>
							<a href="#">
								<spring:message code="app.online.header.menu.configuration"/>
							</a>
						</li>
						<li class="divider"></li>
						<li>
							<a href="#">
								<spring:message code="app.online.header.menu.logout"/>
							</a>
						</li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</nav>