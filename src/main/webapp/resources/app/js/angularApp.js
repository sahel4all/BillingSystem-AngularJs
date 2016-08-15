/**
 * Created by msahel on 8/11/2016.
 */
'use strict';
var mainApp=angular.module('BMSApp',['ngRoute']);

mainApp.config(['$routeProvider','$httpProvider', function ($routeProvider, $httpProvider) {
    $routeProvider.
    when('/product/1',{
        templateUrl:'product/layout',
        controller: ProductController
    }).
    otherwise('/BMS');
}]);