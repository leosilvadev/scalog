<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<div id="modal-log" class="modal fade">
	<div class="modal-dialog">
		<form:form role="form" method="POST" commandName="log">
			<form:errors/>
			
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title">
						<spring:message code="log.modal-log.title"/>
					</h4>
				</div>
				<div class="modal-body">
						<div class="form-group">
							<label for="message">
								<spring:message code="log.modal-log.form.message"/>
							</label>
							<spring:message code="log.modal-log.form.message.placeholder" var="messagePlaceholder" scope="page"/>
							<form:input type="text" class="form-control" id="message" placeholder="${messagePlaceholder}" path="message"/>
							<form:errors cssClass="error-message" path="message"/>
						</div>
						
						<div class="form-group">
							<label for="detail">
								<spring:message code="log.modal-log.form.detail"/>
							</label>
							<spring:message code="log.modal-log.form.detail.placeholder" var="detailPlaceholder"/>
							<form:textarea class="form-control" id="detail" placeholder="${detailPlaceholder}" path="detail"/>
							<form:errors cssClass="error-message" path="detail"/>
						</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">
						<spring:message code="log.modal-log.close"/>
					</button>
					<button type="submit" class="btn btn-primary">
						<spring:message code="log.modal-log.save"/>
					</button>
				</div>
			</div>
		</form:form>
	</div>
</div>