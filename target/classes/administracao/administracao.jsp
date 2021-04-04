<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Administração - Home</title>
<link href='<spring:url value="/resources/css/bootstrap.css" />'
	rel="stylesheet" />
<script src='<spring:url value="/resources/js/jquery-3.5.1.min.js" />'></script>
<script src='<spring:url value="/resources/js/bootstrap.js" />'></script>
</head>
<body>
	<a href="/" class='btn btn-info btn-sm'>Home</a>
	<div class='container'>
		<div class="pb-2 mt-4 mb-2 border-bottom">
			<h1>Administração</h1>
		</div>
		<br>
		<div class="text-center">
			<div class="row">
				<div class="col">
					<div class="btn-group-lg btn-group-vertical" style="width: 90%;">
						<a href='/administracao/vet' class="btn btn-outline-primary">Veterinários</a>
						<a href='/administracao/cliente' class="btn btn-outline-secondary">Clientes/Animais</a>
					</div>
				</div>
				<div class="col">
					<div class="btn-group-lg btn-group-vertical" style="width: 90%;">
						<a href='/atendimento/vet'
							class="btn btn-outline-success btn-block">Registrar
							Atendimento</a>
						<button type="button" class="btn btn-outline-info"
							data-toggle="modal" data-target="#Modal">Informações</button>
					</div>
				</div>
				<div class="col">
					<div class="btn-group-lg btn-group-vertical" style="width: 90%;">
						<a href='/administracao/medicamentos'
							class="btn btn-outline-warning btn-block">Medicamentos</a> <a
							href='/administracao/exames'
							class="btn btn-outline-danger btn-block">Exames</a>
					</div>
				</div>
			</div>
		</div>
		<div class="modal fade" id="Modal" tabindex="-1"
				aria-labelledby="ModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="ModalLabel">Informações</h5>
						</div>
						<div class="modal-body">
							<br>
							<p>Aqui pode-se realizar consultas, registros e alterações no banco de 
							dados na parte dos clientes e seus animais, veterinários, medicamentos, 
							exames e atendimentos realizados por cada veterinário.</p>
							<p>
								-Registrar Atendimentos <br> 
								Sempre que uma consulta agendada for realizada o registro de atendimento 
								deve ser feito, deve-se preencher os procedimentos realizados e medicamentos 
								prescritos, tais como observações pertinentes.
							</p>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Fechar</button>
						</div>
					</div>
				</div>
			</div>
	</div>
</body>
</html>