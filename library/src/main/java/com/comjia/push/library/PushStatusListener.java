package com.comjia.push.library;

public interface PushStatusListener {

    void onRegister(String registerId, PushType pushType);

    void onError(String error, PushType pushType);

    void onPushConnected();

}
