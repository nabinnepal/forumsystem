var nepForum = angular.module('nepForum',['ngResource']);

nepForum.factory('forum.Service', ['$resource', function ($resource){
     return $resource('/forumsystem/allforums');
}]);

