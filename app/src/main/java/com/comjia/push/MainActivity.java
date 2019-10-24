package com.comjia.push;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.common.ApiException;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    String token = HmsInstanceId.getInstance(MainActivity.this).getToken("101221803", "HCM");
//                    Log.e(TAG, "token register: " + token);
//                } catch (ApiException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
    }
}
