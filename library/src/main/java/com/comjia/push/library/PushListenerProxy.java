package com.comjia.push.library;

/**
 * push 监听的代理类
 */
public class PushListenerProxy {

    private static PushStatusListener mPushStatusListener;

    public static void setStatusListener(PushStatusListener pushStatusListener) {
        mPushStatusListener = pushStatusListener;
    }


    public static void onRegister(String registerId, PushType pushType) {
        mPushStatusListener.onRegister(registerId, pushType);
    }

}
