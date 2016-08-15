'use strict'

var ProductController=function($scope,$http,$routeParams){

    $scope.getProduct= function(){
        $http.get('product/1').success(function(product){
            $scope.product=product;
        });
    };
    $scope.getProduct();
};