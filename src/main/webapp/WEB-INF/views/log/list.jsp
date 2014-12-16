<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
	<head>
		<title>
			<spring:message code="log.list.title"/>
		</title>
	</head>
	
	<body class="container">
		<jsp:include page="../templates/online/header.jsp"/>
		
		<section id="sec-table-logs">
			<jsp:include page="table-logs.jsp"/>
		</section>
		
		<jsp:include page="../templates/online/footer.jsp"/>
		<jsp:include page="modal-log.jsp"/>
		
		<script type="text/javascript" src="${resources}/dist/js/jquery-2.1.1.min.js"></script>
		<script type="text/javascript" src="${resources}/dist/js/bootstrap.min.js"></script>
		<script type="text/javascript">
			$(function(){
				applyPagination();
			});
			
			function applyPagination(){
				$('.pagination li:not(.disabled) a').on('click', function(){
					var _self = $(this);
					var size = 10;
					var page = _self.data('page');
					var url = 'logs/table?page='+page+'&size='+size;
					
					$.get(url, function(response){
						$('#sec-table-logs').html(response);
						applyPagination();
					});
				});
			}
		</script>
		<c:if test="${not empty error}">
			<script type="text/javascript">
				$('#modal-log').modal('show');
			</script>
		</c:if>
	</body>
</html>