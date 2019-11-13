package com.comjia.push;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.comjia.push.library.core.PushReceiver;
import com.comjia.push.library.core.PushType;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

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
        Log.e(TAG, context.toString());

        if (pushType == PushType.XIAOMI) {
            //小米后台客户端自定义跳转点击通知栏事件
            Intent i = new Intent(context, MainActivity.class);
            i.addFlags(FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
        return false;
    }
}
