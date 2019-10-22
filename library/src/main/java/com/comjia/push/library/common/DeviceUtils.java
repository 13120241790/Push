package com.comjia.push.library.common;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DeviceUtils {

    public static String getDeviceManufacturer() {
        //判断是否是MI ROM.
        String line = "";
        BufferedReader input = null;
        String propName = "ro.miui.ui.version.name";
        try {
            java.lang.Process p = Runtime.getRuntime().exec("getprop " + propName);
            input = new BufferedReader(new InputStreamReader(p.getInputStream()), 1024);
            line = input.readLine();
            input.close();
        } catch (IOException ex) {
            Log.e("DeviceUtils", "Unable to read sysprop " + propName);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                }
            }
        }

        if (TextUtils.isEmpty(line)) {
            String manufacturer = Build.MANUFACTURER.replace("-", "_");

            if ("vivo".equals(manufacturer)) {
                manufacturer = manufacturer.toUpperCase();
            }

            return manufacturer;
        } else {
            return "Xiaomi";
        }
    }

    /**
     * 手机机型是否华为
     *
     * @return
     */
    public static boolean isEMUI() {
        return Build.MANUFACTURER.equalsIgnoreCase("HUAWEI");
    }
}
