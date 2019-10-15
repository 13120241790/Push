package com.comjia.push.library;

import android.text.TextUtils;

public enum PushType {
    J_PUSH("J_PUSH"),
    HUAWEI("HW"),
    XIAOMI("MI"),
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
            return J_PUSH;
        }
        for (PushType type : PushType.values()) {
            if (type.getName().equals(name)) {
                return type;
            }
        }
        return J_PUSH;
    }
}
