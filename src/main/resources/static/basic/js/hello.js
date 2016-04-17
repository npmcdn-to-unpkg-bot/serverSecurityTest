/**
 * Created by Robin_2 on 15/04/2016.
 */
angular.module('hello', []).controller('home', function($http, $scope) {
    var self = this;
    $http.get('resource/').then(function(response) {
        self.greeting = response.data;
        $scope.got = response.data;

    })
});

