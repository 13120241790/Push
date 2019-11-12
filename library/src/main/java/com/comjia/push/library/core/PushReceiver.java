package com.comjia.push.library.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.comjia.push.library.common.PushConst;

public abstract class PushReceiver extends BroadcastReceiver {

    public static final String TAG = PushReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive.action:" + intent.getAction());

        if (intent.getAction() == null) {
            Log.e(TAG, "the intent action is null, return directly. ");
            return;
        }

        String message = intent.getStringExtra(PushConst.MESSAGE);
        if (message == null) {
            Log.e(TAG, "message is null. Return directly!");
            return;
        }
        PushType pushType = PushType.getType(intent.getStringExtra(PushConst.PUSH_TYPE));

        if (intent.getAction().equals(PushConst.ACTION_NOTIFICATION_MESSAGE_ARRIVED)) {
            if (!onNotificationMessageArrived(context, pushType, message)) {
                //默认处理
            }
        } else if (intent.getAction().equals(PushConst.ACTION_NOTIFICATION_MESSAGE_CLICKED)) {
            if (!onNotificationMessageClicked(context, pushType, message)) {
                //默认处理
            }
        }
    }

    public abstract boolean onNotificationMessageArrived(Context context, PushType pushType, String notificationMessage);

    public abstract boolean onNotificationMessageClicked(Context context, PushType pushType, String notificationMessage);
}
