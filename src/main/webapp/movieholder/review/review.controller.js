(function () {
    'use strict';

    angular.module('review')
        .controller('ReviewController', ReviewController)
    ;

    ReviewController.$inject = ['CommonService', '$controller', '$state'];
    function ReviewController(CommonService, $controller, $state) {
        var ctrl = this;
        var DesktopNotificationController = $controller('DesktopNotificationController');
        var movieCtrl = $controller('MovieController');
        // //movieCtrl.movie = {};
        // ctrl.reviews = movieCtrl.reviews;
        // console.log("reviews in Review ctrl: ", ctrl.reviews);

        ctrl.submitReview = function (review) {
            var movieCtrl = $controller('MovieController');
            ctrl.review.movie = {};
            console.log("movie hidden", movieCtrl.movieId);

            ctrl.review.movie.id = movieCtrl.movieId;
            ctrl.review = review;

            console.log("review from form", ctrl.review);
            var promise = CommonService.addReview(ctrl.review);
            promise.then(successCallback, errorCallback);
        };

        function successCallback(response) {
            ctrl.reloadRoute();
            console.log("review response data", response.data);
            DesktopNotificationController.showNotificationWithIcon("review response data", response.data);
            ctrl.review = response.data
        }


        function errorCallback(response) {
            console.log("review error response", response);
            DesktopNotificationController.showNotificationWithIcon("review error response", response);
        }

        ctrl.reloadRoute = function () {
            $state.reload();
        };

        ctrl.removeReview = function(reviewId, reviewIndex){
            ctrl.reviewId = reviewId;
            ctrl.reviewGUIIndex = reviewIndex;
            var promise = CommonService.removeReview(reviewId);
            promise.then(successCallbackRemove, errorCallback);
        };

        ctrl.removeFromGUI = function (reviewGUIIndex) {

        };

        function successCallbackRemove(response) {
            var reviewGUIIndex = ctrl.reviewGUIIndex;
            console.log("review GUI index:", reviewGUIIndex);
            movieCtrl.removeFromGUI(reviewGUIIndex);
            console.log("review response data", response.data);
            DesktopNotificationController.showNotificationWithIcon("review response data", response.data);
            ctrl.review = response.data
        }
    }

})();