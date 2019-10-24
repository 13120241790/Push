package com.comjia.push.library;

public interface OnPushActionListener {
    /**
     * 通知栏方式消息抵达
     *
     * @param message
     * @param pushType
     */
    void onNotificationReceived(String message, PushType pushType);

    /**
     * 通知栏方式点击通知栏
     *
     * @param message
     * @param pushType
     */
    void onNotificationOpened(String message, PushType pushType);

    /**
     * 透传消息
     *
     * @param message
     * @param pushType
     */
    void onTransparentMessage(String message, PushType pushType);
}
