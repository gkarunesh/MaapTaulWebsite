/**
 * Karunesh
 */
var app = angular.module('attachmentApp', []).controller('attachmentCtrl', ['$scope', '$http', '$location', function attachmentCtrl($scope, $http, $location) {
	init();
	
	$scope.attachments = [];
	function init(){
		$scope.urlData = $location.absUrl().split("/");
		$scope.kindof=$scope.urlData[$scope.urlData.length-1];
		//console.log("url :"+$scope.kindof);
		$http.get('/lmd/api/'+$scope.kindof).then(function(response) {
			//console.log(response.data);
		    $scope.attachments = response.data.data;
		    angular.forEach($scope.attachments, function(value, key) {
		    	  //console.log(key + ': ' + value.entryDate);
		    	  value.entryDate=new Date(value.entryDate);
		    	  //console.log(key + ': ' + value.entryDate);
		    	});
		    //console.log($scope.attachments);
	    });
	}
	
}]);