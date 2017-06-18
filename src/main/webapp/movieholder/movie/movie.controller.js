(function () {
    'use strict';

    angular.module('movie')
        .controller('MovieController', MovieController)
    ;

    MovieController.$inject = ['$stateParams', 'CommonService', '$controller'];
    function MovieController($stateParams, CommonService, $controller) {
        var ctrl = this;
        var DesktopNotificationController = $controller('DesktopNotificationController');

        ctrl.movieId = $stateParams.movieId;
        console.log("movieId: " + ctrl.movieId);
        DesktopNotificationController.showNotificationWithIcon("movieId", ctrl.movieId);

        var promise = CommonService.getMovieById(ctrl.movieId);
        promise.then(successCallback, errorCallback);

        function successCallback(response) {
            console.log("movie response data", response.data);
            ctrl.reviews = response.data.reviews;
            //response.data.movie = {};
            console.log("reviews in movieCtrl: ", ctrl.reviews);
            DesktopNotificationController.showNotificationWithIcon("movie response data", response.data);
            ctrl.movie = response.data
        }

        function errorCallback(response) {
            console.log("movie error response", response);
            DesktopNotificationController.showNotificationWithIcon("movie error response", response);
        }

        ctrl.removeFromGUI = function (reviewId) {
            console.log("movie ctrl reviewId: ", reviewId);
            console.log("ctrl.reviews in movie before remove: ", ctrl.reviews);
            ctrl.reviews.splice(reviewId, 1);
            console.log("ctrl.reviews in movie after remove: ", ctrl.reviews);
        }
    }

})();