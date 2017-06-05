(function () {
    'use strict';

    angular.module('movieList')
        .component('movieList', {
            templateUrl: '/templates/movie-list.html',
            controller: function ($http, $scope) {
                $http.get("/AllMoviesServlet").then(successCallback, errorCallback);
                function successCallback(response) {
                    console.log("response data", response.data);
                    $scope.movies = response.data
                }
                
                function errorCallback(response) {
                    console.log("error response", response)
                }
            }
        })
    ;

})();