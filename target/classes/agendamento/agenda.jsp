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
<spring:url value="/agendamento/agenda/datas/" var="seleciona"></spring:url>
<spring:url value="/agendamento/agenda/agendar/" var="agendar"></spring:url>

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

		<div class="form-group">
			<form action="${seleciona}" method="POST">
				<div class="form-group">
					<label for="dia">Selecione uma data:</label><br>
					<input type="date" class="form-control" name="dia" id="dia" value="${diaEscolhido}"/><br>
				<button type="submit" class="btn btn-primary btn-sm">Buscar Horarios</button>
		</div>
		<br>
		<c:choose>
		<c:when test="${not empty horarios}">
			<div class="col-md-3">
				<table class="table table-hover table-sm">
					<thead class="thead-light">
						<tr>
							<th class="text-center" colspan=2>Horários para ${dataTexto}</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="hora" items="${horarios}">
							<tr>
								<form:form action="">
									<td class="text-center">${hora}</td>
									<td class="text-center"><a href="${agendar}${hora}"
										class="btn btn-success btn-sm" onclick="return confirm('Confirmar agendamento?');">✓</a></td>
								</form:form>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:when>
		<c:otherwise>
		Nenhum horario disponivel para essa data
		</c:otherwise>
		</c:choose>

		</form>
		</div>
	</div>
</body>
</html>