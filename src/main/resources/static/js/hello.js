/**
 * Created by Robin_2 on 15/04/2016.
 */
angular.module('hello', [])
    .controller('home', function($scope) {
        $scope.greeting = {id: 'xxx', content: 'Hello World!'}
    })