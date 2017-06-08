(function () {
    'use strict';

    angular.module('MovieHolder', [])
        .config(
            function(
                $routeProvider,
                $locationProvider
            ) {

        $routeProvider
            .when('/movies', {template: '<navbar></navbar><header></header><movie-list></movie-list>'})
            .when('/movies/?genre=:genre.name', {template: '<navbar></navbar><header></header><movie-list></movie-list>', controller: GenreController})
            .otherwise({redirectTo: '/movies'});

        $locationProvider.html5Mode(true);

    });

})();