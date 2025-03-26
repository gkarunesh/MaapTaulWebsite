/**
 * Karunesh
 */
var app = angular.module('grievanceApp', []).controller('grievanceCtrl', ['$scope', '$http', '$location','$q', '$log', function grievanceCtrl($scope, $http, $location, $q, $log) {
	init();
	
	$scope.totalPages = 0;
	$scope.totalItems = 0;
	$scope.currentItems = 0;
	$scope.grievances =[];
	$scope.contacts = [];
	$scope.natures = [];
	$scope.newAtr = {};
	$scope.officers = [];
	
	function init(){
		$scope.mobilePattern = '[6-9]{1}[0-9]{9}';
		$scope.namePattern = '[a-zA-Z ]{3,}';
		$scope.lodgeGrievance=false;
		$scope.otpVerification=false;	
		
		$scope.pageNo = 0;
		
		$http.get('/lmd/all/districts').then(function(response) {
			//console.log(response.data.data);
			$scope.districts = response.data.data;
		});
		/****************Nature of Complaint***********************/
		$http.get('/lmd/all/complaintNature').then(function(response) {
			//console.log(response.data.data);
			$scope.natures = response.data.data;
		});
		/****************Officers List***********************/
			$scope.loading = true;
			$http.get('/lmd/all/getAllOfficers').then(function(response) {
				//console.log(response.data.data);
				$scope.Allcontacts = response.data.data;
				$scope.contacts = $scope.Allcontacts.slice(4, 150);
				$scope.loading = false;
				$scope.contacts.forEach(function(item){
					//console.log(item);
					item.designation=item.designation.split(',')[0];
					item.location_name=(item.location_name)?item.location_name:'PATNA';
					item.email=(item.email)?item.email:'N/A';
				});			    
			   });
			
		/****************Complaint Count***********************/
		$http.get('/lmd/grievance/grievanceCount').then(function(response) {
			//console.log(response.data);
			$scope.count = response.data.data;
			//console.log($scope.count);
		});
		
		/****************View Ratings***********************/
		$http.get('/lmd/ratings/view-rating').then(function(response) {
			//console.log(response.data);
			$scope.ratings = response.data.data;
			//console.log($scope.count);
		});
		
		/****************GET DATA FOR OFFICER***********************/
		$http.get('/lmd/attachment/getHighOfficials').then(function(response) {
			//console.log(response.data);
			$scope.officers = response.data.data;
			//console.log($scope.count);
		});
		
		
		getGrievanceList()		
	}
	
	function getGrievanceList() {
		$http.get("/lmd/grievance/view-grievance/" + $scope.pageNo)
			.then(function(response) {
				//console.log(response.data);
				if (response.data.numberOfElements > 0) {
					$scope.grievances = response.data.content;
					$scope.currentItems = response.data.pageable.offset;
					$scope.totalItems = response.data.totalElements;
					$scope.totalPages = response.data.totalPages;
					$scope.dataSize = response.data.size;
					//$scope.warnNoData = false;
				} else {
					$scope.grievances = [];
					//$scope.warnNoData = true;
				}
				//console.log($scope.vendor);
			});
	}
	
	

	//next page
	$scope.nextPage = function() {
		if ($scope.totalPages - 1 > $scope.pageNo) {
			$scope.pageNo++;
			getGrievanceList();
		}
	}
	//previous page
	$scope.previousPage = function() {
		if ($scope.pageNo >= 1) {
			$scope.pageNo--;
			getGrievanceList();
		}
	}

	$scope.pageExact = function(pageFound) {
		$scope.pageNo = pageFound;
		getGrievanceList();
	}
	
	
	function sendOtp(mobile) {
		//console.log(mobile);
    	var sotp =(Math.floor(1000 + Math.random() * 9000));
    	$scope.params = {};
    	$scope.params.arg1 = mobile;
    	$scope.params.arg2 ="1307162245360432724";
    	$scope.params.arg3 = 'Dear consumer, '+sotp+'. is your OTP - Bihar Government.';
    	$scope.params.arg4 = sotp;
    	//console.log($scope.params.arg4);
    	var deferred = $q.defer();
    	   setTimeout(function() {
    		   $http.post('/lmd/dbtText', $scope.params).then(function(response) {
    			    //alert($scope.params.arg3);
    			    console.log($scope.params.arg3);
       			 	$scope.enterOtpShowHide=true;
    			  	$scope.otpVerification=true;
	        		$scope.params.arg5=response.data.statusCode;
	        		deferred.resolve($scope.params);
	        	}, function(response) {
	        		$log.info(response.data);
	        		deferred.reject(response.data);
				});
		  }, 1000); 
    	  return deferred.promise;
    	};
    	
    	
	//$scope.newAtr = {};
    $scope.generateOtp = function(){
    	sendOtp($scope.newAtr.mobile).then(function(data) {
			//$log.info(data);
    	}, function(reason) {
			$log.error(reason);
		});
    };
    
    $scope.verifyOtp = function(){
    	//alert(JSON.stringify($scope.newAtr));
    	if(($scope.newAtr.otp != '' && ($scope.params.arg4 == $scope.newAtr.otp ))){
    		$scope.lodgeGrievance=true; 
    		$('.mobile').prop('readonly', true);        		
    	}else alert("OTP didn't match");
    };
    
    $scope.updateGrievance = function(){
    	//console.log($scope.newAtr);
    	$http.post('/lmd/grievance/submitGrievances', $scope.newAtr).then(function(response) {
    		//console.log(response.data);
    		if(response.data.statusCode == 200 || response.data.statusCode == 202){
    			$scope.submitStatus = response.data.status;
    			setTimeout(function() {
    			    $('#statusDiv').fadeOut('fast');
    			}, 5000); 
    			
    		}
    		$scope.reset();   	    
    	}, function(response) {
			$log.error(response);
			/** ****Show Response Error Modal Dialog****** */
			$scope.reset();
		});       	
    };
    
    $scope.reset = function() {
		$scope.newAtr.name = '';
		$scope.newAtr.address = '';
		$scope.newAtr.mobile = '';
		$scope.newAtr.otp = '';
		$scope.newAtr.email = '';
		$scope.newAtr.query = '';
		$scope.newAtr.district = 'nonsense';
		$scope.lodgeGrievance=false;
		$scope.otpVerification=false;
		$scope.newAtr.otp = '';
		$scope.newAtr.ackNo = '';
		$('.mobile').prop('readonly', false);    		
	};
	
	$scope.getDistrictNameById=function(districtId){
		return $scope.districts.filter(function(item){ return (item.value===districtId);})[0].name;
	}

}]);