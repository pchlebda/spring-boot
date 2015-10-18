/**
 * Created by Piotr on 17.10.2015.
 */
var controllerModule = angular.module('controllerModule', []);

controllerModule.controller('RegisterCtrl', function ($scope, $http) {

    $scope.registered = false;
    $scope.error = false;
    var userNameRegex = new RegExp("^[a-zA-Z0-9]{5,}");
    var passwordRegex = new RegExp("((?=.*\\d)(?=.*[A-Z])(?=.*[a-z]).{8,})");

    this.register = function (user) {
        if (isValid(user)) {
            register(user);
        }
    };

    var isValid = function (user) {
        return hasRequiredFields(user) &&
            userNameRegex.test(user.name) &&
            passwordRegex.test(user.password);
    };

    var hasRequiredFields = function (user) {
        return user != undefined && user.name != undefined && user.password != undefined;
    };

    var register = function (user) {
        $http.post("/register", user).success(function (response) {
            $scope.userName = response.name;
            $scope.registered = true;
            $scope.error = false;
        }).error(function (response) {
            $scope.error = true;
            $scope.errorMessage = 'Username: ' + response.name + ' already exist';

        });
    };

});