package com.lovedudu.cordova;

import java.io.File;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;

public class Navigation extends CordovaPlugin {

    @SuppressLint("NewApi")
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) 
            throws JSONException {
        Activity activity = this.cordova.getActivity();
        if (action.equals("do")) {
            Intent intent = activity.getIntent();
            JSONObject jsonObject = (JSONObject)args.get(0);
            String lat = jsonObject.getString("lat");
            String lon = jsonObject.getString("lon");
            String name = jsonObject.getString("name");
            try {
                 //如果有百度地图
                 if(isInstallByread("com.baidu.BaiduMap")){
                     intent = Intent.getIntent("intent://map/direction?"
                                + "origin=latlng:"+lat+","+lon+"|name:我的位置&"
                                + "destination="+name+""
                                + "&mode=driving"
                                + "&referer=Autohome|GasStation#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end");
                     activity.startActivities(new Intent[]{intent});//启动调用
                 }
                 //如果有高德地图
                 else if(isInstallByread("com.autonavi.minimap"))
                 {
                     intent = Intent.getIntent("androidamap://navi?sourceApplication=HuoYuanTong&poiname="+name+""
                            + "&lat="+lat+"&lon="+lon+"&dev=1&style=2");
                     activity.startActivities(new Intent[]{intent});//启动调用
                 }
                 //如果没有安装导航地图
                 else{
                     callbackContext.error("呜呜~检测到您没安装百度或高德地图,无法进行导航!");
                 }
                } catch (Exception e) {
                     e.printStackTrace();
                }
            return true;
        }
        return false;
    }
    
    /**  
     * 判断是否安装目标应用  
     * @param packageName 目标应用安装后的包名  
     * @return 是否已安装目标应用  
     */  
     private boolean isInstallByread(String packageName) {   
        return new File("/data/data/" + packageName).exists();   
     }

}