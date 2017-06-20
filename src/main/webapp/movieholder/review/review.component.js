(function () {
    'use strict';

    angular.module('review')
        .component('review', {
                templateUrl: '/movieholder/review/review.html',
                controller: 'ReviewController as reviewItemCtrl',
                bindings: {
                    reviews: "<"
                }
            }
        )
    ;

})();