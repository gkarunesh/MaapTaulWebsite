/**
 * Karunesh
 */
var app = angular.module('homeApp', []).controller('homeCtrl', ['$scope', '$http', '$location', function homeCtrl($scope, $http, $location) {
	init();
	
	//$scope.eventData = {};
	function init(){
		/*$http.get('/lmd/api/event').then(function(response) {
			//console.log(response.data);
		    $scope.eventData = response.data.data;
	    });
		$http.get('/lmd/api/newsClip').then(function(response) {
			//console.log(response.data);
		    $scope.news = response.data.data;
	    });
		$http.get('/lmd/api/sLetter').then(function(response) {
			//console.log(response.data);
		    $scope.letter = response.data.data;
	    });*/
		
		/****************GET DATA FOR MINISTER/OFFICER BLOCK***********************/
		/*$http.get('/lmd/attachment/getHighOfficials').then(function(response) {
			//console.log(response.data);
			$scope.officers = response.data.data;
			//console.log($scope.officers);
		});*/
	}
	
}]);