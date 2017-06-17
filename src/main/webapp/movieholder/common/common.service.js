(function () {
    'use strict';

    angular.module('common')
        .service('CommonService', CommonService)
    ;


    CommonService.$inject = ['$http'];
    function CommonService($http) {
        var service = this;

        service.getMovies = function () {
            return $http({
                method: "GET",
                url: ("/movies")
            });
        };


        service.getMoviesByGenre = function (genreId) {
            return $http({
                method: "GET",
                url: ("/movies"),
                params: {
                    genre: genreId
                }
            });
        };

        service.getGenres = function () {
            return $http({
                method: "GET",
                url: ("/genres")
            });
        };

        service.getMovieById = function (movieId) {
            return $http({
                method: "GET",
                url: ("/movie"),
                params: {
                    movie: movieId
                }
            });
        };

    }


})();