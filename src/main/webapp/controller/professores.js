var professoresModulo = angular.module('professoresModulo', []);

professoresModulo.controller("professoresController", function($scope, $http){
	
	urlProfessor = 'http://localhost:8080/sistema_escolar2/rest/professores';
		
	//recebe a lista de professores do rest
	$scope.listarProfessores = function(){
		$http.get(urlProfessor).success(function(professores){
			$scope.professores = professores;
		}).error (function(erro){
			alert(erro);
		});
	}
	
	$scope.listarProfessores2 = function(){
		$http.get(urlProfessor).then(function(response){
			$scope.professores = response.data;
		})
		.catch(function(response) {
		  console.error('Erro ao listar', response.status, response.data);
		  alert('Erro ao listar'+response.status+response.data);
		})
		.finally(function() {
		  console.log("finally finished gists");
		});
	}
	
	//chamada da função
	$scope.listarProfessores2();
	
	$scope.selecionaProfessor = function(professorSelecionado){
		$scope.professor = professorSelecionado;
	}
	
	$scope.limparCampos = function() {
		$scope.professor = null;
	}
	
	$scope.salvar = function(){
		if ($scope.professor.codigo == null){
			$http.post(urlProfessor, $scope.professor).then(function(response){
				//$scope.professores.push($scope.professor);
				$scope.limparCampos();
				$scope.listarProfessores2();
			})
			.catch(function(response) {
			    console.error('Erro ao gravar', response.status, response.data);
			    alert('Erro ao gravar'+response.status+response.data);
			})
		} else {
			$http.put(urlProfessor, $scope.professor).then(function(response){
				$scope.listarProfessores2();
				$scope.limparCampos();
			})
			.catch(function(response) {
			    console.error('Erro ao atualizar', response.status, response.data);
			    alert('Erro ao atualizar'+response.status+response.data);
			})
		}
	}
	
	$scope.excluir = function(){
		if ($scope.professor.codigo == null){
			alert('Nunhem professor selecionado!')
		} else {
			
			$http.delete(urlProfessor +'/'+ $scope.professor.codigo).then(function(response){
				$scope.listarProfessores2();
				$scope.limparCampos();
			})
			.catch(function(response) {
			    console.error('Erro ao excluir', response.status, response.data);
			    alert('Erro ao excluir'+response.status+response.data);
			})
		}
	}
	
});