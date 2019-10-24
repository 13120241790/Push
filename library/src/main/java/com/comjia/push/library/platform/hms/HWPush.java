package com.comjia.push.library.platform.hms;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;

import com.comjia.push.library.PushConfig;
import com.comjia.push.library.platform.IPush;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.push.HmsMessaging;

public class HWPush implements IPush {
    private static final String TAG = HWPush.class.getSimpleName();


    @Override
    public void register(final Context context, PushConfig config) {
//        HmsMessaging.getInstance(context).setAutoInitEnabled(true);
//        HmsMessaging.getInstance(context).isAutoInitEnabled();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String token = HmsInstanceId.getInstance(context).getToken("101221803", "HCM");
                    Log.e(TAG, "token register: " + token);
                } catch (ApiException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        HmsMessaging.getInstance(context).turnOnPush().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(Task<Void> task) {
                if (task.isSuccessful()) {
                    Log.i(TAG, "turnOnPush Complete");
//                    task.getResult();
                } else {
                    Log.e(TAG, "turnOnPush failed: ret=" + task.getException().getMessage());
                }
            }
        });
    }
}
