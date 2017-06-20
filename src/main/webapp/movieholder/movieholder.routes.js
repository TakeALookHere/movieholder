(function () {
    'use strict';

    angular.module('MovieHolder')
        .config(RoutesConfig)
    ;

    function RoutesConfig($stateProvider, $urlRouterProvider, $locationProvider) {
        $locationProvider.hashPrefix('');
        $urlRouterProvider.otherwise('/movies');

        $stateProvider
            .state('movies', {
                url: '/movies',
                template: '<movie-list></movie-list>'
            })

            .state('moviesByGenre', {
                url: '/movies?genre=:genreId',
                template: '<movie-list></movie-list>'
            })

            .state('movie', {
                url: '/movie?movie=:movieId',
                template: '<movie></movie>'
            })

            .state('review', {
                url: '/review?review=:reviewId',
                template: '<review reviews="ctrl.movie.reviews"></review>'
            })
        ;

    }

})();