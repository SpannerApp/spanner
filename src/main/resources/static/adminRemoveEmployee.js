var app = angular.module('adminRemoveEmployee', []);

app.controller("RemoveEmployeeController", function($scope, $http) {

    $scope.error = false;
    $scope.succes = false;


    $http.get('http://localhost:8080/employees')
        .then(function (result) {
            $scope.employees= result.data;
        });
    $http.get('http://localhost:8080/roles')
        .then(function (role) {
            $scope.roles= role.data;
        });

    $scope.RemoveEmployeeFromDB=function(id){
        var data={
            EmployeeID: parseInt(id)

        };
        var config= {data: JSON.stringify(data)};

        $http.delete("http://localhost:8080/employees/removeEmployee/" + data)
            .success(function (data, status, headers, config) {
            $scope.result =data;
            $scope.error=false;
            $scope.success=true;
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
