(function () {
    'use strict';

    angular.module('movieList')
        .component('movieList', {
            templateUrl: '/movieholder/movie-list/movie-list.html',
            controller: 'MovieListController as ctrl'
        })
    ;

})();