var app = angular.module('register', []);

app.controller('controller', function($scope,$http,$window,$log) {

    $scope.Register=function(){
        var data={
            name: $scope.name,
            surname: $scope.surname,
            mail: $scope.mail,
            login: $scope.login,
            password: $scope.password
        };
        var config={ headers : {
            'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
        }};
        $http.post('http://localhost:8080/registration', data)
            .success(function (data, status, headers, config) {
                $scope.result =data;
                $scope.error=false;
                var url = "http://" + $window.location.host + "/index.html";
                $log.log(url);
                $window.location.href = url;
            })
            .error(function (data, status, header, config) {
                $scope.result = "Data: " + data +
                    "<hr />status: " + status +
                    "<hr />headers: " + header +
                    "<hr />config: " + config;
                $scope.error=true;
            });
    };

});