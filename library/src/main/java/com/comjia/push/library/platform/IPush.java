package com.comjia.push.library.platform;

import android.content.Context;

import com.comjia.push.library.core.PushConfig;

public interface IPush {
    void register(Context context, PushConfig config);
}
