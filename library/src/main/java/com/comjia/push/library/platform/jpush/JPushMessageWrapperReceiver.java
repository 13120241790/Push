package com.comjia.push.library.platform.jpush;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.comjia.push.library.common.PushUtils;
import com.comjia.push.library.core.PushListenerProxy;
import com.comjia.push.library.core.PushType;

import cn.jpush.android.api.CmdMessage;
import cn.jpush.android.api.CustomMessage;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.service.JPushMessageReceiver;

import static com.comjia.push.library.common.PushConst.PUSH_LOG_ARRIVED;
import static com.comjia.push.library.common.PushConst.PUSH_LOG_CLICK;
import static com.comjia.push.library.common.PushConst.PUSH_TAG;

/**
 * 测试情况 : 极光进程没有被杀死能收到抵达 和点击通知的事件
 * 杀死进程后无法收到 服务器会缓存这个推送消息 用户再次开启应用时会再次下发此推送
 */
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
        Log.e(PUSH_TAG, PUSH_LOG_CLICK + PushType.JPUSH.getName());
        PushListenerProxy.onNotificationOpened(notificationMessage.toString(), PushType.JPUSH);
        PushUtils.onNotificationMessageOpened(context, PushType.JPUSH, notificationMessage.toString());
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
        Log.e(PUSH_TAG, PUSH_LOG_ARRIVED + PushType.JPUSH.getName());
        PushListenerProxy.onNotificationReceived(notificationMessage.toString(), PushType.JPUSH);
        PushUtils.onNotificationMessageArrived(context, PushType.JPUSH, notificationMessage.toString());
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
        Log.e(PUSH_TAG, "register successful jpush register id: " + s);
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
