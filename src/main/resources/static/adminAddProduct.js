/**
 * Created by Siekacz on 05.06.2017.
 */
var app = angular.module('adminAddProduct', []);

app.controller('controller', function($scope,$http,$window,$log) {

    $http.get('http://localhost:8080/employees/servicemen')
        .then(function (result) {
            $scope.servicemen= result.data;
        });

    $scope.AddProduct=function(){
        var data={
            code: $scope.code,
            name: $scope.name,
            model: $scope.model,
            section: $scope.section,
            colour: $scope.colour,
            lastRepair: $scope.lastRepair,
            lastServiceman: {employeeID : parseInt($scope.servicemen.employeeID)},
            description: $scope.description,
        };
        var config={ headers : {
            'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
        }};
        $http.post('http://localhost:8080/machines/addMachine', data)
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