(function () {
    'use strict';

    angular.module('genreList')
        .component('genreList', {
            templateUrl: '/templates/genre-list.html',
            controller: function ($http, $scope) {
                $http.get("/AllGenresServlet").then(successCallback, errorCallback);
                function successCallback(response, status, config, statusText) {
                    console.log(response.data)
                    $scope.genres = response.data
                }

                function errorCallback(response, status, config, statusText) {
                    console.log(response)
                }
            }
        })
    ;

})();