(function () {
    'use strict';

    angular.module('movieList')
        .component('movieList', {
            templateUrl: '/templates/movie-list.html',
            controller: function ($http, $scope) {
                // var context = this;
                // context.movies = movies.data;

                $http.get("/AllMoviesServlet").then(successCallback, errorCallback);
                function successCallback(response, status, config, statusText) {
                    console.log(response.data)
                    $scope.movies = response.data
                }
                
                function errorCallback(response, status, config, statusText) {
                    console.log(response)
                }




                // var movieList = [
                //     {id: 1, nameRussian: "name 1", releasedDate: "2016-09-11"},
                //     {id: 2, nameRussian: "name 2", releasedDate: "2016-09-12"}
                // ];
                //
                // $scope.movies = movieList;
                // console.log("Hello")
            }
        })
        // .controller('MovieListController', function () {
        //     console.log("Hello")
        // })
    ;

})();