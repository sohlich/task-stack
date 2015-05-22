'use strict';

angular.module('justWork')
        .controller('TaskCtrl', function ($scope,$location, Security, UserStorage,TaskResource) {

            $scope.tasks = [{'title': 'Todo','description': 'Item that must be done','done':true },
            {'title': 'Todo','description': 'Item that must be done','done':true }];

        });
