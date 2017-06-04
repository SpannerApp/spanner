var app = angular.module('reportIssue', []);

app.controller('controller', function($scope,$http,$window,$log) {

    $scope.reportIssue=function(){
        var data={
            id: $scope.id,
            defectedMachine: $scope.defectedMachine,
            reportingEmployee: $scope.reportingEmployee,
            issueStatus: $scope.issueStatus,
            issueText: $scope.issueText,

        };
        var config={ headers : {
            'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
        }};
        $http.post('http://localhost:8080/reportedIssues/newReport', data)
            .success(function (data, status, headers, config) {
                $scope.result =data;
                $scope.error=false;
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
