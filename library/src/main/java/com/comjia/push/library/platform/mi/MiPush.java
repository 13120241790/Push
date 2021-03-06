package com.comjia.push.library.platform.mi;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.comjia.push.library.core.PushConfig;
import com.comjia.push.library.platform.IPush;
import com.xiaomi.mipush.sdk.MiPushClient;

import static com.comjia.push.library.common.PushConst.PUSH_TAG;

public class MiPush implements IPush {
    @Override
    public void register(Context context, PushConfig config) {
        if (TextUtils.isEmpty(config.getMiAppId()) || TextUtils.isEmpty(config.getMiAppKey())) {
            throw new IllegalArgumentException("Mi key or id is empty~!");
        }
        Log.e(PUSH_TAG, "register MI");
        MiPushClient.registerPush(context, config.getMiAppId(), config.getMiAppKey());
        //打开Log
//        LoggerInterface newLogger = new LoggerInterface() {
//
//            @Override
//            public void setTag(String tag) {
//                // ignore
//            }
//
//            @Override
//            public void log(String content, Throwable t) {
//                Log.d(TAG, content, t);
//            }
//
//            @Override
//            public void log(String content) {
//                Log.d(TAG, content);
//            }
//        };
//        Logger.setLogger(context, newLogger);
    }
}
