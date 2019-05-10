var editarRegistroControllerApp = angular.module("editarRegistroControllerApp",[]);
 
editarRegistroControllerApp.controller("editarRegistroController",function($scope, $window, $http){
 
	$scope.codigoCliente = null;
	$scope.nomeCliente = null;
	$scope.rendimentoMensal = null;
	$scope.risco = null;
	$scope.endereco = null;
	$scope.tipoCliente = null;
	$scope.valorPatrimonio = null;
	$scope.valorDivida = null;
	$scope.empregado = null;
 
	$scope.alterarCampo = function() {
		
		if ($scope.rendimentoMensal != null && $scope.rendimentoMensal != undefined) {
			if($scope.rendimentoMensal <= 2000){
				$scope.risco = "C";
			} else if ($scope.rendimentoMensal <= 8000) {
				$scope.risco = "B";
			} else {
				$scope.risco = "A";
			}
			
		}
	};
 
	$scope.alterarCliente = function() {

		var cliente =  new Object();
		cliente.codigoCliente = $scope.codigoCliente;
		cliente.nomeCliente = $scope.nomeCliente;
		cliente.rendimentoMensal = $scope.rendimentoMensal;
		cliente.risco = $scope.risco;
		cliente.endereco = $scope.endereco;
		cliente.tipoCliente = $scope.tipoCliente;
		cliente.valorPatrimonio = $scope.valorPatrimonio;
		cliente.valorDivida = $scope.valorDivida;
		cliente.empregado = $scope.empregado;
		
		console.log(cliente);

		var response = $http.post("../alterar", cliente);
		
		response.then(function(response){

			 if(response.data.codigo == 1){

				 $window.alert(response.data.mensagem);

				 window.location.href = "../consultarRegistros.html";
			 }
			 else{

				 $window.alert(response.data.mensagem);
	 
			 }
		      
	    }, function(response) {
	    	$window.alert(response.data);
	    });
 
	};
	
	$scope.escolherTipoCliente = function(){
		$scope.mostrarTipoCliente = $scope.tipoCliente;
	};
	
 
});