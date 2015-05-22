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




      //Dialog to add task
      $scope.showAdvanced = function(ev) {
        $mdDialog.show({
            controller: DialogController,
            template:
            '<md-dialog aria-label="List dialog">' +
           '  <md-dialog-content>'+
           '    <md-list>'+
           '      <md-list-item ng-repeat="item in items">'+
           '       <p>Number {{item}}</p>' +
           '      '+
           '    </md-list-item></md-list>'+
           '  </md-dialog-content>' +
           '  <div class="md-actions">' +
           '    <md-button ng-click="closeDialog()" class="md-primary">' +
           '      Close Dialog' +
           '    </md-button>' +
           '  </div>' +
           '</md-dialog>'
            ,
            targetEvent: ev,
          })
          .then(function(answer) {
            $scope.alert = 'You said the information was "' + answer + '".';
          }, function() {
            $scope.alert = 'You cancelled the dialog.';
          });
      };


      function DialogController($scope, $mdDialog) {
        $scope.hide = function() {
          $mdDialog.hide();
        };
        $scope.cancel = function() {
          $mdDialog.cancel();
        };
        $scope.answer = function(answer) {
          $mdDialog.hide(answer);
        };
      };






      });
