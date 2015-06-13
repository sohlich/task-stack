'use strict';

angular.module('justWork')
  .controller('TaskCtrl', TaskCtrl);


function TaskCtrl($scope, $location, Security, UserStorage, TaskResource) {
  $scope.task = {
    name: "",
    estimatedTime: "",
    deadline: "",
    description: "",
    tags: [],
    priority: 1,
    category: ""
  };


  $scope.addClick = function() {

    var task = $scope.task;

    TaskResource.saveTask(task)
      .$promise.then(function() {
        $location.path('/tasklist');
      });

  };
};
