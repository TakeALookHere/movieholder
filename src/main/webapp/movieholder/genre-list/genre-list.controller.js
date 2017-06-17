(function () {
    'use strict';

    angular.module('genreList')
        .controller('GenreListController', GenreListController)
    ;

    GenreListController.$inject = ['CommonService', '$controller'];
    function GenreListController(CommonService, $controller) {
        var ctrl = this;
        var DesktopNotificationController = $controller('DesktopNotificationController');

        var promise = CommonService.getGenres();
        promise.then(successCallback, errorCallback);

        function successCallback(response) {
            console.log("genre list response data", response.data);
            DesktopNotificationController.showNotificationWithIcon("genre list response data", response.data);
            ctrl.genres = response.data
        }

        function errorCallback(response) {
            console.log("genre list error response", response);
            DesktopNotificationController.showNotificationWithIcon("genre list error response", response);
        }
    }

})();