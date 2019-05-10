var cadastrarControllerApp = angular.module("cadastrarControllerApp",[]);
 
cadastrarControllerApp.controller("cadastrarController",function($scope, $window, $http){

	$scope.nomeCliente = null;
	$scope.rendimentoMensal = null;
	$scope.risco = null;
	$scope.endereco = null;
	$scope.tipoCliente = null;
	$scope.valorPatrimonio = null;
	$scope.valorDivida = null;
	$scope.empregado = null;
	
	$scope.mostrarTipoCliente = "";
 
	$scope.salvarCliente = function(){

		var cliente =  new Object();
		cliente.nomeCliente = $scope.nomeCliente;
		cliente.rendimentoMensal = $scope.rendimentoMensal;
		cliente.risco = $scope.risco;
		cliente.endereco = $scope.endereco;
		cliente.tipoCliente = $scope.tipoCliente;
		cliente.valorPatrimonio = $scope.valorPatrimonio;
		cliente.valorDivida = $scope.valorDivida;
		cliente.empregado = $scope.empregado;
		
		console.log(cliente);

		$http.post("salvar", cliente).then(function(response){

			 if(response.data.codigo == 1){

				 $window.alert(response.data.mensagem);

				 $scope.nomeCliente = null;
				 $scope.rendimentoMensal = null;
				 $scope.risco = null;
				 $scope.endereco = null;
				 $scope.tipoCliente = null;
				 $scope.valorPatrimonio = null;
				 $scope.valorDivida = null;
				 $scope.empregado = null;
				 
			 }
			 else{

				 $window.alert(response.data.mensagem);
	 
			 }
		      
	    }, function(response) {
	    	$window.alert(response.data);
	    });	

	};
	
	$scope.alterarCampo = function(){
		
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
	
	$scope.escolherTipoCliente = function(){
		$scope.mostrarTipoCliente = $scope.tipoCliente;
	};
 
});