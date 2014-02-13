nepForum.controller('detailCtrl', ['$scope', 'forum.Service', function($scope, ForumService) {
    ForumService.query(function(data) {
        $scope.forum = data;
    });
}]);