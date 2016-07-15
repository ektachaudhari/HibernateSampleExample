/*employee.factory('employeeListFactory', [ '$rootScope', '$http',
		function($rootScope, $http) {
			var employeeListFactory = {};
			
			employeeListFactory.getEmployees = function() {				
				return $http.get("rest/read/employee/list");
			};			
			return employeeListFactory;
		} ]);

employee.controller('EmployeeController', [ '$rootScope', '$scope', '$filter',
		'employeeListFactory',
		function($rootScope, $scope, $filter, employeeListFactory) {
			
			$scope.employeeList = [];
			
			getEmployees();
			
			function getEmployees() {
				employeeListFactory.getEmployees().success(function(data) {
					alert("getEmp1");
					$scope.employeeList = data;
					alert("controller"+data);
				}).error(function(data) {
					alert("Error1"+data.status);
				});
			}

		} ]);*/
/*employee.controller('EmployeeController',function($rootScope,$http){
	alert("controller");
	$http.get("rest/read/employee/list").success(function(data){
		alert("success");
		$scope.employeeList=data;
	}).error(function(data){
		alert("error");
	})
});*/