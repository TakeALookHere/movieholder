(function () {
    'use strict';

    angular.module('reviewList')
        .controller('ReviewListController', ReviewListController)
    ;

    ReviewListController.$inject = ['CommonService', '$controller'];
    function ReviewListController(CommonService, $controller) {
        var ctrl = this;
        var DesktopNotificationController = $controller('DesktopNotificationController');

        ctrl.submitReview = function (review) {
            var movieCtrl = $controller('MovieController');
            ctrl.review.movie = {};
            console.log("movie hidden", movieCtrl.movieId);

            ctrl.review.movie.id = movieCtrl.movieId;
            ctrl.review = review;

            console.log("review from form", ctrl.review);
            var promise = CommonService.addReview(ctrl.review);
            promise.then(successCallbackAdd, errorCallback);
        };

        function successCallbackAdd(response) {
            ctrl.reviews.push(response.data);

            console.log("review response data", response.data);
            DesktopNotificationController.showNotificationWithIcon("review response data", response.data);
            ctrl.review = {};
        }


        function errorCallback(response) {
            console.log("review error response", response);
            DesktopNotificationController.showNotificationWithIcon("review error response", response);
        }

        ctrl.removeReview = function(reviewId, reviewIndex){
            ctrl.reviewId = reviewId;
            ctrl.reviewGUIIndex = reviewIndex;
            var promise = CommonService.removeReview(reviewId);
            promise.then(successCallbackRemove, errorCallback);
        };

        function successCallbackRemove(response) {
            var reviewGUIIndex = ctrl.reviewGUIIndex;
            console.log("review GUI index:", reviewGUIIndex);
            ctrl.reviews.splice(reviewGUIIndex, 1);

            console.log("review response data", response.data);
            DesktopNotificationController.showNotificationWithIcon("review response data", response.data);
            ctrl.review = {};
        }
    }

})();