package com.comjia.push.library.platform.jpush;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.comjia.push.library.PushConfig;
import com.comjia.push.library.PushListenerProxy;
import com.comjia.push.library.PushType;
import com.comjia.push.library.platform.IPush;

import cn.jpush.android.api.JPushInterface;

public class JPush implements IPush {
    @Override
    public void register(Context context, PushConfig config) {
//        JPushInterface.setDebugMode(true);
        JPushInterface.init(context);
        if (!TextUtils.isEmpty(JPushInterface.getRegistrationID(context))) {
            PushListenerProxy.onRegister(JPushInterface.getRegistrationID(context), PushType.JPUSH);
        }
    }
}
