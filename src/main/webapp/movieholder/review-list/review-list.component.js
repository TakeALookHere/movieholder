(function () {
    'use strict';

    angular.module('reviewList')
        .component('reviewList', {
                templateUrl: '/movieholder/review-list/review-list.html',
                controller: 'ReviewListController as reviewCtrl',
                bindings: {
                    reviews: "<"
                }
            }
        )
    ;

})();