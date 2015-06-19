# navigation
一个提供调用原生地图的Cordova导航插件
# Installation
cordova plugin https://github.com/shosky/cordova-navigation.git
# Features
1、支持百度地图 or 高德地图  
2、支持android or ios
# Example
Javascript API:  
1、Android(支持传入 当前位置经纬度 与 目的地):
```javascript
    Navigation.do(
    {
    lat:114.001424,
    lon:22.597811,
    name:'深圳湾公园'
    },
    function(message) 
    {
		doSomeing();
	}, function(message) 
	{
		doSomeing();
	});
```
2、IOS(支持传入目的地):
```javascript
    Navigation.do(
    '深圳湾公园',
    function(message) 
    {
	   doSomeing();
	}, function(message) 
	{
	   doSomeing();
	});
```
