<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agenda</title>
<link href='<spring:url value="/resources/css/bootstrap.css" />'
	rel="stylesheet" />
<script src='<spring:url value="/resources/js/bootstrap.js" />'></script>
<spring:url value="/administracao/vet/${veterinario.id}/cancela/"
	var="cancela"></spring:url>
</head>
<body>
<a href="/administracao" class='btn btn-info btn-sm'>Administração</a>
	<div class="container">
		<div class="pb-2 mt-4 mb-2 border-bottom">
			<h1>Atendimentos</h1>
		</div>

		<div class="card" style="width: 18rem;">
			<div class="card-body">
				<h5 class="card-title">${veterinario.nome}</h5>
				<h6 class="card-subtitle mb-2 text-muted">${veterinario.crmv}</h6>
			</div>
		</div>
		<br>
		<h4>Atendimentos</h4>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">Código</th>
					<th scope="col">Data</th>
					<th scope="col">Cliente</th>
					<th scope="col">Animal</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<c:forEach items="${atendimentos}" var="atendimento" varStatus="status">
				<tr>
					<td><a href="${veterinario.id}/info/${atendimento.id}" class="link-primary">
					<c:out value="${atendimento.id}" /></a></td>
					<td><c:out value="${atendimento.horario}" /></td>
					<td><c:out value="${atendimento.animal.dono.nome}" /></td>
					<td><c:out value="${atendimento.animal.especie}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>