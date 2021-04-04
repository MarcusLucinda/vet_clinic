<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Exames</title>
<link href='<spring:url value="/resources/css/bootstrap.css" />'
	rel="stylesheet" />
<script src='<spring:url value="/resources/js/bootstrap.js" />'></script>
</head>
<body>
<a href="/administracao" class='btn btn-info btn-sm'>Administração</a>
	<div class='container'>
		<div class="pb-2 mt-4 mb-2 border-bottom">
			<h1>Exames</h1>
		</div>
		<br> <a href="/administracao/exames/cadastro"
			class="btn btn-primary btn-sm">Cadastrar</a> <br><br>
		<h4>Lista de exames</h4>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">Codigo</th>
					<th scope="col">Nome</th>
				</tr>
			</thead>
			<c:forEach items="${exames}" var="exame"
				varStatus="status">
				<tr>
					<td><c:out value="${exame.id}" /></td>
					<td><a href="/administracao/exames/altera/${exame.id}"
						class="link-primary"><c:out value="${exame.nome}" /></a></td>
				</tr>
			</c:forEach>
		</table>

	</div>
</body>
</html>