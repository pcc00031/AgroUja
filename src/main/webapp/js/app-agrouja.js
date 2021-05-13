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
            $scope.showConfirm = function (ev) {
                var confirm = $mdDialog.confirm()
                        .title('Would you like to delete your debt?')
                        .textContent('All of the banks have agreed to forgive you your debts.')
                        .ariaLabel('Lucky day')
                        .targetEvent(ev)
                        .ok('Please do it!')
                        .cancel('Sounds like a scam');

                $mdDialog.show(confirm).then(function () {
                    $scope.status = 'You decided to get rid of your debt.';
                }, function () {
                    $scope.status = 'You decided to keep your debt.';
                });
            };
        });
        