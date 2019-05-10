<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html ng-app="consultarRegistrosControllerApp">
<head>
<meta charset="ISO-8859-1">
<title>Consultar Registros</title>
 

<link rel="stylesheet" href="../resources/css/style.css">
<script type="text/javascript" src="../resources/javascript/angular.min.js"></script>
<script type="text/javascript" src="../resources/javascript/consultarRegistrosController.js"></script>
<script type="text/javascript" src="../resources/javascript/angular-locale_pt-br.js"></script>
 
</head>
<body>

	<div class="container">
		<div id="contact" class="content" >
		
			<ul class="menu">
				<li><a href="/Prova">Inicio</a></li>
			  	<li><a href="/Prova/cliente/cadastrar.html">Cadastrar</a></li>
			  	<li><a href="/Prova/cliente/consultarRegistros.html">Consultar</a></li> 
			</ul>
			
			<fieldset>
				<table ng-controller="consultarRegistrosController"
					data-ng-init="init()">
					<thead>
						<tr>
							<th>Código</th>
							<th>Nome</th>
							<th>Renda</th>
							<th></th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="cliente in clientes">
		
							<td>{{ cliente.codigoCliente }}</td>
							<td>{{ cliente.nomeCliente }}</td>
							<td>{{ cliente.rendimentoMensal | currency }}</td>
		
							<td><a ng-href="simulador.html/{{cliente.codigoCliente}}">Simular Emprestimo</a></td>
							<td><a ng-href="editarRegistro.html/{{cliente.codigoCliente}}">Editar</a></td>
							<td><a href="#"
								ng-click="excluirRegistro(cliente.codigoCliente)">Excluir</a></td>
						</tr>
					</tbody>
				</table>
			</fieldset>
		</div>
		
	</div>
 
	
 
 
</body>
</html>