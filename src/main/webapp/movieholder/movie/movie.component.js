(function () {
    'use strict';

    angular.module('movie')
        .component('movie', {
            templateUrl: '/movieholder/movie/movie.html',
            controller: 'MovieController as ctrl'
         }
        )
    ;

})();