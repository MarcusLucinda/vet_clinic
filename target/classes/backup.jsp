<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agendamento</title>
<spring:url value="/agendamento/busca/" var="busca"></spring:url>
<spring:url value="/agendamento/seleciona/" var="seleciona"></spring:url>
<spring:url value="/agendamento/novobicho/" var="novoAnimal"></spring:url>
<link href='<spring:url value="/resources/css/bootstrap.css" />'
	rel="stylesheet" />
<script src='<spring:url value="/resources/js/jquery-3.5.1.min.js" />'></script>
<script src='<spring:url value="/resources/js/bootstrap.js" />'></script>
</head>
<body>
	<div class='container'>
		<div class="pb-2 mt-4 mb-2 border-bottom">
			<h1>Agendamento</h1>
		</div>
		<c:if test="${dono.cpf == null}">

			<form:form action="${busca}" method="POST">
				<div class="form-group">
					<label>CPF do cliente:</label> <input type='text' name='cpfDono'
						class="form-control" /> <small id="cont"
						class="form-text text-muted">Utilize apenas numeros</small>
				</div>


				<div class="form-group">
					<label>&nbsp;</label> <input type="submit" value="Buscar"
						class="btn btn-primary btn">
				</div>
			</form:form>
		</c:if>


		<c:if test="${dono.cpf != null}">
			
			${dono.cpf}
			${dono.nome}


			<form:form modelAttribute="animal" action="${seleciona}"
				method="post">
				<div class="form-group">
				<label>Selecione o bicho:</label>
				<form:select path="id" cssClass="btn btn-outline-secondary dropdown-toggle form-control">
					<form:option value="NONE" label="Select" />
					<form:options items="${animais}" itemValue="id" itemLabel="nome"
						name="animal" />
				</form:select>
				</div>
				<div class="form-group">
					<input type="submit" value="Confirmar" class="btn btn-success btn">
					</div>
				
			</form:form>
<br>

Ou

			<div>
				<form:form modelAttribute="dono" action="${novoAnimal}"
					method="post">

					<form:hidden path="cpf" />
					<form:hidden path="nome" />
					<input type="submit" class="btn btn-primary" name="novoAnimal"
						value="Cadastrar novo bicho" />
				</form:form>
			</div>
		</c:if>

	</div>

</body>





<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<spring:url value="/vet/escolhido/" var="seleciona"></spring:url>

<link href='<spring:url value="/resources/css/bootstrap.css" />'
	rel="stylesheet" />
<script src='<spring:url value="/resources/js/jquery-3.5.1.min.js" />'></script>
<script src='<spring:url value="/resources/js/bootstrap.js" />'></script>
</head>
<body>
	<div class="container">
		<div class="pb-2 mt-4 mb-2 border-bottom">
			<h1>Selecione o veterinário</h1>
		</div>
		<form:form modelAttribute="veterinario" action="${seleciona}"
			method="post">
			<div class="form-group">
				<form:select path="id"
					cssClass="btn btn-outline-secondary dropdown-toggle form-control">
					<form:option value="NONE" label="Select" />
					<form:options items="${veterinarios}" itemValue="id"
						itemLabel="nome" name="veterinario" />
				</form:select>
			</div>
			<div class="form-group">
				<input type="submit" value="Esse" class="btn btn-primary btn">
			</div>
		</form:form>

	</div>
</body>
</html>

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
<spring:url value="/agenda/datas/" var="seleciona"></spring:url>
<spring:url value="/agenda/agendar/" var="agendar"></spring:url>

<link href='<spring:url value="/resources/css/bootstrap.css" />'
	rel="stylesheet" />
<script src='<spring:url value="/resources/js/jquery-3.5.1.min.js" />'></script>
<script src='<spring:url value="/resources/js/bootstrap.js" />'></script>
</head>
<body>
	<div class="container">
		Agenda

		<form action="${seleciona}" method="POST">
			<div class="form-group">
				<label for="dia">Selecione a data</label> <input type="date"
					name="dia" id="dia" value="${diaHoje}" />
			</div>

			<button type="submit" class="btn btn-primary">Selecionar</button>

			<c:if test="${not empty horarios}">
				<table>
					<tr>
						<th>Horarios</th>
						<th colspan="2">Ações</th>
					</tr>
					<c:forEach var="hora" items="${horarios}">
						<tr>
						<form:form action="">
							<td>${hora}</td>
							<td><a href="${agendar}${hora}">Agendar</a></td>
							</form:form>
							</tr>
					</c:forEach>
				</table>
			</c:if>

		</form>
	</div>

</body>
</html>