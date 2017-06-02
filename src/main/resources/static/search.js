var app = angular.module('search', []);

app.controller('controller', function($scope,$http,$window,$log) {

    $scope.Search=function(){
        var data={
            code: $scope.code2
        };
        var config={ headers : {
            'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
        }};
        $http.post('http://localhost:8080/machines/findByCode', data)
            .success(function (data, status, headers, config) {
                $scope.result =data;
                $scope.error=false;
                var url = "http://" + $window.location.host + "/info.html";
                $log.log(url);
                $window.location.href = url;
            })
            .error(function (data, status, header, config) {
                /* $scope.result = "Data: " + data +
                 "<hr />status: " + status +
                 "<hr />headers: " + header +
                 "<hr />config: " + config;*/
                $scope.error=true;
            });
    };
});