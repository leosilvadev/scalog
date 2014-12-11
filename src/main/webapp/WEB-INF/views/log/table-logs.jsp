<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<table class="table table-bordered table-striped table-condensed">
	<thead>
		<tr>
			<td>
				<spring:message code="log.list.table.column.code"/>
			</td>
			<td>
				<spring:message code="log.list.table.column.message"/>
			</td>
			<td>
				<spring:message code="log.list.table.column.detail"/>
			</td>
		</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${empty logsPage.content}">
				<tr>
					<td colspan="3">
						<spring:message code="log.list.table.nothingfound"/>
					</td>
				</tr>
			</c:when>
			
			<c:when test="${not empty logsPage.content}">
				<c:forEach var="log" items="${logsPage.content}">
					<tr>
						<td>${log.id}</td>
						<td>${log.message}</td>
						<td>${log.detail}</td>
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="3">
				<a href="#" class="btn btn-primary" data-toggle="modal" data-target="#modal-log">
					<spring:message code="log.list.btn.new"/>
				</a>
			</td>
		</tr>
	</tfoot>
</table>
<nav style="text-align: center;">
	<ul class="pagination">
		<c:set var="previousDisabled" value=""/>
		<c:if test="${logsPage.number le 0}">
			<c:set var="previousDisabled" value="disabled"/>
		</c:if>
		<li class="${previousDisabled}">
			<a href="#" data-page="${logsPage.number}">
				<span aria-hidden="true">&laquo;</span><span class="sr-only">Previous</span>
			</a>
		</li>
		
		<c:forEach begin="1" var="page" end="${logsPage.totalPages}">
			<c:choose>
				<c:when test="${page eq logsPage.number+1}">
					<li class="active"><a href="#" data-page="${page}">${page}</a></li>
				</c:when>
				
				<c:when test="${page ne logsPage.number+1}">
					<li><a href="#" data-page="${page}">${page}</a></li>
				</c:when>
			</c:choose>
		</c:forEach>
		
		<c:set var="nextDisabled" value=""/>
		<c:if test="${logsPage.number+1 eq logsPage.totalPages}">
			<c:set var="nextDisabled" value="disabled"/>
		</c:if>
		<li class="${nextDisabled}">
			<a href="#" data-page="${logsPage.number+2}">
				<span aria-hidden="true">&raquo;</span><span class="sr-only">Next</span>
			</a>
		</li>
	</ul>
</nav>