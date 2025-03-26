/**
 * Karunesh
 */
var app = angular.module('offenceApp', []).controller('offencesCtrl', ['$scope', '$http', '$location','$q', '$log', function offencesCtrl($scope, $http, $location, $q, $log) {
	init();
	
	$scope.offenses = [];
	
	function init(){
		
		$scope.pageNo = 0;
		getOffenseList();
	}
	/****************View Compounding Offense***********************/
	function getOffenseList() {
		$http.get("/lmd/offense/view-offense/" + $scope.pageNo)
			.then(function(response) {
				//console.log(response.data);
				if (response.data.numberOfElements > 0) {
					$scope.offenses = response.data.content;
					$scope.currentItems = response.data.pageable.offset;
					$scope.totalItems = response.data.totalElements;
					$scope.totalPages = response.data.totalPages;
					$scope.dataSize = response.data.size;
					//$scope.warnNoData = false;
				} else {
					$scope.offenses = [];
					//$scope.warnNoData = true;
				}
				//console.log($scope.vendor);
			});
	}
	
	

	//next page
	$scope.nextPage = function() {
		if ($scope.totalPages - 1 > $scope.pageNo) {
			$scope.pageNo++;
			getOffenseList();
		}
	}
	//previous page
	$scope.previousPage = function() {
		if ($scope.pageNo >= 1) {
			$scope.pageNo--;
			getOffenseList();
		}
	}

	$scope.pageExact = function(pageFound) {
		$scope.pageNo = pageFound;
		getOffenseList();
	}

}]);