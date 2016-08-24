'use strict'

var BillController=function ($http,$scope) {
    $scope.addBillDetails=function (product) {
       // products.push(product);
        $scope.products.push(product);
    }
};
