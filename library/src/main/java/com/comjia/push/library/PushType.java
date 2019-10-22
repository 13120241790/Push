package com.comjia.push.library;

import android.text.TextUtils;

public enum PushType {
    UNKNOWN("UNKNOWN"),
    HUAWEI("HW"),
    XIAOMI("MI"),
    JPUSH("JPUSH"),
    MEIZU("MEIZU"),
    VIVO("VIVO"),
    OPPO("OPPO");

    private String name;

    PushType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static PushType getType(String name) {
        if (TextUtils.isEmpty(name)) {
            return UNKNOWN;
        }
        for (PushType type : PushType.values()) {
            if (type.getName().equals(name)) {
                return type;
            }
        }
        return UNKNOWN;
    }
}
