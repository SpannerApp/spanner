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
   app.controller('controller', function($scope,srvShareData,$http,$window,$log) {

       var kod= $scope.code2;
       $scope.kurwa=kod;
      srvShareData.addData(kod);
    $scope.Search=function(){
        var data={
            code: $scope.code2
        };

        var config={ headers : {
            'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
        }};
        $http.post('http://localhost:8080/machines/findByCode', data)
            .success(function (data, status, headers, config) {
                var url = "http://" + $window.location.host + "/infoProduct.html";

                $log.log(url);

             //$window.location.href = url;
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
app.controller('InfoController', function($scope, srvShareData,$http) {

    //var kod=srvShareData.getData().toString();
    var dane=srvShareData.getData();
    $scope.jas=dane.toString();
     $scope.kod = srvShareData.getData();
     $scope.GetInfo=function(){
        var data={
            code: "1885/EXT"
        };
        var config={ headers : {
            'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
        }};
        $http.post('http://localhost:8080/machines/findByCode',srvShareData.getData())
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
     };
});
app.service('srvShareData', function($window) {
    var KEY = 'App.SelectedValue';

    var addData = function(newObj) {
        var mydata = $window.sessionStorage.getItem(KEY);
        if (mydata) {
            mydata = JSON.parse(mydata);
        } else {
            mydata = [];
        }
        mydata.push(newObj);
        $window.sessionStorage.setItem(KEY, JSON.stringify(mydata));
    };

    var getData = function(){
        var mydata = $window.sessionStorage.getItem(KEY);
        if (mydata) {
            mydata = JSON.parse(mydata);
        }
        return mydata || [];
    };

    return {
        addData: addData,
        getData: getData
    };
});
