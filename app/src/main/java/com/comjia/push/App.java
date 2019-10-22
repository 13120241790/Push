package com.comjia.push;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;

import com.comjia.push.library.PushClient;
import com.comjia.push.library.PushConfig;
import com.comjia.push.library.PushType;

import java.util.List;


public class App extends Application {

    public static final String MI_APP_ID = "2882303761518212082";
    public static final String MI_APP_KEY = "5671821258082";

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化push推送服务
        if (shouldInit()) {
            new PushConfig().setOnlyPush(PushType.HUAWEI);
            PushClient.init(this, new PushConfig().configMiPush(MI_APP_ID, MI_APP_KEY));
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
