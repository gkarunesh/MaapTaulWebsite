/**
 * Karunesh
 */
var app = angular.module('allOfficersApp', []).controller('allOfficersCtrl', ['$scope', '$http', '$location', '$filter', function allOfficersCtrl($scope, $http, $location, filter) {
	init();
	
	function init(){
		$scope.designation=[
	    	{
	    		"desig_code" : "CL",
	    		"desig_name" : "Controller",
	    		"Priority" : "1"
	        },
	        {
	        	"desig_code" : "AC",
	        	"desig_name" : "Assistant Controller",
	        	"Priority" : "4"
	        },
	        {
		        "desig_code" : "IN",
		        "desig_name" : "Inspector",
		        "Priority" : "6"
		    }
	]
		/************Headquarter officers*******************/
		$http.get('/lmd/staff/getAllOfficersHQR').then(function(response) {
			$scope.allOfficersHq = response.data.data;
			//console.log($scope.allOfficersHq);		
		});
		
		/************Division officers*******************/
		$http.get('/lmd/staff/getAllOfficersDIV').then(function(response) {
			$scope.allOfficersDiv = response.data.data;
		});
		
		/************District officers*******************/
		$http.get('/lmd/staff/getAllOfficersDIS').then(function(response) {
			$scope.allOfficersDis = response.data.data;
			//console.log($scope.allOfficers);		
		});
		/************Subdivision officers******************/
		$http.get('/lmd/staff/getAllOfficersSUB').then(function(response) {
			$scope.allOfficersSub = response.data.data;
			//console.log($scope.allOfficers);		
		});
}
	
}]);