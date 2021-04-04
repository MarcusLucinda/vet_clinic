<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de veterinario</title>
<link href='<spring:url value="/resources/css/bootstrap.css" />'
	rel="stylesheet" />
<script src='<spring:url value="/resources/js/bootstrap.js" />'></script>
<spring:url value="/administracao/vet/salva" var="salva"></spring:url>
</head>
<body>
<a href="/administracao" class='btn btn-info btn-sm'>Administração</a>
	<div class='container'>
		<div class="pb-2 mt-4 mb-2 border-bottom">
			<h1>Cadastro de Veterinario</h1>
		</div>
		<div class="pb-2 mt-4 mb-2 border-bottom">
			<form:form action="${salva}" modelAttribute="veterinario">

				<form:hidden path="id" />

				<div class="form-group">
					<label>Nome completo:</label>
					<form:input path="nome" cssClass="form-control" type="text"
						required="required" />
				</div>

				<div class="form-group">
					<label>CRMV:</label>
					<form:input path="crmv" cssClass="form-control" required="required" />
				</div>


				<div class="form-group">
					<label>Endereço:</label>
					<form:input path="endereco" cssClass="form-control"
						required="required" />
				</div>

				<div class="form-group">
					<label>Telefone:</label>
					<form:input path="telefone" cssClass="form-control" type="number"
						required="required" />
				</div>

				<div class="form-group">
					<label>Especialidade:</label>
					<form:select path="especialidade"
						cssClass="btn btn-outline-secondary dropdown-toggle form-control">
					<<form:option value="mamifero" label="Mamífero" />
						<form:option value="ave" label="Ave" />
						<form:option value="reptil" label="Réptil" />
						<form:option value="anfibio" label="Anfíbio" />
						<form:option value="peixe" label="Peixe" />
						<form:option value="inseto" label="Inseto" />
					</form:select>
				</div>

				<input type="submit" class="btn btn-primary" name="salva"
					value="Cadastrar" />
			</form:form>
		</div>
	</div>
</body>
</html>