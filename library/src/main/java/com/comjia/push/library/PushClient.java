package com.comjia.push.library;

import android.content.Context;
import android.util.Log;

import com.comjia.push.library.common.PushUtils;
import com.comjia.push.library.platform.IPush;
import com.comjia.push.library.platform.hms.HWPush;
import com.comjia.push.library.platform.jpush.JPush;
import com.comjia.push.library.platform.mi.MiPush;

public class PushClient {

    public static final String TAG = PushClient.class.getSimpleName();

    public static void init(Context context, PushConfig config, PushStatusListener pushStatusListener) {
        if (config == null) {
            throw new NullPointerException("Push config is empty~!");
        }
        if (pushStatusListener == null) {
            throw new NullPointerException("Push Status Listener is empty~!");
        }
        PushListenerProxy.setStatusListener(pushStatusListener);
        PushType currentPushType;
        if (config.getOnlyPush() != null) {
            currentPushType = config.getOnlyPush();
        } else {
            currentPushType = PushUtils.getCurrentPushType(context); //获取当前设备品牌
            Log.e(TAG, "current devices type is :" + currentPushType.getName());
        }
        IPush push;
        if (currentPushType == PushType.HUAWEI) {
            PushUtils.checkHwManifestKey(context);
            push = new HWPush();
        } else if (currentPushType == PushType.XIAOMI) {
            push = new MiPush();
        } else {
            PushUtils.checkJManifestKey(context);
            push = new JPush();
        }
        push.register(context, config);
    }

}
