(function () {
    'use strict';

    angular.module('common', [])
        .filter('movieNameFilter', FilterMoviesByName)
        .controller('DesktopNotificationController', DesktopNotificationController)

    ;

    function FilterMoviesByName(){
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
    }

    DesktopNotificationController.$inject = ['desktopNotification'];
    function DesktopNotificationController(desktopNotification) {
        var vm = this,
            popup;

        vm.permission = undefined;
        vm.checkiFSupported = checkiFSupported;
        vm.requestPermission = requestPermission;
        vm.showNotification = showNotification;
        vm.showNotificationWithIcon = showNotificationWithIcon;
        vm.showNotificationWithClick = showNotificationWithClick;
        vm.openPopupWindow = openPopupWindow;
        vm.sendMessage = sendMessage;

        activate();

        function showNotificationWithIcon(title, body) {
            var notif = desktopNotification.show(title, {
                icon: '/img/icon.jpg',
                body: body,
                autoClose: vm.autoClose
            });

            if (!notif) {
                alert('Desktop notification is either not supported or blocked.');
            }
        }

        function activate() {
            vm.isSupported = desktopNotification.isSupported();
            vm.permission = desktopNotification.currentPermission();
            vm.autoClose = true;
        }

        function checkiFSupported() {
            vm.isSupported = desktopNotification.isSupported();
            alert('Supported: ' + (vm.isSupported ? 'true' : 'false'));
        }

        function requestPermission() {
            desktopNotification.requestPermission().then(function (permission) {
                vm.permission = permission;
                alert('Permission: true');
            }, function (permission) {
                vm.permission = permission;

                if (vm.permission === 'denied') {
                    alert('Requesting permission again when the user has once blocked' +
                        ' the notification is not possible');
                } else {
                    alert('Permission: false');
                }
            });
        }

        function showNotification(title, body) {
            var notif = desktopNotification.show(title, {
                body: body,
                autoClose: vm.autoClose
            });

            if (!notif) {
                alert('Desktop notification is either not supported or blocked.');
            }
        }

        function showNotificationWithClick() {
            var notif = desktopNotification.show('Notification with Click Event', {
                icon: 'assets/letter-j-32.ico',
                body: 'Click me!',
                autoClose: vm.autoClose,
                onClick: function (event) {
                    alert('Notification is clicked!');
                }
            });

            if (!notif) {
                alert('Desktop notification is either not supported or blocked.');
            }
        }

        function openPopupWindow() {
            if (popup) {
                alert('Popup is already open');
                return;
            }

            popup = window.open('message/message.html');
        }

        function sendMessage(message) {
            if (popup) {
                popup.postMessage(message, '*');
            }
        }
    }

})();