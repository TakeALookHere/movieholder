(function () {
    'use strict';

    angular.module('MovieHolder', [
        'ui.router',
        'ngDesktopNotification',

        'movieList',
        'genreList',
        'common',
        'movie',
        'review'
    ])
    ;

})();