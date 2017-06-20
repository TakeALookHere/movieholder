(function () {
    'use strict';

    angular.module('review')
        .controller('ReviewController', ReviewController)
    ;

    ReviewController.$inject = ['$stateParams', 'CommonService', '$state'];
    function ReviewController($stateParams, CommonService, $state) {
        var reviewItemCtrl = this;

        reviewItemCtrl.reviewId = $stateParams.reviewId;
        console.log("reviewId: " + reviewItemCtrl.reviewId);


        var promise = CommonService.getReviewById(reviewItemCtrl.reviewId);
        promise.then(successCallback, errorCallback);

        function successCallback(response) {
            console.log("reviewItem response data", response.data);
            reviewItemCtrl.review = response.data;
        }

        function errorCallback(response) {
            console.log("reviewItem error response", response);
        }


        reviewItemCtrl.putReview = function (review) {
            reviewItemCtrl.review = review;

            console.log("review from form update", review);
            var promise = CommonService.putReview(reviewItemCtrl.review);
            promise.then(successCallbackPut, errorCallback);
        };

        function successCallbackPut(response) {
            console.log("Movie id in review ctrl: ", reviewItemCtrl.review.movie.id);
            $state.go('movie', {movieId: reviewItemCtrl.review.movie.id});

            console.log("reviewItem response data", response.data);
            reviewItemCtrl.review = {};
        }


        function errorCallback(response) {
            console.log("reviewItem error response", response);
        }

    }

})();