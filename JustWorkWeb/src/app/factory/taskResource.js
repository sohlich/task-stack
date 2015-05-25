'use strict';

angular.module('justWork')
        .factory('TaskResource',['$resource','$localStorage',function TaskResource($resource,$localStorage) {
            return $resource(baseUrl+'/api/task', {}, {
                get: {
                    method: 'GET',
                    url: baseUrl+'/api/task/:taskId',
                    isArray: true,
                    headers:{'x-auth-token':$localStorage.hmacToken},
                    params:{}
                },
                saveTask: {
                    method: 'PUT',
                    url: baseUrl+'/api/task',
                    isArray: false,
                    headers:{'x-auth-token':$localStorage.hmacToken},
                    params:{}
                }
            });
        }]);
