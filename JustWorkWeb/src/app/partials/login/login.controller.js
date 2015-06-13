'use strict';

angular.module('justWork')
  .controller('LoginCtrl', LoginCtrl);


function LoginCtrl($scope, $location, Security, TaskResource, UserStorage) {

  //Models
  $scope.formLogin = {
    username: 'admin',
    password: 'admin'
  };


  //Methods
  $scope.doLogin = function() {
    Security.login({
      username: $scope.formLogin.username,
      password: $scope.formLogin.password
    }, function(value, responseHeaders) {
      var headers = responseHeaders();
      UserStorage.saveToken(headers['x-auth-token']);
      UserStorage.saveUser(value);
      //if sucessfuly authenticated redirect
      $location.path("/tasklist");
    });

  };

};
