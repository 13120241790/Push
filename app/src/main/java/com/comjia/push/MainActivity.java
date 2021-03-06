package com.comjia.push;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.comjia.push.library.OnPushActionListener;
import com.comjia.push.library.core.PushClient;
import com.comjia.push.library.core.PushType;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PushClient.setOnPushActionListener(new OnPushActionListener() {
            @Override
            public void onNotificationReceived(String message, PushType pushType) {
                Log.e(TAG, "Listener onNotificationReceived pushType：" + pushType.getName() + " message：" + message);
            }

            @Override
            public void onNotificationOpened(String message, PushType pushType) {
                Log.e(TAG, "Listener onNotificationOpened pushType：" + pushType.getName() + " message：" + message);
            }

            @Override
            public void onTransparentMessage(String message, PushType pushType) {
                Log.e(TAG, "Listener onTransparentMessage pushType：" + pushType.getName() + " message：" + message);
            }
        });
    }
}
