var app = angular.module('adminAddUser', []);

app.controller("GetEmployeesController", function($scope, $http) {
    $scope.showModal = false;
    $http.get('http://localhost:8080/employees')
        .then(function (result) {
            $scope.employees= result.data;
        });
    $http.get('http://localhost:8080/roles')
        .then(function (role) {
            $scope.roles= role.data;
        });

    $scope.Register=function(){
        var data={
            username: $scope.username,
            password: $scope.password,
            employee: {employeeID: parseInt($scope.employees.employeeID)},
            role: {roleID: parseInt($scope.roles.roleID)}

        };
        var config={ headers : {
            'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
        }};
        $http.post('http://localhost:8080/users', data)
            .success(function (data, status, headers, config) {
                $scope.result =data;
                $scope.error=false;
                $scope.success=true;
              $scope.showModal=true;
            })
            .error(function (data, status, header, config) {
                // $scope.result = "Data: " + data +
                //     "<hr />status: " + status +
                //     "<hr />headers: " + header +
                //     "<hr />config: " + config;
                $scope.error=true;
                $scope.success=false;
            });

    };
});