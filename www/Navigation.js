var exec = require('cordova/exec');

var Navigation = {
	do:function(key, successCallback, errorCallback) {
    	exec(successCallback, errorCallback, 'Navigation', 'do', [key])
	}
};

module.exports= Navigation;

