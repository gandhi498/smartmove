var app;
app = angular.module("smartMove",[]);

app.controller("UserDetailsController", function(){

	this.name = user.name;
	this.age = user.age;
	this.deviceId = user.deviceId;
	
});

/* data declaration start*/

var user = {name: "Mr. Smart User", age: "25", deviceId : "000000001"};
