package com.comjia.push.library.platform.jpush;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.comjia.push.library.core.PushListenerProxy;
import com.comjia.push.library.core.PushType;

import cn.jpush.android.api.CmdMessage;
import cn.jpush.android.api.CustomMessage;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.service.JPushMessageReceiver;

public class JPushMessageWrapperReceiver extends JPushMessageReceiver {

    public static final String TAG = "JPushMessageReceiver";

    //自定义消息走 on message 理解为透传
    @Override
    public void onMessage(Context context, CustomMessage customMessage) {
        PushListenerProxy.onTransparentMessage(customMessage.toString(), PushType.JPUSH);
        Log.e(TAG, "onMessage : " + customMessage.message);
        super.onMessage(context, customMessage);
    }

    @Override
    public void onNotifyMessageOpened(Context context, NotificationMessage notificationMessage) {
        Log.e("PushMessage", "click message string : " + notificationMessage.toString());
        PushListenerProxy.onNotificationOpened(notificationMessage.toString(), PushType.JPUSH);
        Log.e(TAG, "onNotifyMessageOpened : " + notificationMessage.notificationContent);
        super.onNotifyMessageOpened(context, notificationMessage);
    }


    /**
     * 3、新功能
     * <p>
     * Android SDK v3.1.7 开始直接支持点击跳转到指定页面
     * <p>
     * 需要在 REST API 发消息的时候设置 Notification-Android-intent 字段
     * <p>
     * https://community.jiguang.cn/t/topic/39120/6
     * <p>
     * 合并通知有坑
     */


    @Override
    public void onNotifyMessageArrived(Context context, NotificationMessage notificationMessage) {
        Log.e("PushMessage", "arrived message string : " + notificationMessage.toString());
        Log.e(TAG, "onNotifyMessageArrived : " + notificationMessage.notificationContent);
        PushListenerProxy.onNotificationReceived(notificationMessage.toString(), PushType.JPUSH);
        super.onNotifyMessageArrived(context, notificationMessage);
    }

    @Override
    public void onNotifyMessageDismiss(Context context, NotificationMessage notificationMessage) {
        Log.e(TAG, "onNotifyMessageDismiss : " + notificationMessage.notificationContent);
        super.onNotifyMessageDismiss(context, notificationMessage);
    }

    @Override
    public void onRegister(Context context, String s) {
        // registrationID 仅仅在第一次初始化的时候才会有这个广播，以后要获取需要主动调用 JPushInterface.getRegistrationID
        PushListenerProxy.onRegister(s, PushType.JPUSH);
        super.onRegister(context, s);
    }

    @Override
    public void onConnected(Context context, boolean b) {
        Log.e(TAG, "onConnected : " + b);
        super.onConnected(context, b);
    }

    @Override
    public void onCommandResult(Context context, CmdMessage cmdMessage) {
        Log.e(TAG, "onCommandResult : " + cmdMessage);
        super.onCommandResult(context, cmdMessage);
    }

    @Override
    public void onMultiActionClicked(Context context, Intent intent) {
        Log.e(TAG, "onMultiActionClicked");
        super.onMultiActionClicked(context, intent);
    }
}
