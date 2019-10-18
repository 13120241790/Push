package com.comjia.push;

import android.app.Application;

import com.huawei.android.hms.agent.HMSAgent;

import cn.jpush.android.api.JPushInterface;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        HMSAgent.init(this);
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
    }
}
