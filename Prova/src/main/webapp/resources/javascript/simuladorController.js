var simuladorControllerApp = angular.module("simuladorControllerApp",[]);
 
simuladorControllerApp.controller("simuladorController",function($scope, $window, $http){
 
	//Cliente
	$scope.codigoCliente = null;
	$scope.nomeCliente = null;
	$scope.rendimentoMensal = null;
	$scope.risco = null;
	$scope.endereco = null;
	$scope.tipoCliente = null;
	$scope.valorPatrimonio = null;
	$scope.valorDivida = null;
	$scope.empregado = null;
	
	$scope.valorEmprestimo = null;
	$scope.numeroParcela = null;
	$scope.riscoCliente = null;
	$scope.valorCalculado = null;
	$scope.taxaJuros = null;
	
	$scope.mostrarResultado = false;
 
	$scope.calcular = function(){
		
		$scope.mostrarResultado = false;

		var cliente =  new Object();
		cliente.codigoCliente  = $scope.codigoCliente;
		cliente.nomeCliente  = $scope.nomeCliente;
		cliente.rendimentoMensal  = $scope.rendimentoMensal;
		cliente.risco  = $scope.risco;
		cliente.endereco  = $scope.endereco;
		cliente.tipoCliente  = $scope.tipoCliente;
		cliente.valorPatrimonio  = $scope.valorPatrimonio;
		cliente.valorDivida  = $scope.valorDivida;
		cliente.empregado  = $scope.empregado;	
		
		var emprestimo = new Object();
		emprestimo.valorEmprestimo = $scope.valorEmprestimo;
		emprestimo.numeroParcela = $scope.numeroParcela;
		emprestimo.riscoCliente = cliente.risco;

		$http.post("../calcular", emprestimo).then(function(response){
			
				$scope.valorEmprestimo = response.data.valorEmprestimo;
				$scope.numeroParcela = response.data.numeroParcela;
				$scope.riscoCliente = response.data.riscoCliente;
				$scope.valorCalculado = response.data.valorCalculado;
				$scope.valorParcela = response.data.valorParcela;
				$scope.taxaJuros = response.data.taxaJuros;
				
				$scope.mostrarResultado = true;

		      
	    }, function(response) {
	    	$window.alert(response.data);
	    });
 
	};

});