(function () {
    'use strict';

    angular.module('movieList')
        .controller('MovieListController', MovieListController)
    ;

    MovieListController.$inject = ['$stateParams', 'CommonService', '$controller'];
    function MovieListController($stateParams, CommonService, $controller) {
        var ctrl = this;
        var promise;
        var DesktopNotificationController = $controller('DesktopNotificationController');

        ctrl.genreId = $stateParams.genreId;
        console.log("genreId: " + ctrl.genreId);
        DesktopNotificationController.showNotificationWithIcon("genreId", ctrl.genreId);

        if(ctrl.genreId == null){
            promise = CommonService.getMovies();
            promise.then(successCallback, errorCallback);

        }else{
            promise = CommonService.getMoviesByGenre(ctrl.genreId);
            promise.then(successCallback, errorCallback);
        }

        function successCallback(response) {
            console.log("movie list response data", response.data);
            DesktopNotificationController.showNotificationWithIcon("movie list response data", response.data);
            ctrl.movies = response.data
        }

        function errorCallback(response) {
            console.log("movie list error response", response);
            DesktopNotificationController.showNotificationWithIcon("movie list error response", response);
        }
    }

})();