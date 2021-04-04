<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Veterinarios</title>
<link href='<spring:url value="/resources/css/bootstrap.css" />'
	rel="stylesheet" />
<script src='<spring:url value="/resources/js/bootstrap.js" />'></script>
</head>
<body>
<a href="/administracao" class='btn btn-info btn-sm'>Administração</a>
	<div class='container'>
		<div class="pb-2 mt-4 mb-2 border-bottom">
			<h1>Veterinários</h1>
		</div>
		<br>
		<h4>Selecione o veterinário</h4>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">CRMV</th>
					<th scope="col">Nome</th>
					<th scope="col">Especialidade</th>
					<th scope="col">Telefone</th>
				</tr>
			</thead>
			<c:forEach items="${veterinarios}" var="veterinario"
				varStatus="status">
				<tr>
					<td><c:out value="${veterinario.crmv}" /></td>
					<td><a href="/atendimento/vet/${veterinario.id}" class="link-primary"><c:out
								value="${veterinario.nome}" /></a></td>
					<td><c:out value="${veterinario.especialidade}" /></td>
					<td><c:out value="${veterinario.telefone}" /></td>
				</tr>
			</c:forEach>
		</table>

	</div>
</body>
</html>