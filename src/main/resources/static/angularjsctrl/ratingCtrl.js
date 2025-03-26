/**
 * Karunesh
 */
var app = angular.module('ratingApp', []).controller('ratingCtrl', ['$scope', '$http', '$location','$q', '$log', function ratingCtrl($scope, $http, $location, $q, $log) {
	init();
	
	
	
	function init(){
		
		/****************View Ratings***********************/
		$http.get('/lmd/rating/view-rating').then(function(response) {
			console.log(response.data);
			$scope.ratings = response.data.data;
			//console.log($scope.count);
		});
					
	}
	
	$scope.namePattern = '[a-zA-Z ]{3,}';
	$scope.mobilePattern = '[6-9]{1}[0-9]{9}';
	$scope.emailPattern = '^[A-Za-z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$';
	$scope.hideContect= false;
	$scope.newAtr = {};
        $scope.rateUs = function(){
        	//console.log($scope.newAtr);
        	$http.post('/lmd/rating/submitRating', $scope.newAtr).then(function(response) {
        		if(response.data.statusCode == 202 || response.data.statusCode == 202){
        			//console.log(response.data.status);
        			$scope.submitStatus = response.data.status;
        			setTimeout(function() {
        			    $('#statusDiv').fadeOut('fast');
        			}, 10000); 
        			$scope.reset();
        		}       		
        	}, function(response) {
    			$log.error(response);
    			$scope.NotSubmitStatus = response.data.status;
    			$scope.reset();
    		});  
        };
        
        $scope.reset = function() {
			$scope.newAtr.rate = false;
			$scope.newAtr.rateOn = false;
			$scope.newAtr.rateOnDesign='0';
			$scope.newAtr.rateOnFriendly='0';
			$scope.newAtr.rateOnPerformance='0';
			$scope.newAtr.rateOnContent='0';
			$scope.newAtr.rateOnATR='0';
			$scope.newAtr.overallRating='0';
			$scope.newAtr.name = '';
			$scope.newAtr.mobile = '';
			$scope.newAtr.email = '';
			$scope.newAtr.remarks = '';	
			$scope.hideContect= false;
		}
        
        $scope.displayContact = function() {
			$scope.hideContect= true;
		}

}]);