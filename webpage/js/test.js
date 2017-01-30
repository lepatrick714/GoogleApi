var sys = require('util')
var exec = require('child_process').exec; 
var child;

// executes `pwd`
child = exec("./testing.sh", function (error, stdout, stderr) {
 	console.log(stdout); 
});
