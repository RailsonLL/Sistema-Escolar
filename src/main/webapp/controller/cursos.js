var cursosModulo = angular.module('cursosModulo', []);

cursosModulo.controller("cursosController", function($scope, $http){
	
	urlCurso = 'http://localhost:8080/sistema_escolar2/rest/cursos';
	urlProfessor = 'http://localhost:8080/sistema_escolar2/rest/professores';
		

	$scope.listarProfessores = function(){
		$http.get(urlProfessor).then(function(response){
			$scope.professores = response.data;
		})
		.catch(function(response) {
		  console.error('Gists error', response.status, response.data);
		})
		.finally(function() {
		  console.log("finally finished gists");
		});
	}	
	
	//recebe a lista de cursos do rest
	$scope.listarcursos = function(){
		$http.get(urlCurso).then(function(response){
			$scope.cursos = response.data;
		})
		.catch(function(response) {
		  console.error('Erro ao listar', response.status, response.data);
		})
		.finally(function() {
		  console.log("finally finished gists");
		});
	}
	
	//chamada da função
	$scope.listarcursos();
	$scope.listarProfessores();
	
	$scope.selecionaCurso = function(CursoSelecionado){
		$scope.curso = CursoSelecionado;
	}
	
	$scope.limparCampos = function() {
		$scope.curso = null;
	}
	
	$scope.salvar = function(){
		if ($scope.curso.codigo == null){
			$http.post(urlCurso, $scope.curso).then(function(response){
				//$scope.cursos.push($scope.curso);
				$scope.limparCampos();
				$scope.listarcursos();
			})
			.catch(function(response) {
			    console.error('Erro ao gravar', response.status, response.data);
			})
		} else {
			$http.put(urlCurso, $scope.curso).then(function(response){
				$scope.listarcursos();
				$scope.limparCampos();
			})
			.catch(function(response) {
			    console.error('Erro ao atualizar', response.status, response.data);
			})
		}
	}
	
	$scope.excluir = function(){
		if ($scope.curso.codigo == null){
			alert('Nunhem Curso selecionado!')
		} else {
			
			$http.delete(urlCurso +'/'+ $scope.curso.codigo).then(function(response){
				$scope.listarcursos();
				$scope.limparCampos();
			})
			.catch(function(response) {
			    console.error('Erro ao excluir', response.status, response.data);
			})
		}
	}
	
});