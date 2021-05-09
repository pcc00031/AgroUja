class AgroController {

}
export const AgroAppModule = angular
        .module("agrouja.app", ['ngMaterial'])
        .controller('AgroApp', function ($scope, $mdDialog) {
            $scope.status = '  ';
            $scope.customFullscreen = false;

            $scope.showAlert = function (ev) {
                $mdDialog.show(
                        $mdDialog.confirm()
                        .parent(angular.element(document.querySelector('#popupContainer')))
                        .clickOutsideToClose(true)
                        .title('Dar de alta nuevo producto')
                        .textContent('¿Está seguro que quiere dar de alta el producto?')
                        .ariaLabel('Alert Dialog Demo')
                        .ok('Sí')
                        .cancel('No')
                        .targetEvent(ev)
                        );
            };
        });
        