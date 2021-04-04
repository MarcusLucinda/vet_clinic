<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de veterinarios</title>
<spring:url value="/agendamento/vet/escolhido/" var="seleciona"></spring:url>

<link href='<spring:url value="/resources/css/bootstrap.css" />'
	rel="stylesheet" />
<script src='<spring:url value="/resources/js/bootstrap.js" />'></script>
</head>
<body>
<a href="/" class='btn btn-info btn-sm'>Home</a>
	<div class="container">
		<div class="pb-2 mt-4 mb-2 border-bottom">
			<h1>Agendamento</h1>
		</div>
		<br>
		<h4>Selecione um veterinário</h4>
		<form:form modelAttribute="veterinario" action="${seleciona}"
			method="post">
		
				<div class="form-group">
					<table class="table table-striped">
						<thead>
							<tr>
								<th scope="col"></th>
								<th scope="col">Nome</th>
								<th scope="col">CRMV</th>
								<th scope="col">Especialidade</th>
								<th scope="col">Telefone</th>
							</tr>
						</thead>
						<c:forEach items="${veterinarios}" var="veterinario"
							varStatus="status">
							<tr>
								<td><form:radiobutton path="id" value="${veterinario}" required="required" /></td>
								<td><c:out value="${veterinario.nome}" /></td>
								<td><c:out value="${veterinario.crmv}" /></td>
								<td><c:out value="${veterinario.especialidade}" /></td>
								<td><c:out value="${veterinario.telefone}" /></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			<div class="form-group">
				<input type="submit" value="Selecionar" class="btn btn-success btn">
			</div>
		</form:form>

	</div>
</body>
</html>