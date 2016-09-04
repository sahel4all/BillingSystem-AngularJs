'use strict'

var BillController=function ($http,$scope,GenerateBillService) {
    $scope.collection=[];
    $scope.forms = [{
        name: "billForm",
        products:[{ id: '', name: '', quantity: '',discount: '',price: '',total: ''}]}];
    $scope.addBillDetails=function () {

        var price=$scope.product.amount;
        var quantity=$scope.product.quantity;
        var discount=$scope.product.discount;

        var discountedPrice=price - (price/discount);

        var productObj=$scope.product;
        productObj.total=((discountedPrice*quantity));

        $scope.collection.push(productObj);
        $scope.product='';

    };
    $scope.generateBill=function (collection) {
            var promise=GenerateBillService.generateBill(collection);

        promise.then(function (response) {
                response.data;
                alert('Bill generated Successfully.');
            },
            function (error) {
                alert(error);
                $scope.setError(error);
            });
    };
};
