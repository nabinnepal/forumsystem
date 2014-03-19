nepForum.controller('forumCtrl', ['$scope', 'forum.Service', function($scope, ForumService) {
    ForumService.query(function(data){
        $scope.forums = data;
    });
}]);


