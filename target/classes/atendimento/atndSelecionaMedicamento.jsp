<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Medicamentos</title>
<link href='<spring:url value="/resources/css/bootstrap.css" />'
	rel="stylesheet" />
<script src='<spring:url value="/resources/js/bootstrap.js" />'></script>
</head>
<body>
<a href="/administracao" class='btn btn-info btn-sm'>Administração</a>
<div class="container">
<div class="pb-2 mt-4 mb-2 border-bottom">
			<h1>Medicamentos</h1>
			</div>
			<h4>Selecione o medicamento</h4>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">Codigo</th>
					<th scope="col">Nome</th>
					<th scope="col" colspan=2>Descrição</th>
				</tr>
			</thead>
			<c:forEach items="${medicamentos}" var="medicamento"
				varStatus="status">
				<tr>
					<td><c:out value="${medicamento.id}" /></td>
					<td><a href="/atendimento/vet/medicamento/${medicamento.id}" class="link-primary"><c:out
								value="${medicamento.nome}" /></a></td>
					<td colspan=2><c:out value="${medicamento.descricao}" /></td>
				</tr>
			</c:forEach>
		</table>
			</div>
</body>
</html>