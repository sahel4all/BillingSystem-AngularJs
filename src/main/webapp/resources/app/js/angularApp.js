/**
 * Created by msahel on 8/11/2016.
 */
'use strict';
var mainApp=angular.module('BMSApp',['ngRoute']);

mainApp.config(['$routeProvider','$httpProvider', function ($routeProvider, $httpProvider) {
    $routeProvider.
   when('/products',{
        templateUrl:'products/layout',
        controller: ProductsController
    }).
    when('/product/:id',{
        templateUrl: 'product/layout',
        controller: ProductController
    }).
    when('/bill',{
       templateUrl:'bill/layout',
        controller:BillController
    }).
    otherwise('/BMS');
}]).filter('searchProductInfoFilter',function () {
    return function (arr,key) {
        if(!key){
            return arr;
        }
        var returnArr=[];
        key=key.toLowerCase();
        angular.forEach(arr,function (products) {
            if(products.name!=null && products.name.toLowerCase().indexOf(key) !==-1){
                returnArr.push(products);
            }
            if(products.id!=null && products.id==(key)){
                returnArr.push(products);
            }
            
        });
        return returnArr;
    }
    
}).service('ProductService',['$http','$q',function ($http,$q) {
    var deferred=$q.defer();

    this.addProducts=function (product) {
    $http.put('product',product,{}).success(function (response) {
        deferred.resolve(response);
    }).error(function (message) {
        deferred.reject(message);
    });
        return deferred.promise;
    };
}]);