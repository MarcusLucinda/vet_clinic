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
<script src='<spring:url value="/resources/js/bootstrap.js" />'></script>
</head>
<body>
<a href="/" class='btn btn-info btn-sm'>Home</a>
	<div class='container'>
		<div class="pb-2 mt-4 mb-2 border-bottom">
			<h1>Agendamento</h1>
		</div>
		<c:if test="${dono.cpf == null}">

			<form:form action="${busca}" method="POST">
				<div class="form-group">
					<label>CPF do cliente:</label> <input type='text' name='cpfDono'
						class="form-control" minlength="11" maxlength="11"
						required="required" /> <small id="cont"
						class="form-text text-muted">Utilize apenas numeros</small>
				</div>


				<div class="form-group">
					<label>&nbsp;</label> <input type="submit" value="Buscar"
						class="btn btn-primary btn">
				</div>
			</form:form>
		</c:if>


		<c:if test="${dono.cpf != null}">

			<div class="card" style="width: 18rem;">
				<div class="card-body">
					<h5 class="card-title">${dono.nome}</h5>
					<h6 class="card-subtitle mb-2 text-muted">${dono.cpf}</h6>
					${dono.endereco}<br> Tel.: ${dono.telefone}
				</div>
			</div>
			
				<br>
				<c:if test="${not empty animais}">
				<h6>Selecione um bicho de ${dono.nome}</h6>

				<form:form modelAttribute="animal" action="${seleciona}"
					method="post">
					<div class="form-group">
						<table class="table table-striped">
							<thead>
								<tr>
									<th scope="col"></th>
									<th scope="col">Nome</th>
									<th scope="col">Espécie</th>
									<th scope="col">Raça</th>
									<th scope="col">Idade</th>
								</tr>
							</thead>
							<c:forEach items="${animais}" var="animal" varStatus="status">
								<tr>
									<td><form:radiobutton path="id" value="${animal}" required="required" /></td>
									<td><c:out value="${animal.nome}" /></td>
									<td><c:out value="${animal.especie}" /></td>
									<td><c:out value="${animal.raca}" /></td>
									<td><c:out value="${animal.idade}" /></td>
								</tr>
							</c:forEach>
						</table>
					</div>
					<div class="form-group">
						<input type="submit" value="Confirmar" class="btn btn-success btn">
					</div>

				</form:form>
				<br>

						Ou
				</c:if>

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
</html>