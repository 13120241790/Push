package com.comjia.push;

import android.content.Context;
import android.util.Log;

import com.comjia.push.library.core.PushReceiver;
import com.comjia.push.library.core.PushType;

public class AppPushReceiver extends PushReceiver {

    public static final String TAG = AppPushReceiver.class.getSimpleName();

    @Override
    public boolean onNotificationMessageArrived(Context context, PushType pushType, String notificationMessage) {
        Log.e(TAG, "onNotificationMessageArrived push type ：" + pushType + " message ：" + notificationMessage);
        return false;
    }

    @Override
    public boolean onNotificationMessageClicked(Context context, PushType pushType, String notificationMessage) {
        Log.e(TAG, "onNotificationMessageClicked push type ：" + pushType + " message ：" + notificationMessage);
        return false;
    }
}
