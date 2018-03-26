var app = angular.module('app', []);

//#######################
//JSA CONTROLLER
//#######################

app.controller('jsaController', function($sce, $scope, $http, $location) {
    $scope.listCustomers = [];

    // $scope.getAllCustomer =
    function getAllCustomer(){
        // get URL
        var url = "http://localhost:8888/products/all";
        var trustedUrl = $sce.trustAsResourceUrl(url);

        // do getting with JSON-P
        $http.jsonp(trustedUrl).then(function (response) {
            $scope.getDivAvailable = true;
            $scope.listCustomers = response.data;
        }, function error(response) {
            $scope.postResultMessage = "Error Status: " +  response.statusText;
        });
    }

    getAllCustomer();
});



// var app = angular.module("UserManagement", []);
//
// //Controller Part
// app.controller("UserManagementController", function($scope, $http) {
//
//     //Initialize page with default data which is blank in this example
//     $scope.employees = [];
//     $scope.form = {
//         id : -1,
//         name : "",
//         specification : "",
//         photo : "",
//         price : -1.0,
//         persent : -1,
//         size : "",
//         priceWithPersent : -1.0
//     };
//
//     //Now load the data from server
//     _refreshPageData();
//
//     //HTTP POST/PUT methods for add/edit employee
//     $scope.submitEmployee = function() {
//
//         var method = "";
//         var url = "";
//         if ($scope.form.id == -1) {
//             //Id is absent so add employee - POST operation
//             method = "POST";
//             url = 'employees';
//         } else {
//             //If Id is present, it's edit operation - PUT operation
//             method = "PUT";
//             url = 'employees/' + $scope.form.id;
//         }
//
//         $http({
//             method : method,
//             url : url,
//             data : angular.toJson($scope.form),
//             headers : {
//                 'Content-Type' : 'application/json'
//             }
//         }).then( _success, _error );
//     };
//
//     //HTTP DELETE- delete employee by Id
//     $scope.removeEmployee = function(employee) {
//         $http({
//             method : 'DELETE',
//             url : 'employees/' + employee.id
//         }).then(_success, _error);
//     };
//
//     //In case of edit employee, populate form with employee data
//     $scope.editEmployee = function(employee) {
//         $scope.form.firstName = employee.firstName;
//         $scope.form.lastName = employee.lastName;
//         $scope.form.email = employee.email;
//         $scope.form.id = employee.id;
//     };
//
//     /* Private Methods */
//     //HTTP GET- get all employees collection
//     function _refreshPageData() {
//         $http({
//             //get: 'localhost:8888/menu/pizza',
//             method : 'GET',
//             url : 'all'
//         }).then(function successCallback(response) {
//             $scope.employees = response.data.products;
//         }, function errorCallback(response) {
//             console.log(response.statusText);
//         });
//     }
//
//     function _success(response) {
//         _refreshPageData();
//         _clearForm()
//     }
//
//     function _error(response) {
//         console.log(response.statusText);
//     }
//
//     //Clear the form
//     function _clearForm() {
//         $scope.form.firstName = "";
//         $scope.form.lastName = "";
//         $scope.form.email = "";
//         $scope.form.id = -1;
//     };
// });