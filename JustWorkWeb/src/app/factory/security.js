'use strict';

angular.module('justWork')
        .factory('Security',['$resource',function Security($resource) {
            return $resource(baseUrl+'/security', {}, {
                login: {
                    method: 'POST',
                    url: baseUrl+'/security/login',
                    params:{}
                }
            });
        }]);