(function () {

    angular.module('app')
        .controller('AllClassroomsController', ['dataService', 'notifier', AllClassroomsController]);

    function AllClassroomsController(dataService, notifier) {

        const vm = this;

        dataService.getAllClassrooms()
            .then(function(classrooms) {
                vm.allClassrooms = classrooms;
            })
            .catch(showError);

        function showError(message) {
            notifier.error(message);
        }

    }

}());