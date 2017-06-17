(function () {
    'use strict';

    angular.module('review')
        .controller('ReviewController', ReviewController)
    ;

    ReviewController.$inject = ['CommonService', '$controller', '$scope', '$state'];
    function ReviewController(CommonService, $controller, $scope, $state) {
        var ctrl = this;
        var DesktopNotificationController = $controller('DesktopNotificationController');

        ctrl.submitReview = function (review) {
            ctrl.review = $scope.review;
            ctrl.review.movie = {};

            ctrl.review.movie.id = $scope.ctrl.movie.id;
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
        }
    }

})();