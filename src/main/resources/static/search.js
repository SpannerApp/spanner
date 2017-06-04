var app = angular.module('search', ['ngRoute']);

app.config(["$routeProvider", "$locationProvider", function($routeProvider, $locationProvider){
    $routeProvider
        .when("/", {
            templateUrl: "writeCode.html",
            controller: "controller"
        })
        .when("/page2", {
            templateUrl: "InfoProduct.html",
            controller: "InfoController"
        })
    // .otherwise({ redirectTo: '/'})
    ;
}]);
   app.controller('controller', function($scope,$http,$window,$log) {

    $scope.Search=function(){
        var data={
            code: $scope.code2
        };

            var mydaata=$scope.code2;

        sessionStorage.mydaata= JSON.stringify(mydaata);
        var config={ headers : {
            'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
        }};
        $http.post('http://localhost:8080/machines/findByCode', data)
            .success(function (data, status, headers, config) {
                var url = "http://" + $window.location.host + "/infoProduct.html";

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
app.controller('InfoController', function($scope,$http,$window) {

    angular.element(document).ready(function () {
        var data={
            code:  JSON.parse(sessionStorage.mydaata)
        };
        var config={ headers : {
            'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
        }};
        $http.post('http://localhost:8080/machines/findByCode',data)
            .success(function (data, status, headers, config) {
              $scope.information=data;

            })
            .error(function (data, status, header, config) {
                /* $scope.result = "Data: " + data +
                 "<hr />status: " + status +
                 "<hr />headers: " + header +
                 "<hr />config: " + config;*/

                $scope.error=true;
            });
     });


    $scope.reportIssue=function(){
        var data={
            defectedMachine: {id: parseInt($scope.information.id)},
            reportingEmployee: {employeeID: parseInt($scope.reportingEmployee)},
            issueStatus: $scope.issueStatus,
            issueText: $scope.issueText

        };
        var config={ headers : {
            'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
        }};

        $scope.errorMessageReport=false;
        var messageExist = false;
        if (document.getElementById("message-text").value != "") {
            messageExist = true;
        }

        if(messageExist){
            $http.post('http://localhost:8080/reportedIssues/newReport', data)
                .success(function (data, status, headers, config) {
                    $scope.errorReport=false;
                    $scope.result =data;

                })
                .error(function (data, status, header, config) {
                    $scope.errorReport=true;
                });
        }else{
            $scope.errorMessageReport=true;
        }


    };


});



// app.service('srvShareData', function($window) {
//     var KEY = 'App.SelectedValue';
//
//     var addData = function(newObj) {
//         var mydata = $window.sessionStorage.getItem(KEY);
//         if (mydata) {
//             mydata = JSON.parse(mydata);
//         } else {
//             mydata = [];
//         }
//         mydata = [];
//         mydata.push(newObj);
//
//         $window.sessionStorage.setItem(KEY, JSON.stringify(mydata));
//     };
//
//     var getData = function(){
//         var mydata = $window.sessionStorage.getItem(KEY);
//         if (mydata) {
//             mydata = JSON.parse(mydata);
//         }
//         return mydata || [];
//     };
//
//     return {
//         addData: addData,
//         getData: getData
//     };
// });
