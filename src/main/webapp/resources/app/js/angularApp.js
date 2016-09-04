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
}]).directive('fetchProducts',['productHelper',function (productHelper) {
    return{
        restrict:'AE',
        require: 'ngModel',
        transclude:'true',
        replace: true,
      //  scope: {id: '=', name: '=', quantity: '=',discount: '=',price: '=',total: '='},

        link: function (scope,element,attrs,ngModel) {
            var promise="";
            element.bind('blur',function ($http) {
                if(scope.product.id<=0) return;

                promise=productHelper.fetchDetails(scope.product.id);

                promise.then(function (response) {
                        scope.product.amount=response.data.amount;
                        scope.product.name=response.data.name;
                        scope.product.quantity=response.data.quantity;
                    }
                    );
            });

            element.bind('focus',function ($http) {
                scope.product.amount="";
                scope.product.name="";
                scope.product.quantity="";
            });

        }
    }
}]).service('productHelper',['$http','$q',function ($http,$q) {
    var deferred=$q.defer();

    this.fetchDetails=function (id) {
        $http.get('product/'+id).then(function (response) {
            deferred.resolve(response);
            //alert("response.data.name in productHelper:"+response.data.name );
        },function (response) {
            deferred.reject(response);
        })

        return deferred.promise;
    };

}]).service('GenerateBillService',['$http','$q',function ($http,$q) {
    var deferred=$q.defer();

    this.generateBill=function (products) {
        var txnDetails={};
        var coll=[];

        products.forEach(myFunc);

        function myFunc(item,index){
            txnDetails.id=item.id;
            txnDetails.name=item.name;
            txnDetails.quantity=item.quantity;
            txnDetails.discount=item.discount;
            txnDetails.totalAmount=item.total;
            coll.push(txnDetails);
        }


        $http.put('generateBill',coll,{}).success(function (response) {
            deferred.resolve(response);
        }).error(function (message) {
            deferred.reject(message);
        });
        return deferred.promise;
    };
}]);
