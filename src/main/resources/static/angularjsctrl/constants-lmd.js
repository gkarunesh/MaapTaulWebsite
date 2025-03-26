var app = angular.module('master', []);

app.service('constantService', [ '$http', function($http) {

	//local
	//this.baseUrl='http://192.168.1.20:65001/app';
	//live
	this.baseUrl='https://wemmis.bih.nic.in/app';
} ]);