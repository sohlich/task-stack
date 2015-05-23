'use strict';

angular.module('justWork')
  .controller('TasklistCtrl', function($scope, $location, Security, UserStorage, TaskResource,$mdDialog) {

      $scope.tasks = [{
        'title': 'Todo',
        'description': 'Item that must be done',
        'done': true
      }, {
        'title': 'Todo',
        'description': 'Item that must be done',
        'done': true
      }];

        //Function to redirect
        $scope.redirect = function(path) {
          $location.path(path);
        };

      });
