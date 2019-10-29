package com.comjia.push.library.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public abstract class PushReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

    }

    public abstract boolean onNotificationMessageArrived(Context context, PushType pushType, String notificationMessage);

    public abstract boolean onNotificationMessageClicked(Context context, PushType pushType, String notificationMessage);
}
