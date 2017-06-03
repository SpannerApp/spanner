/**
 * Created by Gabriela on 02.06.2017.
 */
var app2 = angular.module('productInfo', ['search']);

app2.controller('InfoController', function($scope,$http,$window,$log,ServiceA) {


var daane=ServiceA.getValue();
        $scope.result=daane;
    // $scope.result="japierdole";
});

