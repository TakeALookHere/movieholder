(function () {
    'use strict';

    angular.module('MovieHolder')
        .config(RoutesConfig)
    ;

    function RoutesConfig($stateProvider, $urlRouterProvider, $locationProvider) {
        //$locationProvider.hashPrefix('');
        $urlRouterProvider.otherwise('/movies');

        $stateProvider
            .state('movies', {
                url: '/movies',
                templateUrl: 'templates/movies.template.html'
            })

            .state('moviesByGenre', {
                url: '/movies?genre=:genreId',
                templateUrl: 'templates/movies.template.html'
            })

            .state('movie', {
                url: '/movie?movie=:movieId',
                templateUrl: 'templates/movie.template.html'
            })
        ;

    }

})();