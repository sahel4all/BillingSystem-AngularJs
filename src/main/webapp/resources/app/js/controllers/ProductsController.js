/**
 * Created by msahel on 8/15/2016.
 */
var ProductsController= function ($scope,$http) {
    $http.get('products').success(function (data) {
        $scope.products=data;
    });
    // Post.query(function (data) {
    //     $scope.patients=data;
    //     }
    // );
}