package com.comjia.push.library.platform.hms;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.huawei.hms.support.api.push.PushReceiver;

public class HMSReceiver extends PushReceiver {
    private final String TAG = "HMSReceiver";

    @Override
    public void onToken(Context context, String token, Bundle bundle) {
        Log.e(TAG, "token: " + token);
    }

    @Override
    public boolean onPushMsg(Context context, byte[] msg, Bundle bundle) {
        Log.d(TAG, "onPushMsg");//透传接收消息的地方 杀死进程华为手机也收不到不建议使用
        try {
            String content = new String(msg, "UTF-8");
            Log.d(TAG, "onPushMsg content : " + content);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public void onPushState(Context context, boolean pushState) {
        Log.e(TAG, "The current push status： " + (pushState ? "Connected" : "Disconnected"));
    }

    @Override
    public void onEvent(Context context, Event event, Bundle extras) {
        if (Event.NOTIFICATION_OPENED.equals(event)) {

        } else if (Event.NOTIFICATION_CLICK_BTN.equals(event)) {

        }
    }
}
