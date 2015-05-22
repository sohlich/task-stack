'use strict';

angular.module('justWork')
  .directive('ngHeader', ['UserStorage', function(UserStorage) {
    return {
      restrict: 'A',
      scope: {
        title: '@'
      },
      templateUrl: 'app/directives/header/header_template.html',
      controller: function($scope) {
        $scope.user = UserStorage.getUser();
        $scope.showUser = function(){
          return typeof UserStorage.getUser() != 'undefined';
        }
      }
    };
  }]);
