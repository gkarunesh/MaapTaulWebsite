/**
 * Karunesh
 */
var app = angular.module('AttachmentEntryApp', []).controller('AttachmentEntryCtrl', ['$scope', '$http', function AttachmentEntryCtrl($scope, $http) {
	init();
	
	
	function init(){
		$scope.newAtr={};
		$scope.regd={};
		$scope.officials={};
		$scope.officials.designation = {};
		$scope.sessionLoginData = sessionStorage.getItem('sessionData');
		if(!$scope.sessionLoginData){
			window.location.href = '/lmd/login';
		}
		$scope.loginData = JSON.parse($scope.sessionLoginData);
		//console.log($scope.loginData[0].authority);
		
		$scope.authority = $scope.loginData[0].authority;
		//console.log($scope.authority);
		if($scope.authority == 'ADMIN'){
			getNewDataForVerify();
			getUserList();
			/***********Ratings For Verify******************/
			$http.get('/lmd/rating/ratingsForVerify').then(function(response) {
				$scope.ratingsVerify = response.data.data;
				//console.log($scope.ratingsVerify);
			});
		}
		$scope.getselectval = function (val) {
			$scope.selectedvalues = val;
		}
				
	}	
	$scope.designations = [
		{ post: "Hon'ble Chief Minister, Bihar", value: 1 },
		{ post: "Hon'ble Agriculture Minister, Bihar", value: 2 },
		{ post: "Secretary", value: 3 },
		{ post: "Director", value: 4 }		
	];

			/*******************User Registration ***********************/
			$scope.submit_UserRegisterForm = function(){
				//console.log($scope.regd);
				$http.post('/lmd/register/user-register/', $scope.regd).then(function(response) {
					/******Show Response Success Modal Dialog*******/
					if (response.data.statusCode == 200) {
						$scope.successMsg = response.data.remarks;
						setTimeout(function(){ 
							$('.hidden').show();
						}, 1000); 
						window.setTimeout(function() {
							window.location.replace("/lmd/manageAttachment");
						}, 5000);						
					} else {
						console.log(response.data);
					}
					$scope.alertMessage = '' + response.data.status;
					//$window.scrollTo(0, 0);
				}, function(response) {
					console.log(response);
					$scope.alertMessage = '' + response.data.status;
				});						
			}
			/*******************Attachment Submit ***********************/
		   $scope.submit_attachmentForm = function(){
				//console.log($scope.newAtr);
				var formData = new FormData();
				//console.log($scope.newAtr);
				formData.append('date',JSON.stringify($scope.newAtr.entryDate));
				$scope.newAtr.entryDate=undefined;
				formData.append('str', JSON.stringify($scope.newAtr));
				formData.append('file', $scope.newAtr.attachment);
				//console.log("Date Entry"+$scope.newAtr.entryDate);
				var config = {
					transformRequest: angular.identity,
					headers: {
						"Content-Type": undefined
				}
			};
				//console.log("Form Data"+formData.newAtr.entryDate);
			$http.post('/lmd/attachment/uploadAttachments', formData, config).then(function(response) {
				/******Show Response Success Modal Dialog*******/
				//console.log(response);
				if (response.data.statusCode == 200) {
					$scope.successShow = true;
					$scope.successMsg = response.data.remarks;
					setTimeout(function(){ 
						$('.hidden').show();
					}, 1000);
					window.setTimeout(function() {
						window.location.replace("/lmd/manageAttachment");
					}, 5000);
					$scope.newAtr.kindOf='';
					$scope.newAtr.groupOfKindOf='';
					$scope.newAtr.description='';
				} else {
					$scope.disabled = false;
				}
			}, function(response) {
				//console.log(response);
				$scope.disabled = false;
				$scope.alertMessage = '' + response.data.status;
			});		
		}
	
		/*******************View Attachment ***********************/	
		function getNewDataForVerify() {
			$http.get("/lmd/attachment/view-uploads").then(function(response) {
				//console.log(response.data);
				$scope.uploads = response.data.data;
			});
		}
		
		/*******************View Active Users ***********************/	
		function getUserList() {
			$http.get("/lmd/register/all-active-user").then(function(response) {
				$scope.users = response.data.data;
				//console.log($scope.users);
			});
		}
		
		/*******************Deactivate User ***********************/
		$scope.deactivateUser = function(userid){
			$scope.userId = userid;
			let text;
			  if (confirm("Want to delete!") == true) {
				  $http.post('/lmd/register/change-user-status/'+$scope.userId).then(function(response) {
		        		//console.log(response.data.data);
		        		if(response.data.statusCode == 200){
		        			console.log(response.data.remarks);
		        			//init();
		        			$scope.submitStatus = response.data.remarks;
		        			setTimeout(function() {
		        			    $('#statusDiv').fadeOut('fast');
		        			    window.location.href = '../lmd/manageAttachment';
		        			}, 5000); 
		        		}   		
		        	}, function(response) {
		    			$scope.NotSubmitStatus = response.data.status;
		    		});  
			  } else {
			    text = "Canceled!";
			  }  	
        }
		
		/*******************Verify Attachment ***********************/
		$scope.verifyUploads = function(attachmentNo){
			$scope.attachmentId = attachmentNo;
        	$http.post('/lmd/attachment/change-attachment-status/' +$scope.attachmentId +"/"+'V'+"/"+"ADMIN").then(function(response) {
        		if(response.data.statusCode == 200){
        			//console.log(response.data.status);
        			init();
        			setTimeout(function() {
        			    $('#statusDiv').fadeOut('fast');
        			}, 10000); 
        			//$scope.reset();
        		}   		
        	}, function(response) {
    			$scope.NotSubmitStatus = response.data.status;
    		});  
        }
		
		/*******************Deactivate Attachment ***********************/
		$scope.deleteUploads = function(attachmentNo){
			$scope.attachmentId = attachmentNo;
			let text;
			  if (confirm("Want to delete!") == true) {
				  $http.post('/lmd/attachment/change-attachment-status/' +$scope.attachmentId +"/"+'D'+"/"+"ADMIN").then(function(response) {
		        		//console.log(response.data.data);
		        		if(response.data.statusCode == 200){
		        			//console.log(response.data.status);
		        			init();
		        			$scope.submitStatus = response.data.status;
		        			setTimeout(function() {
		        			    $('#statusDiv').fadeOut('fast');
		        			}, 10000); 
		        			//$scope.reset();
		        		}   		
		        	}, function(response) {
		    			$scope.NotSubmitStatus = response.data.status;
		    		});  
			  } else {
			    text = "Canceled!";
			  }
        	}
		/***********Logout********************/
		$scope.logout = function(){
			sessionStorage.clear();
			sessionStorage.clear('token');
		    window.location.href='/lmd/login';
		    return true;	
		}
		
		/***********Logout********************/
		$scope.submit_Officials = function(officialPic){
			$scope.filename=officialPic;
			var formData = new FormData();
			$scope.officials.designation = $scope.officials.priority == 1 ? "Hon'ble Chief Minister, Bihar" : $scope.officials.priority == 2 ? "Hon'ble Agriculture Minister, Bihar" : $scope.officials.priority == 3 ? "Secretary" : "Director";
			formData.append('str', JSON.stringify($scope.officials));
			formData.append('file', $scope.filename);
			var config = {
					transformRequest: angular.identity,
					headers: {
						"Content-Type": undefined
					}
				};
			$http.post('/lmd/attachment/uploadHigherOfficials', formData, config).then(function(response) {
				//console.log(response);
				if (response.data.statusCode == 200) {
					$scope.successMsg = response.data.remarks;
					setTimeout(function(){ 
						$('.hidden').show();
					}, 1000);
					setTimeout(function(){ 
						$('.hidden').hide();
					}, 9000);
					$scope.officials.name='';
					$scope.officials.designation='';
					$scope.fileName='';
				} else {
					$scope.disabled = false;
				}
			}, function(response) {
				console.log(response.data);
			});	
		}
		
		
		/***********Ratings Management by Admin********************/
		$scope.manageRating = function(id, status){
			$scope.id = id;
			$scope.status = status;
			let text;
			if (confirm("Want to verify/delete!") == true) {
			$http.post('/lmd/rating/change-rating-status/' +$scope.id+ "/" +$scope.status).then(function(response) {
        		if(response.data.statusCode == 200){
        			//console.log(response.data.status);
        			angular.forEach($scope.ratingsVerify, function (item, key) { 
        				if(item.rateid===$scope.id){
        					item.status=$scope.status;
        				}
        				setTimeout(function(){ 
    						$('.hidden').show();
    					});
    					setTimeout(function(){ 
    						$('.hidden').hide();
    					}, 3000);
                    }); 
        		} 
        		else{
        			console.log(response);
        			alert("Something Went Wrong!")
        		}
        	}, function(response) {
    			console.log(response.data);
    		}); 
			}
			else {
			    text = "Canceled!";
			 }
		}
		
		
}]).directive('fileModel', ['$parse', function($parse) {
	return {
		restrict: 'A',
		link: function(scope, element, attrs) {
			var model = $parse(attrs.fileModel);
			var modelSetter = model.assign;
			element.bind('change', function() {
				scope.$apply(function() {
					modelSetter(scope, element[0].files[0]);
				});
			});
		}
	};
}]);