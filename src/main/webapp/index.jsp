<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/d3/3.5.6/d3.min.js" charset="utf-8"></script>
<title>angular</title>
<script type="text/javascript">
	var app = angular.module("Employeedata", []);
	app.controller("employee", function($scope, $http) {
		$scope.Employee = [];
		$scope.EmployeeForm = {
			nbr : -1,
			name : "",
			eid : "",
			email : ""
		};
		$scope.EmployeeForm1= {
				
				eid : "",
				
			};
	

		$scope.submitData = function() {
			var method = "";
			if ($scope.EmployeeForm.nbr == -1) {
				method = 'POST';
			} else {
				method = 'PUT';
			}
			$http({
				method : method,
				url : 'http://localhost:8080/Employee/',
				data : angular.toJson($scope.EmployeeForm),
				headers : {
					'Content-Type' : 'application/json'
				}
			}).then(_sucess, _error);

		};

		$scope.deletedata = function(E) {
			$http({
				method : 'DELETE',
				url : 'http://localhost:8080/Employee/' + E.nbr
			}).then(_sucess, _error);
		};

		$scope.editdata = function(E) {
			$scope.EmployeeForm.nbr = E.nbr;
			$scope.EmployeeForm.name = E.name;
			$scope.EmployeeForm.eid = E.eid;
			$scope.EmployeeForm.email = E.email;
		};
		
		$scope.searchdata=function( flag ) {
			var empId= (flag)?$scope.EmployeeForm1.eid:$scope.EmployeeForm.eid;
			$http({
				method : 'GET',
				url : 'http://localhost:8080/Employee/'+empId,
			}).then(function sucessCallback(response) {
				var len=response.data.length;
				if(len > 0)
				{
					$scope.Employee = response.data;
				}
				else
				{	if(flag == true){
					alert("NO DATA");
					_refreshData();
					_cleardata();
				}
				else
					{
					$scope.Employee = response.data;
					}
					
				}
			}, function throwError(response) {
				console.log(response.statusText);
			});

		}

		_refreshData();
		function _refreshData() {
			$http({
				method : 'GET',
				url : 'http://localhost:8080/Employee/'
			}).then(function sucessCallback(response) {
				$scope.Employee = response.data;
			}, function throwError(response) {
				console.log(response.statusText);
			});

		}

		function _sucess() {
			_refreshData();
			_cleardata();
		}

		function _error() {
			console.log(response.statusText);
		}

		function _cleardata() {

			$scope.EmployeeForm.name = "";
			$scope.EmployeeForm.eid = "";
			$scope.EmployeeForm.email = "";
			$scope.EmployeeForm1.eid = "";
		}
	});
</script>
</head>
<body ng-app="Employeedata" ng-controller="employee">
	<h2>Employee Records</h2>

	<form ng-submit="submitData()">
		<input type="text" ng-model="EmployeeForm.eid"
			placeholder="Employee Id" ng-keyup="searchdata(false)"> <input type="text"
			ng-model="EmployeeForm.name" placeholder="Employee Name"> <input
			type="text" ng-model="EmployeeForm.email"
			placeholder="Employee Email"> <input type="submit" value="Db">
	</form>

	<form ng-submit="searchdata(true)">
		<input type="text" ng-model="EmployeeForm1.eid"
			placeholder="Employee Id">
			<input type="submit" value="Search"/>
		
	</form>
	<table border="1">
		<tr>
			<th style="text-align: center">E_ID</th>
			<th style="text-align: center">Name</th>
			<th style="text-align: center">EMail</th>
			<th>Operation</th>
		</tr>
		<tr ng-repeat="E in Employee" style="padding: 10px">
			<td>{{ E.eid }}</td>
			<td>{{ E.name }}</td>
			<td>{{ E.email }}</td>
			<td>
				<button ng-click="editdata(E)">EDIT</button> |
				<button ng-click="deletedata(E)">DELETE</button>
			</td>
		</tr>
	</table>
</body>
</html>
