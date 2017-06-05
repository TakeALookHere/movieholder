(function () {
    'use strict';

    angular.module('movieNameFilter')
        .filter('movieNameFilter', function(){
            return function(movies, searchTerm) {
                // If no array is given, exit.
                if (!movies) {
                    return;
                }
                // If no search term exists, return the array unfiltered.
                else if (!searchTerm) {
                    return movies;
                }
                // Otherwise, continue.
                else {
                    // Convert filter text to lower case.
                    var term = searchTerm.toLowerCase();
                    // Return the array and filter it by looking for any occurrences of the search term
                    // in each movie nameRussian or nameNative
                    return movies.filter(function(movie){
                        var termInNameRussian = movie.nameRussian.toLowerCase().indexOf(term) > -1;
                        var termInNameNative = movie.nameNative.toLowerCase().indexOf(term) > -1;
                        return termInNameRussian || termInNameNative;
                    });
                }
            }
        })
    ;

})();