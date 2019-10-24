package com.comjia.push.library.core;

import com.comjia.push.library.OnPushActionListener;
import com.comjia.push.library.PushStatusListener;

/**
 * push 监听的代理类
 */
public class PushListenerProxy {

    private static PushStatusListener mPushStatusListener;
    private static OnPushActionListener mOnPushActionListener;

    static void setStatusListener(PushStatusListener pushStatusListener) {
        mPushStatusListener = pushStatusListener;
    }

    /**
     * 各平台 registerId 回调
     */
    public static void onRegister(String registerId, PushType pushType) {
        mPushStatusListener.onRegister(registerId, pushType);
    }

    public static void onError(String errorCode, PushType pushType) {
        mPushStatusListener.onError(errorCode, pushType);
    }

    static void setActionListener(OnPushActionListener onPushActionListener) {
        mOnPushActionListener = onPushActionListener;
    }

    /**
     * 通知栏消息抵达
     */
    public static void onNotificationReceived(String message, PushType pushType) {
        mOnPushActionListener.onNotificationReceived(message, pushType);
    }

    /**
     * 通知栏消息打开
     */
    public static void onNotificationOpened(String message, PushType pushType) {
        mOnPushActionListener.onNotificationOpened(message, pushType);
    }

    /**
     * 部分平台的透传消息
     */
    public static void onTransparentMessage(String message, PushType pushType) {
        mOnPushActionListener.onTransparentMessage(message, pushType);
    }


}
