var cursosModulo = angular.module('cursosModulo', []);

cursosModulo.controller("cursosController", function($scope){
	
	$scope.professores = [
		{codigo:1, nome: 'Neri', email:'neri@gmail.com', fone:'55 99999-9999'},
		{codigo:2, nome: 'Lisiane', email:'lisiane@gmail.com', fone:'55 11111-9999'},
		{codigo:3, nome: 'Gustavo', email:'gustavo@gmail.com', fone:'55 33333-9999'}
	];
	
	$scope.cursos = [
		{codigo:1, nome: 'Java', horarios:'Segundas e quartas, 9h', professor:{codigo:1, nome: 'Neri', email:'neri@gmail.com', fone:'55 99999-9999'}},
		{codigo:2, nome: 'PHP', horarios:'Terças, 16h', professor:{codigo:2, nome: 'Lisiane', email:'lisiane@gmail.com', fone:'55 11111-9999'}},
		{codigo:3, nome: 'Delphi', horarios:'Sexta, 18h', professor:{codigo:3, nome: 'Gustavo', email:'gustavo@gmail.com', fone:'55 33333-9999'}}
	];
	
	$scope.selecionacurso = function(cursoSelecionado){
		$scope.curso = cursoSelecionado;
	}
	
	$scope.limparCampos = function() {
		$scope.curso = null;
	}
	
    $scope.salvar = function(){
		$scope.cursos.push($scope.curso);
		$scope.limparCampos();
	}
	
	$scope.excluir = function(){
		$scope.cursos.splice($scope.cursos.indexOf($scope.curso),1);
		$scope.limparCampos();
	}
});