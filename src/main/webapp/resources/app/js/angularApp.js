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

}]).service('GetInvoiceNumberService',['$http','$q',function ($http,$q) {
    var deferred=$q.defer();

    this.fetchDetails=function (id) {
        $http.get('getNextSeqVal').then(function (response) {
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
}]).directive('calculateMargin',['productHelper',function (productHelper) {
    return{
        restrict:'AE',
        require: 'ngModel',
        transclude:'true',
        replace: true,
        //  scope: {id: '=', name: '=', quantity: '=',discount: '=',price: '=',total: '='},

        link: function (scope,element,attrs,ngModel) {
            var promise="";
            element.bind('blur',function ($http) {
                if(scope.product.buying_cost<=0 || scope.product.selling_cost<=0) return;

                scope.product.margin_amount=scope.product.selling_cost-scope.product.buying_cost;
                scope.product.margin_percentage=((scope.product.selling_cost-scope.product.buying_cost)*100)/scope.product.buying_cost;
            });

            element.bind('focus',function ($http) {
                scope.product.margin_amount="";
                scope.product.margin_percentage="";
            });

        }
    }
}]).directive('calculateDiscountedSellingPrice',['productHelper',function (productHelper) {
    return{
        restrict:'AE',
        require: 'ngModel',
        transclude:'true',
        replace: true,
        //  scope: {id: '=', name: '=', quantity: '=',discount: '=',price: '=',total: '='},

        link: function (scope,element,attrs,ngModel) {
            var promise="";
            element.bind('blur',function ($http) {
                if(scope.product.discount.trim()=="" || scope.product.discount<=0) return;

                scope.product.selling_cost=scope.product.selling_cost - ((scope.product.selling_cost*scope.product.discount)/100);
            });

            element.bind('focus',function ($http) {

            });

        }
    }
}])// The default logo for the invoice
    .constant('DEFAULT_LOGO', 'images/logo.png')

    // The invoice displayed when the user first uses the app
    .constant('DEFAULT_INVOICE', {
        tax: 0.00,
        invoice_number: 10,
        customer_info: {
            name: 'Abid Mohammed',
            web_link: 'John Doe Designs Inc.',
            address1: '1 Infinite Loop',
            address2: 'Cupertino, California, US',
            postal: '500086'
        },
        company_info: {
            name: 'CreativeGuys',
            web_link: 'www.metawarelabs.com',
            address1: '123 Yonge Street',
            address2: 'Toronto, ON, Canada',
            postal: '500008'
        },
        items:[
            { code:"ABC123",quantity: 1, description: 'Gadget', discount:"5",cost: 9.95 }
        ]
    })

    // Service for accessing local storage
    .service('LocalStorage', [function() {

        var Service = {};

        // Returns true if there is a logo stored
        var hasLogo = function() {
            return !!localStorage['logo'];
        };

        // Returns a stored logo (false if none is stored)
        Service.getLogo = function() {
            if (hasLogo()) {
                return localStorage['logo'];
            } else {
                return false;
            }
        };

        Service.setLogo = function(logo) {
            localStorage['logo'] = logo;
        };

        // Checks to see if an invoice is stored
        var hasInvoice = function() {
            return !(localStorage['invoice'] == '' || localStorage['invoice'] == null);
        };

        // Returns a stored invoice (false if none is stored)
        Service.getInvoice = function() {
            if (hasInvoice()) {
                return JSON.parse(localStorage['invoice']);
            } else {
                return false;
            }
        };

        Service.setInvoice = function(invoice) {
            localStorage['invoice'] = JSON.stringify(invoice);
        };

        // Clears a stored logo
        Service.clearLogo = function() {
            localStorage['logo'] = '';
        };

        // Clears a stored invoice
        Service.clearinvoice = function() {
            localStorage['invoice'] = '';
        };

        // Clears all local storage
        Service.clear = function() {
            localStorage['invoice'] = '';
            Service.clearLogo();
        };

        return Service;

    }])

    .service('Currency', [function(){

        var service = {};

        service.all = function() {
            return [
                {
                    name: 'British Pound (£)',
                    symbol: '£'
                },
                {
                    name: 'Canadian Dollar ($)',
                    symbol: 'CAD $ '
                },
                {
                    name: 'Euro (€)',
                    symbol: '€'
                },
                {
                    name: 'Indian Rupee (₹)',
                    symbol: '&#8377;'
                },
                {
                    name: 'Norwegian krone (kr)',
                    symbol: 'kr '
                },
                {
                    name: 'US Dollar ($)',
                    symbol: '$'
                }
            ]
        }

        return service;

    }]);
