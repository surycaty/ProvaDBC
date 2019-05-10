<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 
<!DOCTYPE>
<html ng-app="editarRegistroControllerApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Registro</title>
 
<style type="text/css">
 
	label{
	    display: inline-block;
	    width: 90px;
	}
 
</style>
<link rel="stylesheet" href="<spring:url value="/resources/css/style.css"/>" />
<script type="text/javascript" src="<spring:url value="/resources/javascript/angular.min.js"/>"></script>
<script type="text/javascript" src="<spring:url value="/resources/javascript/editarRegistroController.js"/>"></script>
 
</head>
<body>

	<div class="container">

		<form id="contact" ng-controller="editarRegistroController">
		
			<ul class="menu">
				<li><a href="/Prova">Inicio</a></li>
			  	<li><a href="/Prova/cliente/cadastrar.html">Cadastrar</a></li>
			  	<li><a href="/Prova/cliente/consultarRegistros.html">Consultar</a></li>  
			</ul>
			
			<h3>Prova DBC</h3>
			<h4>Editar Cadastro de Cliente</h4>
			
			<fieldset>
				<input type="text" id="input-codigoCliente" ng-model="codigoCliente" ng-init="codigoCliente='${cliente.codigoCliente}'" />
			</fieldset>
			
			<fieldset>
				<input type="text" id="input-nomeCliente" ng-model="nomeCliente" 
				placeholder="Nome Cliente" tabindex="1" required autofocus  ng-init="nomeCliente='${cliente.nomeCliente}'" />
			</fieldset>
			
			<fieldset>
				<input ng-change="alterarCampo()" type="text" id="input-rendimentoMensal" ng-model="rendimentoMensal" 
				placeholder="Renda R$" tabindex="2" ng-init="rendimentoMensal='${cliente.rendimentoMensal}'" />
			</fieldset>
			
			<fieldset>
				<input type="text" id="input-risco" ng-model="risco" 
				placeholder="Risco" tabindex="3" readonly="readonly" ng-init="risco='${cliente.risco}'" />
			</fieldset>
			
			<fieldset>
				<input type="text" id="input-endereco" ng-model="endereco" 
				placeholder="Endere�o" tabindex="4" ng-init="endereco='${cliente.endereco}'" />
			</fieldset>
			
			<fieldset>
				<input id="input-tipoEspecial" ng-change="escolherTipoCliente()" type="radio" name="tipoCliente" value="E" ng-model="tipoCliente" ng-init="tipoCliente='${cliente.tipoCliente}'" />
				<label for="input-tipoEspecial">Especial</label>
				
				<input id="input-tipoPotencial" ng-change="escolherTipoCliente()" type="radio" name="tipoCliente" value="P" ng-model="tipoCliente" ng-init="tipoCliente='${cliente.tipoCliente}'" />
				<label for="input-tipoPotencial">Potencial</label>
				
				<input id="input-tipoComum" ng-change="escolherTipoCliente()" type="radio" name="tipoCliente" value="C" ng-model="tipoCliente" ng-init="tipoCliente='${cliente.tipoCliente}'" />
				<label for="input-tipoComum">Comum</label>
			</fieldset>
			
			<fieldset>
				<div ng-switch on="mostrarTipoCliente"  ng-init="mostrarTipoCliente='${cliente.tipoCliente}'">
					<div ng-switch-when="E">
						<fieldset>
							<input type="text" id="input-valorPatrimonio" name="valorPatrimonio" 
									ng-model="valorPatrimonio" ng-init="valorPatrimonio='${cliente.valorPatrimonio}'" 
														placeholder="Valor Patrimonio" tabindex="6" />
						</fieldset>
					</div>
					<div ng-switch-when="P">
						<fieldset>
							<input type="text" id="input-valorDivida" ng-model="valorDivida" 
									 ng-init="valorDivida='${cliente.valorDivida}'" placeholder="Valor D�vida" tabindex="6" />
						</fieldset>
					</div>
					<div ng-switch-when="C">
						<fieldset>
							<input type="checkbox" id="input-empregado" 
								ng-init="empregado='${cliente.empregado}'" ng-model="empregado" tabindex="6" />
							<label for="input-empregado">Est� Empregado</label>
						</fieldset>
					</div>
				</div>
			</fieldset>

			<fieldset>
				<button name="submit" type="submit" id="contact-submit" 
					ng-click="alterarCliente()"
					data-submit="...Enviando">Salvar</button>
			</fieldset>
			
			
		</form>
	</div>
 
 
</body>
</html>