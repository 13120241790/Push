package com.comjia.push.library.common;

import android.content.Context;

import com.comjia.push.library.PushType;


public class PushUtils {

    public static PushType getCurrentPushType(Context context) {
        String os = DeviceUtils.getDeviceManufacturer();
        if (os.contains("Xiaomi")) {
            return PushType.XIAOMI;
        } else if (os.contains("HUAWEI")) {
            return PushType.HUAWEI;
        } else if (os.contains("Meizu")) {
            return PushType.MEIZU;
        } else if (os.toLowerCase().contains("oppo")) {
            return PushType.OPPO;
        } else if (os.contains("VIVO")) {
            return PushType.VIVO;
        }
        return PushType.UNKNOWN;
    }
}
