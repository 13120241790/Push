package com.comjia.push.library;

/**
 * push 监听的代理类
 */
public class PushListenerProxy {

    private static PushStatusListener mPushStatusListener;
    private static OnPushActionListener mOnPushActionListener;

    public static void setStatusListener(PushStatusListener pushStatusListener) {
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

    public static void setActionListener(OnPushActionListener onPushActionListener) {
        mOnPushActionListener = onPushActionListener;
    }

    public static void onNotificationReceived(String message, PushType pushType) {
        mOnPushActionListener.onNotificationReceived(message, pushType);
    }

    public static void onNotificationOpened(String message, PushType pushType) {
        mOnPushActionListener.onNotificationOpened(message, pushType);
    }

    /**
     * 部分平台的透传消息
     */
    public static void onTransparentMessage(String message, PushType pushType) {
        mOnPushActionListener.onTransparentMessage(message,pushType);
    }


}
