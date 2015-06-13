'use strict';

angular.module('justWork')
  .controller('TasklistCtrl', TasklistCtrl);


function TasklistCtrl($scope, $location, Security, UserStorage, TaskResource) {
  $scope.tasks;
  TaskResource.getAll({}, function(value, responseHeaders) {
    $scope.tasks = value;
  });
};
