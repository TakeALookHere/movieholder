(function () {
    'use strict';

    angular.module('movie')
        .component('movie', {
            templateUrl: '/templates/movie.html',
            controller: function ($http, $scope, $stateParams) {
                $scope.movieId = $stateParams.movieId;
                console.log("movieId: " + $scope.movieId);
                $http.get("/MovieServlet?movie=" + $scope.movieId).then(successCallback, errorCallback);
                function successCallback(response) {
                    console.log("movie response data", response.data);
                    $scope.movie = response.data
                }

                function errorCallback(response) {
                    console.log("movie error response", response)
                }
            }
        })
    ;

})();