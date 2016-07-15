var employee = angular.module('employee', [ 'ngRoute', 'smart-table' ]);

employee.config(function($routeProvider) {
	$routeProvider

	.when('/employeeList', {
		templateUrl : 'emp-list.html',
		controller : 'EmployeeController'
	})

	// if not find anything, redirect to guest
	.otherwise({
		redirectTo : '/employeeList'
	})

});

employee.controller("EmployeeController",function($scope,$rootScope,$http){
	//alert("controller");
	$scope.data=[];
	$http.get("rest/read/employee/list").success(function(data){
		$scope.employeeList = data;
	}).error(function(error){
		console.log("erro:"+error);
	});
	
});

/*employee.directive('fileModel', [ '$parse', function($parse) {
	return {
		restrict : 'A',
		link : function(scope, element, attrs) {
			var model = $parse(attrs.fileModel);
			var modelSetter = model.assign;

			element.bind('change', function() {
				scope.$apply(function() {
					modelSetter(scope, element[0].files[0]);
				});
			});
		}
	};
} ]);*/

employee.run([ '$rootScope', '$http', '$sce', '$location',
		function($rootScope, $http, $sce, $location) {
		} ]);
