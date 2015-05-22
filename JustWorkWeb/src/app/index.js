'use strict';

var baseUrl = 'http://localhost:8080';

angular.module('justWork', ['ngAnimate', 'ngCookies', 'ngTouch', 'ngSanitize', 'ngResource', 'ngRoute', 'ngMaterial', 'picardy.fontawesome', 'ngStorage'])
  .config(function($routeProvider, $mdThemingProvider) {
    $routeProvider
      .when('/login', {
        templateUrl: 'app/partials/login/login.html',
        controller: 'LoginCtrl'
      })
      .when('/register', {
        templateUrl: 'app/partials/register/register.html',
        controller: 'RegisterCtrl'
      })
      .when('/tasklist', {
        templateUrl: 'app/partials/tasklist/tasklist.html',
        controller: 'TasklistCtrl'
      })
      .when('/task', {
        templateUrl: 'app/partials/task/task.html',
        controller: 'TaskCtrl'
      })
      .otherwise({
        redirectTo: '/login'
      });

    $mdThemingProvider.theme('default')
      .primaryPalette('indigo')
      .accentPalette('red');


  });
