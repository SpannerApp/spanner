var app = angular.module('search', []);

   app.controller('controller', function($scope,$http,$window,$log,ServiceA) {
    $scope.Search=function(){
        var data={
            code: $scope.code2
        };
        var config={ headers : {
            'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
        }};
        $http.post('http://localhost:8080/machines/findByCode', data)
            .success(function (data, status, headers, config) {
               var dane=data;
               $scope.dane=dane;
               ServiceA.setValue("kurwa");
               $scope.kurwa=dane;
                $scope.error=false;

                var url = "http://" + $window.location.host + "/information.html";
                $log.log(url);
            //  $window.location.href = url;
            })
            .error(function (data, status, header, config) {
                /* $scope.result = "Data: " + data +
                 "<hr />status: " + status +
                 "<hr />headers: " + header +
                 "<hr />config: " + config;*/
                $scope.error=true;
            });
    };


})
       .service('ServiceA', function() {

           this.getValue = function () {
               return this.myValue;
           };

           this.setValue = function (newValue) {
               this.myValue = newValue;
           }
       })
       .controller('InfoController', function($scope,$http,$window,$log,ServiceA) {


    var daane=ServiceA.getValue();
    $scope.result=daane;
    // $scope.result="japierdole";
});

