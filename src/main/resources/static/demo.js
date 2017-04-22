angular.module('demo', []).controller('Users', function($scope, $http) {
    $http.get('http://localhost:8080/users').then(function(response) {
        $scope.users = response.data;
    });
});

