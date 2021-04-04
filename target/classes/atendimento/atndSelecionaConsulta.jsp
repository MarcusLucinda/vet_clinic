<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro de atendimento</title>
<link href='<spring:url value="/resources/css/bootstrap.css" />'
	rel="stylesheet" />
<script src='<spring:url value="/resources/js/bootstrap.js" />'></script>
<spring:url value="/atendimento/vet/${veterinario.id}/registra/" var="registra"></spring:url>
</head>
<body>]
<a href="/administracao" class='btn btn-info btn-sm'>Administração</a>
<div class="container">
<div class="pb-2 mt-4 mb-2 border-bottom">
			<h1>Veterinario</h1>
		</div>
		
		<div class="card" style="width: 18rem;">
				<div class="card-body">
					<h5 class="card-title">${veterinario.nome}</h5>
					<h6 class="card-subtitle mb-2 text-muted">${veterinario.crmv}</h6>
				</div>
				<br>
			</div>
			<h4>Selecione o atendimento realizado</h4>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">Data</th>
					<th scope="col">Hora</th>
					<th scope="col">Animal</th>
					<th scope="col">Cliente</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<c:forEach items="${agendas}" var="agenda"
				varStatus="status">
				<tr>
					<td><c:out value="${agenda.data}" /></td>
					<td><c:out value="${agenda.horario}" /></td>
					<td><c:out value="${agenda.animal}" /></td>
					<td><c:out value="${agenda.cliente}" /></td>
					<td class="text-center"><a href="${registra}${agenda.id}"
										class="btn btn-info btn-sm">Registrar</a></td>
				</tr>
			</c:forEach>
		</table>
			</div>
</body>
</html>