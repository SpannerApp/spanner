var app = angular.module('adminAddEmployee', []);

app.controller('controller', function($scope,$http,$window,$log, $timeout) {

    $scope.AddEmployee=function(){
        var data={
            // positionID: $scope.positionID,
            // supervisorID: $scope.supervisorID,
            address: $scope.address,
            mail: $scope.mail,
            phone: $scope.phone,
            name: $scope.name,
            surname: $scope.surname,
        };
        var config={ headers : {
            'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
        }};
        $http.post('http://localhost:8080/employees/insertEmployee', data)
            .success(function (data, status, headers, config) {
                $scope.addEmployeeSuccess = true;
                $scope.result =data;
                $scope.error=false;
                var url = "http://" + $window.location.host + "/adminAddUser.html";
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