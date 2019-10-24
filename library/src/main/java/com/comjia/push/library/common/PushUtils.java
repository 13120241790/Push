package com.comjia.push.library.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;

import com.comjia.push.library.core.PushType;


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

    /**
     * 检测华为 manifest AppKey 配置
     */
    public static void checkHwManifestKey(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            String appId = String.valueOf(applicationInfo.metaData.getInt("com.huawei.hms.client.appid"));
            Log.e("checkAppkey", "appkey : " + appId);
            if (TextUtils.isEmpty(appId)) {
                throw new NullPointerException("HuaWei manifest.xml appId is empty~!");
            }
            if (appId.contains(" ")) {
                throw new NullPointerException("HuaWei appId contain Space ~!");
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 检测极光 manifest AppKey 配置
     */
    public static void checkJManifestKey(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            String appId = applicationInfo.metaData.getString("JPUSH_APPKEY");
            Log.e("checkAppkey", "appkey : " + appId);
            if (TextUtils.isEmpty(appId)) {
                throw new NullPointerException("JPush manifest.xml appId is empty~!");
            }
            if (appId.contains(" ")) {
                throw new NullPointerException("JPush appId contain Space ~!");
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
