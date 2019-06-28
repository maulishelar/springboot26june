<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
<title>angular</title>
<script type="text/javascript">
var app=angular.module("Employeedata",[]);
app.controller("employee",function($scope,$http)
{
$scope.Employee=[];
$scope.EmployeeForm={
	nbr : -1,
	name : "",
	eid : "",
	email : ""
};

_refreshData();
function _refreshData()
{
	$http({
	method : 'GET',
	url : 'http://localhost:8080/getEmployee'
	}).then(function sucessCallback(response)
	{
		$scope.Employee=response.data;
	},
	function throwError(response)
	{
		console.log(response.statusText+' hello');
	});
	
}
});
</script>
</head>
<body ng-app="Employeedata" ng-controller="employee">
	<h2>Hello World!</h2>
	<table border="1">
		<tr>
			<th style="text-align: center">Name</th>
			<th style="text-align: center">E_ID</th>
			<th style="text-align: center">EMail</th>
		</tr>
		<tr ng-repeat="E in Employee">
			<td>{{ E.name }}</td>
			<td>{{ E.eid }}</td>
			<td>{{ E.email }}</td>
		</tr>
	</table>
</body>
</html>
