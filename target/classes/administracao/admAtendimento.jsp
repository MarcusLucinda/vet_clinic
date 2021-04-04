<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dados do Atendimento</title>
<link href='<spring:url value="/resources/css/bootstrap.css" />'
	rel="stylesheet" />
<script src='<spring:url value="/resources/js/bootstrap.js" />'></script>
</head>
<body>
<a href="/administracao" class='btn btn-info btn-sm'>Administração</a>
<div class="container">
		<div class="pb-2 mt-4 mb-2 border-bottom">
			<h1>Dados do atendimento</h1>
			</div>
			Cliente: ${atendimento.animal.dono.nome}<br>
			CPF: ${atendimento.animal.dono.cpf}<br><br>
			Dados do Animal<br>
			Especie: ${atendimento.animal.especie}<br>
			Raça: ${atendimento.animal.raca}<br>
			Idade: ${atendimento.animal.idade} anos<br>
		<br>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">Medicamentos</th>
				</tr>
			</thead>
			<c:forEach items="${atendimento.medicamentos}" var="medicamento"
				varStatus="status">
				<tr>
					<td><c:out value="${medicamento.nome}" /></td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">Exames</th>
				</tr>
			</thead>
			<c:forEach items="${atendimento.exames}" var="exame"
				varStatus="status">
				<tr>
					<td><c:out value="${exame.nome}" /></td>
				</tr>
			</c:forEach>
		</table>
		<br>
		Observações: ${atendimento.observacoes}
		</div>
</body>
</html>