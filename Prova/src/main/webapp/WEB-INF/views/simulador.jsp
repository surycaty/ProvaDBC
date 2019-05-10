<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 
<!DOCTYPE>
<html ng-app="simuladorControllerApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Simulador</title>

<link rel="stylesheet" href="<spring:url value="/resources/css/style.css"/>" />
<script type="text/javascript" src="<spring:url value="/resources/javascript/angular.min.js"/>"></script>
<script type="text/javascript" src="<spring:url value="/resources/javascript/simuladorController.js"/>"></script>
<script type="text/javascript" src="<spring:url value="/resources/javascript/angular-locale_pt-br.js"/>"></script>
 
</head>
<body>

	<div class="container">

		<form id="contact" ng-controller="simuladorController">
		
			<ul class="menu">
				<li><a href="/Prova">Inicio</a></li>
			  	<li><a href="/Prova/cliente/cadastrar.html">Cadastrar</a></li>
			  	<li><a href="/Prova/cliente/consultarRegistros.html">Consultar</a></li>  
			</ul>
			
			<h3>Prova DBC</h3>
			<h4>Simulador de Empréstimo</h4>

			<fieldset>
				<label for="input-nomeCliente">Nome Cliente:</label> 
				<input type="text" id="input-nomeCliente" ng-model="nomeCliente"
					ng-init="nomeCliente='${cliente.nomeCliente}'" disabled="disabled"
					readonly="readonly" />
			</fieldset>

			<fieldset>
				<label for="input-rendimentoMensal">Renda Mensal:</label> 
				<input type="text" id="input-rendimentoMensal" 
					ng-model="rendimentoMensal" ng-init="rendimentoMensal='${cliente.rendimentoMensal}'"
					disabled="disabled" readonly="readonly" />
			</fieldset>

			<fieldset>
				<label for="input-risco">Risco:</label> 
				<input type="text" id="input-risco" ng-model="risco"
					ng-init="risco='${cliente.risco}'" disabled="disabled" readonly="readonly" />
			</fieldset>

			<fieldset>
				<label for="input-valor">Valor Empréstimo</label> 
				<input type="text" id="input-valor" ng-model="valorEmprestimo" />
			</fieldset>

			<fieldset>
				<label for="input-parcelas">N Parcelas</label>
				<input type="number" id="input-parcelas" ng-model="numeroParcela" numeric-only />
			</fieldset>

			<div ng-switch on="mostrarResultado">
				<div ng-switch-when="true">
					<fieldset>
						Valor Parcela: {{valorParcela | currency }}
					</fieldset>
					
					<fieldset>
						Total à Pagar: {{valorCalculado | currency}}
					</fieldset>
				</div>
			</div>

			<fieldset>
				<button name="submit" type="submit" id="contact-submit" 
					ng-click="calcular()"
					data-submit="...Enviando">Calcular Empréstimo</button>
			</fieldset>
			
			
		</form>
	</div>
 
 
</body>
</html>