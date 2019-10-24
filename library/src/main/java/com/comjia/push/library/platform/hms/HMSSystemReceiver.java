package com.comjia.push.library.platform.hms;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.huawei.hms.support.api.push.PushReceiver;

/**
 * 处理通知栏
 */
public class HMSSystemReceiver extends PushReceiver {
    private final String TAG = "HMSSystemReceiver";

    @Override
    public void onEvent(Context context, Event event, Bundle extras) {
        if (Event.NOTIFICATION_OPENED.equals(event)) {
            Log.e(TAG, "event open");

        } else if (Event.NOTIFICATION_CLICK_BTN.equals(event)) {
            Log.e(TAG, "event click");
        }
    }
}
