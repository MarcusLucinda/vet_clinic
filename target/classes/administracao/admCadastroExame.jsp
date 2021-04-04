<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de exame</title>
<link href='<spring:url value="/resources/css/bootstrap.css" />'
	rel="stylesheet" />
<script src='<spring:url value="/resources/js/bootstrap.js" />'></script>
<spring:url value="/administracao/exames/salva" var="salva"></spring:url>
</head>
<body>
	<a href="/administracao" class='btn btn-info btn-sm'>Administração</a>
	<div class='container'>
		<div class="pb-2 mt-4 mb-2 border-bottom">
			<h1>Cadastro de Exame</h1>
		</div>
		<div class="pb-2 mt-4 mb-2 border-bottom">
			<form:form action="${salva}" modelAttribute="exame">

				<form:hidden path="id" />

				<div class="form-group">
					<label>Nome</label>
					<form:input path="nome" cssClass="form-control" required="required" />
				</div>

				<input type="submit" class="btn btn-primary" name="salva"
					value="Cadastrar" />
			</form:form>
		</div>
	</div>
</body>
</html>