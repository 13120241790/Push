package com.comjia.push.library.platform.jpush;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.comjia.push.library.core.PushConfig;
import com.comjia.push.library.core.PushListenerProxy;
import com.comjia.push.library.core.PushType;
import com.comjia.push.library.platform.IPush;

import cn.jpush.android.api.JPushInterface;

import static com.comjia.push.library.common.PushConst.PUSH_TAG;

public class JPush implements IPush {
    @Override
    public void register(Context context, PushConfig config) {
//        JPushInterface.setDebugMode(true);
        Log.e(PUSH_TAG, "register J_PUSH");
        JPushInterface.init(context);
        if (!TextUtils.isEmpty(JPushInterface.getRegistrationID(context))) {
            PushListenerProxy.onRegister(JPushInterface.getRegistrationID(context), PushType.JPUSH);
        }
    }
}
