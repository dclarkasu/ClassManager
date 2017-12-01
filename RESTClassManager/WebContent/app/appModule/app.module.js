angular.module('appModule', ['ngRoute', 'ui.bootstrap'])
.config(function($routeProvider) {
	$routeProvider
	.when('/', {
		template: '<home></home>'
	})
});