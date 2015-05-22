'use strict';

angular.module('justWork')
  .factory('UserStorage', ['$localStorage', function UserStorage($localStorage) {

    return {
      saveUser: function(token) {
        $localStorage.user = token;
      },
      getUser: function() {
        return $localStorage.user;
      },
      deleteUser: function() {
        $localStorage.user = null;
      },
      saveToken: function (token) {
          $localStorage.hmacToken = token;
      },
      getToken: function () {
          return $localStorage.hmacToken;
      },
      deleteToken: function () {
          $localStorage.hmacToken = null;
      },
      reset: function(){
        $localStorage.hmacToken = null;
        $localStorage.user = null;
      }
    };
  }]);
