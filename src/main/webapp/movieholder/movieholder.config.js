(function () {
    'use strict';

    angular.module('MovieHolder')
        .config(RoutesConfig);

    RoutesConfig.$inject = ['$stateProvider', '$urlRouterProvider'];
    function RoutesConfig($stateProvider, $urlRouterProvider) {

        // Redirect to home page if no other URL matches
        $urlRouterProvider.otherwise('/');

        // *** Set up UI states ***
        $stateProvider

        // Home page
            .state('home', {
                url: '/',
                //templateUrl: 'src/html/home.template.html'
            })

            // // Premade list page
            // .state('categories', {
            //     url: '/categories',
            //     templateUrl: 'src/html/categories.template.html',
            //     controller: 'MenuCategoriesController as menu',
            //     resolve: {
            //         categories: ['MenuDataService', function (MenuDataService) {
            //             return MenuDataService.getMenuCategories();
            //         }]
            //     }
            // })
            //
            // .state('categories.items', {
            //     templateUrl: 'src/html/items.template.html',
            //     controller: "ItemDetailController as itemDetail",
            //     params: {
            //         categoryShortName: null
            //     }
            // })
        ;

    }

})();
