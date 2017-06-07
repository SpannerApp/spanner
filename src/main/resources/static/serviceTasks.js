var app = angular.module('serviceTasks', []);

app.controller("TasksController", function($scope, $http,$window) {

    $http.get('http://localhost:8080/reportedIssues')
        .then(function (result) {
            $scope.issues= result.data;
        });

    $scope.ChangeStatus=function(id,status){
        var data={
            issueStatus: status,
            id: parseInt(id)
        };
        var config={ headers : {
            'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
        }};
        $http.put('http://localhost:8080/reportedIssues/changeStatus', data)
            .success(function (data, status, headers, config) {
                $scope.result =data;
                $window.location.reload();

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
    $scope.SearchByServiceman=function(){
        var data={
            username: $scope.serviceman
        };
        var config={ headers : {
            'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
        }};
        $http.post('http://localhost:8080/reportedIssues/tasksForServiceman', data)
            .success(function (data, status, headers, config) {
                $scope.issues= data;

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