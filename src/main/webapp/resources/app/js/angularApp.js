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
   when('/products',{
        templateUrl:'products/layout',
        controller: ProductsController
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
    
});