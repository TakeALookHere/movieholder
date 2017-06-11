(function () {
    'use strict';

    angular.module('movieList')
        .component('movieList', {
            templateUrl: '/templates/movie-list.html',
            controller: function ($http, $scope, $stateParams) {
                $scope.genreId = $stateParams.genreId;
                console.log("genreId: " + $scope.genreId);
                $http.get("/AllMoviesServlet?genre=" + $scope.genreId).then(successCallback, errorCallback);
                function successCallback(response) {
                    console.log("movie list response data", response.data);
                    $scope.movies = response.data
                }
                
                function errorCallback(response) {
                    console.log("movie list error response", response)
                }
            }
        })
    ;

})();