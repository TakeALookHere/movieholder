(function () {
    'use strict';

    angular.module('genreList')
        .component('genreList', {
            templateUrl: '/templates/genre-list.html',
            controller: function ($http, $scope) {
                $http.get("/AllGenresServlet").then(successCallback, errorCallback);
                function successCallback(response) {
                    console.log(response.data)
                    $scope.genres = response.data
                }

                function errorCallback(response) {
                    console.log(response)
                }
            }
        })
    ;

})();