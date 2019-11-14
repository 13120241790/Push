package com.comjia.push;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.comjia.push.library.core.PushClient;
import com.comjia.push.library.core.PushConfig;
import com.comjia.push.library.PushStatusListener;
import com.comjia.push.library.core.PushType;

import java.util.List;


public class App extends Application {

    public static final String MI_APP_ID = "2882303761518212082";
    public static final String MI_APP_KEY = "5671821258082";

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化push推送服务
        if (shouldInit()) {
            PushConfig config = new PushConfig().configMiPush(MI_APP_ID, MI_APP_KEY);
            PushClient.init(this, config, new PushStatusListener() {
                @Override
                public void onRegister(String registerId, PushType pushType) {
                    Log.e(App.class.getSimpleName(), "push type: " + pushType.getName() + " push regId :" + registerId);
                }

                @Override
                public void onError(String error, PushType pushType) {

                }

                @Override
                public void onPushConnected() {

                }
            });

        }

    }

    //判断是否是在主进程初始化
    private boolean shouldInit() {
        ActivityManager am = ((ActivityManager) getSystemService(Context.ACTIVITY_SERVICE));
        List<ActivityManager.RunningAppProcessInfo> processInfos = am.getRunningAppProcesses();
        String mainProcessName = getApplicationInfo().processName;
        int myPid = android.os.Process.myPid();
        for (ActivityManager.RunningAppProcessInfo info : processInfos) {
            if (info.pid == myPid && mainProcessName.equals(info.processName)) {
                return true;
            }
        }
        return false;
    }
}
