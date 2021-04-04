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
	<div class='container'>
		<div class="pb-2 mt-4 mb-2 border-bottom">
			<h1>Medicamentos</h1>
		</div>
		<br> <a href="/administracao/medicamentos/cadastro"
			class="btn btn-primary btn-sm">Cadastrar</a> <br><br>
		<h4>Lista de medicamentos</h4>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">Codigo</th>
					<th scope="col">Nome</th>
					<th scope="col">Descricao</th>
				</tr>
			</thead>
			<c:forEach items="${medicamentos}" var="medicamento"
				varStatus="status">
				<tr>
					<td><c:out value="${medicamento.id}" /></td>
					<td><a href="/administracao/medicamentos/altera/${medicamento.id}"
						class="link-primary"><c:out value="${medicamento.nome}" /></a></td>
					<td><c:out value="${medicamento.descricao}" /></td>
				</tr>
			</c:forEach>
		</table>

	</div>
</body>
</html>