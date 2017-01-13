'use strict'

var ProductController=function($scope,$http,$routeParams,ProductService){

    $scope.getProduct= function(){
        //alert($routeParams.id);
        if ($routeParams.id!=='add'){
            $http.get('product/'+$routeParams.id).success(function(product){
                $scope.product=product;
            });
        }
    };
    $scope.getProduct();

    $scope.addProduct=function (product) {
        var promise=ProductService.addProducts(product);

        promise.then(function (response) {
            //$scope.product=response;
            $scope.product = {};
            alert('Product Added/Updated Successfully.');
        },
        function (error) {
            alert(error);
            $scope.setError(error);
        });

    };

    $scope.resetData=function (product) {
        $scope.product = {};
        $scope.productForm.$setPristine();
    };
};