/**
 * Created by Gabriela on 02.06.2017.
 */
var app2 = angular.module('productInfo', []);

app2.controller('InfoController', function($scope,$http,$window,$log) {

    $scope.getInfo=function(){
        var data={
            code: $scope.code2
        };
        var config={ headers : {
            'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
        }};
        $http.post('http://localhost:8080/machines/findByCode', data)
            .success(function (data, status, headers, config) {
                var url = "http://" + $window.location.host + "/information.html";
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

