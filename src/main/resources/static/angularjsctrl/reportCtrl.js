/**
 * Karunesh
 */
var app = angular.module('rtpsApp', []).controller('rtpsCtrl', ['$scope', '$http', '$location','$q', '$log', function rtpsCtrl($scope, $http, $location, $q, $log) {
	init();
	
    function init(){
    	getRtpsReport();
    }; 

	
    //constantService.baseUrl'/rtpsServices/rtpsReportForMaaptaul'
    $scope.loading = true;
	function getRtpsReport(){
    	$http.get("/lmd/rtps/getRtpsRecord").then(function(response) {         	
    		  $scope.loading = false;
    		if(response.data.statusCode == 200){
				$scope.eventData=response.data.data;
				//$scope.loading = true;
    			$scope.eventData = response.data.data;
        	}
			else{
				alert(response.data.remarks);
				return;
			}
            	
    		
    	}, function(response) {
    		//console.log("Error")
    		console.log(response);
    	});
	}   

}]);