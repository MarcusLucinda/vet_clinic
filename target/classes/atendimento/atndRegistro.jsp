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
<spring:url value="/atendimento/vet/${agendamento.veterinario.id}/registra/${agendamento.id}/medicamentos" var="selMed"></spring:url>
<spring:url value="/atendimento/vet/${agendamento.veterinario.id}/registra/${agendamento.id}/exames" var="selEx"></spring:url>
<spring:url value="/atendimento/vet/registrar" var="registrar"></spring:url>
</head>
<body>
<a href="/administracao" class='btn btn-info btn-sm'>Administração</a>
<div class="container">
<div class="pb-2 mt-4 mb-2 border-bottom">
			<h1>Registro de Atendimento</h1>
			</div>
			Cliente: ${agendamento.animal.dono.nome}<br>
			CPF: ${agendamento.animal.dono.cpf}<br><br>
			Dados do Animal<br>
			Especie: ${agendamento.animal.especie}<br>
			Raça: ${agendamento.animal.raca}<br>
			Idade: ${agendamento.animal.idade} anos<br>
		<br>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">Medicamentos</th>
				</tr>
			</thead>
			<c:forEach items="${medicamentos}" var="medicamento"
				varStatus="status">
				<tr>
					<td><c:out value="${medicamento.nome}" /></td>
				</tr>
			</c:forEach>
			<tr><td><a href="${selMed}" class="link-primary"><c:out
								value="Adicionar" /></a></td></tr>
		</table>
		<br>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">Exames</th>
				</tr>
			</thead>
			<c:forEach items="${exames}" var="exame"
				varStatus="status">
				<tr>
					<td><c:out value="${exame.nome}" /></td>
				</tr>
			</c:forEach>
			<tr><td><a href="${selEx}" class="link-primary"><c:out
								value="Adicionar" /></a></td></tr>
		</table>
		<br>
		<form:form action="${registrar}" modelAttribute="observacoes">
		<div class="form-group">
		<label>Observações:</label>
		<form:input path="obs" cssClass="form-control"
			 required="required" rows="3"/>
	</div>
		<input type="submit" class="btn btn-primary" name="registrar"
		value="Registrar" />
		</form:form>
		</div>
</body>
</html>