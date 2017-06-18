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

        service.addReview = function (review) {
            console.log("Review in the POST", review);
            console.log("ToJson", JSON.stringify({'review': review}));
            return $http({
                method: "POST",
                url: ("/review"),
                data: JSON.stringify({'description': review.description, 'movie' : review.movie, 'user' : review.user}),
                headers: {'Content-Type': 'application/json'}
            });
        };

        service.removeReview = function(reviewId){
            console.log("Review id for removal: ", reviewId);
            console.log("ToJson", JSON.stringify({'id': reviewId}));
            return $http({
                method: "DELETE",
                url: ("/review"),
                data: JSON.stringify({'id': reviewId}),
                headers: {'Content-Type': 'application/json'}
            });
        };
    }


})();