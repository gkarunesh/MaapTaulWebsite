/**
 * Karunesh
 */
var app = angular.module('loginApp', ['master']).controller('loginCtrl', ['$scope', '$http', '$location', '$window', '$q', 'authGuardService', function loginCtrl($scope, $http, $location, $window, authGuardService, $q) {
	init();
    function init(){} 
    	
	    /*send Otp*/	        
	    function sendOtp(mobile) {
	    	//alert(mobile);
	    	var otp =(Math.floor(1000 + Math.random() * 9000));
	    	$scope.params = {};
	    	$scope.params.arg1 = mobile;
	    	$scope.params.arg2 ="1307162245360432724";
	    	$scope.params.arg3 = 'Dear consumer, '+otp+'. is your OTP - Bihar Government.';
	    	$scope.params.arg4 = otp;
	    	console.log($scope.params.arg3);
	    	  setTimeout(function() {
	    			$http.post('/lmd/dbtText', $scope.params).then(function(response) {
	    			  	$scope.enterOtpShowHide=true;
		        		$scope.params.arg5=response.data.statusCode;
		        	}, function(response) {
		        		console.log(response.data);
		        	});
			  }, 1000);
	    	  return $scope.params;
	    	};
    
	        $scope.submitLogin = function(){
	        //console.log($scope.loginData);
	    	$http.post("/lmd/generate-token", $scope.loginData).then(function(response) {   
	    		//console.log($scope.loginData);
	    		if(response.data.statusCode == 200){
	    			sessionStorage.setItem('sessionData', JSON.stringify(response.data.data));
	    			sessionStorage.setItem('token', response.data.remarks);
	    			if(response.data.remarks){
	    				window.location.href = '/lmd/manageAttachment';
	    			}
	    			else{
	    				alert("Maybe Username or password not match")
	    				window.location.href = '/lmd/login';
	    			}
	    		}
				else{
					alert("Username or password mismatch");
					window.location.href = '/lmd/login';
					return;
				}
	      		
	    	}, function(response) {
	    		console.log(response);
	    	});
		}   
	    
	    /***************Send OTP Function**********************/
	    $scope.openOtpBox=true; 
	    $scope.sendOtp=false;
        $scope.getOTPForUser = function(){
            //console.log($scope.userMobile);
        	$http.get("/lmd/register/getOTPForUser/"+$scope.userMobile).then(function(response) { 
        		//console.log(response.data.data);
        		if(response.data.statusCode == 200){
        			$scope.userId=response.data.data.id;
            		$scope.openOtpBox=false;
        			$scope.sendOtp=true;
        			$scope.responseMsg='';
        			sendOtp($scope.userMobile);
        		}
    			else{
    				$scope.responseMsg=response.data.remarks;
				}          		
        	}, function(response) {
        		console.log(response);
        	});
    	} 
        
        /***************OTP Mathing Function*******************/
        $scope.changePassword=true;
        $scope.otpMatch=false;
        $scope.sendOTPForUserDetail = function(inputOtp){
        	if($scope.params.arg4 == $scope.inputOtp){
        		$scope.changePassword=false;
        		$scope.otpMatch=true;
        	}
        	else{
        		$scope.otpMsg = "OTP Not Match"
        	}
    	} 
        
        /****************Password Change Function*****************/
        $scope.passwordChange = function(){
        	if($scope.user.password == $scope.user.reTypePassword){
        		$scope.user.id=$scope.userId;
        		//console.log($scope.user);
        		$http.post("/lmd/register/updatePassword", $scope.user).then(function(response) { 
        			if(response.data.statusCode == 200){
            			$scope.pwdChangedMsg=response.data.remarks;
            			alert($scope.pwdChangedMsg);
            		}
        			else{
        				console.log("Something Wrong");
    				}          		
            	}, function(response) {
            		console.log(response);
            	});
        	}
        	else{
        		$scope.passwordNotMatcing="Passwords are not matching";	
        	}
    	} 
    	
}]);