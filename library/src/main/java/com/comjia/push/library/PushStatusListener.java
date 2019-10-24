package com.comjia.push.library;

import com.comjia.push.library.core.PushType;

public interface PushStatusListener {

    void onRegister(String registerId, PushType pushType);

    void onError(String error, PushType pushType);

    void onPushConnected();

}
