package com.comjia.push.library.platform.hms;

import android.util.Log;

import com.comjia.push.library.PushListenerProxy;
import com.comjia.push.library.PushType;
import com.huawei.hms.push.HmsMessageService;
import com.huawei.hms.push.RemoteMessage;

public class HMSMessageService extends HmsMessageService {
    public static final String TAG = HMSMessageService.class.getSimpleName();

    @Override
    public void onNewToken(String s) {//每次启动会回调
        Log.e(TAG, "token onNewToken: " + s);
//        PushListenerProxy.onRegister(s, PushType.HUAWEI);
    }
    //透传 ？
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        //TODO 10 秒内同步处理 否则异步
        // TODO(developer): Handle HCM messages here.
        // Check if message contains a data payload.
        if (remoteMessage.getData().length() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
            if (/* Check if data needs to be processed by long running job */ true) {
                // For long-running tasks (10 seconds or more) use Job.
//                scheduleJob();
            } else {
                // Handle message within 10 seconds
//                handleNow();
            }
        }
        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }
        // Also if you intend on generating your own notifications as a result of a received HCM
        // message, here is where that should be initiated. See sendNotification method below.
    }
}
