package com.comjia.push;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.os.Process;

import com.huawei.android.hms.agent.HMSAgent;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.mipush.sdk.Logger;
import com.xiaomi.mipush.sdk.MiPushClient;

import java.util.List;


public class App extends Application {

    public static final String APP_ID = "2882303761518212082";
    public static final String APP_KEY = "5671821258082";
    public static final String TAG = "com.comjia.push";

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化push推送服务
        if (shouldInit()) {
//        HMSAgent.init(this); 华为初始化

//        JPushInterface.setDebugMode(true);
//        JPushInterface.init(this);  极光初始化

            MiPushClient.registerPush(this, APP_ID, APP_KEY);
//            MiPushClient.getRegId(this);
        }
        //打开Log
        LoggerInterface newLogger = new LoggerInterface() {

            @Override
            public void setTag(String tag) {
                // ignore
            }

            @Override
            public void log(String content, Throwable t) {
                Log.d(TAG, content, t);
            }

            @Override
            public void log(String content) {
                Log.d(TAG, content);
            }
        };
        Logger.setLogger(this, newLogger);
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
