'use strict';
var baseUrl;
var app = angular.module('aOne',
		[ 'ngAnimate', 'ngResource', 'ngRoute', 'firebase', 'toaster', 'angularMoment', 'toaster' ])

.config(function($routeProvider) {
	baseUrl = angular.element($('#baseUrl')).val();
	$routeProvider.when('/', {
		templateUrl : baseUrl + 'browse',
		controller : 'BrowseController'
	}).when('/browse/:itemId', {
		templateUrl : baseUrl + 'browse',
		controller : 'BrowseController'
	}).when('/register', {
		templateUrl : baseUrl + 'register',
		controller : 'AuthController'
	}).when('/login', {
		templateUrl : baseUrl + 'login',
		controller : 'AuthController'
	}).otherwise({
		redirectTo : '/'
	});
});
