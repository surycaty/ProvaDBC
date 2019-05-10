var consultarRegistrosControllerApp = angular.module("consultarRegistrosControllerApp",[]);
 
consultarRegistrosControllerApp.controller("consultarRegistrosController",function($scope, $window, $http){
 
	 $scope.clientes = new Array();
 
	 function appendTransform(defaults, transform) {

		  // We can't guarantee that the default transformation is an array
		  defaults = angular.isArray(defaults) ? defaults : [defaults];

		  // Append the new transformation to the defaults
		  return defaults.concat(transform);
		}
 
	 $scope.init = function(){

		 $http.get("consultarTodos").then(function(response){
			 $scope.clientes = response.data;
		    }, function(response) {
		    	$window.alert(response.data);
		    })

	 }
  
	 $scope.excluirRegistro = function(codigo){
 
		 if($window.confirm("Deseja realmente excluir esse registro?")){
			 
			 $http.delete("excluirRegistro/" + codigo).then(function(response){
				 $scope.init();
			    }, function(response) {
			    	$window.alert(response.data);
			    });
 
		 }
 
	 }
 
});