var app = angular.module('master',[]);

app.service('authGuardService', ['$http', function($http) {
	    
	 	this.authenticate = function(token) {
	 		var isValid=false;
	    	 var data={'token': token};
	    	 $http.post('/lmd/authenticate/validateToken',data ).then(function (response) {
	    		 if(response.data.statusCode===200){
                	 sessionStorage.setItem('tokenValidate', response.data.data);
                	 isValid=response.data.data;
                 }else{
                	 sessionStorage.setItem('tokenValidate', false);
                	 return false;
                 }
	    		//console.log(isValid);
	    		}, function (response) {
	    		// this function handles error
	    			sessionStorage.setItem('tokenValidate', false);
	    			console.log(response);
	    			//return isValid;
	    		});
	    	
	    	return isValid;
	    };	    
	  }

	/*this.GLOBAL_API = function() {
		return $http({
			method : '/lmd'
		}).then(function(result){
			return result;
		})
	}*/
]);

	app.filter('unique', function() {
	   return function(collection, keyname) {
	      var output = [], 
	          keys = [];

	      angular.forEach(collection, function(item) {
	          var key = item[keyname];
	          if(keys.indexOf(key) === -1) {
	              keys.push(key);
	              output.push(item);
	          }
	      });

	      return output;
	   };
	});