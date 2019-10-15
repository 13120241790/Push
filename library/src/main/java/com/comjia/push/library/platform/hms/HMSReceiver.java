package com.comjia.push.library.platform.hms;

import android.content.Context;
import android.os.Bundle;

import com.huawei.hms.support.api.push.PushReceiver;

public class HMSReceiver extends PushReceiver {
    private final String TAG = "HMSReceiver";

    @Override
    public void onToken(Context context, String token, Bundle bundle) {
    }

    @Override
    public boolean onPushMsg(Context context, byte[] msg, Bundle bundle) {


        return false;
    }

    @Override
    public void onPushState(Context context, boolean pushState) {
    }
}
