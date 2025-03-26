/**
 * Karunesh
 */
var app = angular.module('serviceProviderApp', []).controller('serviceProviderCtrl', ['$scope', '$http', '$location','$q', '$log', function serviceProviderCtrl($scope, $http, $location, $q, $log) {
	init();
	
    function init(){
    	getDistrictList();
    }
    
  //Find Distict Id
    function getDistrictList() {
		$http.get("/lmd/all/districts")
			.then(function(response) {
				//console.log(response.data);
				if (response.data.statusCode = 200) {
					$scope.districts = response.data.data;
					 //console.log($scope.districts);
				} else {
					console.log(response.data)
				}
			});
	}
     
	//Find Dealers by District 
     //$scope.selector=false;
	 $scope.getDealersByDistrict=function(servType,delDistrict){
		 if(!servType){
			alert("Plese select service provider type");
			return false;
		 }
		 else{
		 $scope.type=servType
	 	 $scope.delDistrict = delDistrict;
		 $scope.status="CRT";
		 
		 //console.log($scope.type);
		 //console.log($scope.delDistrict);
		 //console.log($scope.status);
		 
		 $http.get('/lmd/authenticate/getServiceProvidersList/'+$scope.type+"/"+$scope.delDistrict+"/"+$scope.status).then(function(response) {
	 		if (response.data.statusCode == 200) {
	 			//console.log(response.data);
	 			$scope.loading = false;
	 			if(response.data.data.length>0){
	 			$scope.serviceProviders = response.data.data;
	 			$scope.getSubDivision($scope.delDistrict);
	 			$scope.result = '';
	 			}
	 			else{
	 				//$scope.selector=true;
	 				$scope.serviceProviders="";
	 				$scope.result = "No Data Found!";
	 			}
			} else {
				console.log(response.data);
			}
		 }, function(response) {
			console.log(response);
		 });		 	
		}
	 }
	 
	//Find SubDivision
	    
	    $scope.getSubDivision=function(delDistrict){
	    	//console.log(districtId);
		 	$scope.districtId = delDistrict;
		 	$http.get("/lmd/all/subdivision/"+$scope.districtId).then(function(response) {
		 		if (response.data.statusCode == 200) {
		 			$scope.subDivision=[];
					$scope.subDivision = response.data.data;
					//console.log(response.data.data);
				} else {
					console.log(response.data)
					}
		 		})	
			}
	//Find Dealers by SubDivision 
	 $scope.selector=false;   
	 $scope.getDealerBySubDivision=function(servType,dSubDivision){
		 $scope.type = servType; 
		 $scope.delSubDiv = dSubDivision;
		 $scope.status="CRT";
		 
		 $http.get('/lmd/authenticate/getServiceProvidersBySubdivision/'+$scope.type+"/"+$scope.delSubDiv+"/"+$scope.status).then(function(response) {
			 	if (response.data.statusCode == 200) {
		 			//console.log(response.data);
		 			$scope.loading = false;
		 			if(response.data.data.length>0){
		 			$scope.serviceProviders='';
		 			$scope.result = "";
		 			$scope.serviceProviderBySub = response.data.data;
		 			$scope.serviceProviders = $scope.serviceProviderBySub;
		 			//console.log($scope.serviceProviderBySub);
		 			}
		 			else{
		 				$scope.serviceProviders='';
		 				$scope.selector=true;
		 				$scope.result = "No Data Found!";
		 			}
				} else {
					console.log(response.data);
				}
			 }, function(response) {
				console.log(response);
			 });		 	
	 }
	 
}]);