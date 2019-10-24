package com.comjia.push.library.core;

public class PushConfig {

    private String miAppId;
    private String miAppKey;


    private PushType mOnlyPush;

    /**
     * 设置指定机型初始化的 Push 平台
     *
     * @param onlyPush PushType
     */
    public PushConfig setOnlyPush(PushType onlyPush) {
        mOnlyPush = onlyPush;
        return this;
    }

    public PushType getOnlyPush() {
        return mOnlyPush;
    }

    public PushConfig configMiPush(String miAppId, String miAppKey) {
        this.miAppId = miAppId;
        this.miAppKey = miAppKey;
        return this;
    }

    public String getMiAppId() {
        return miAppId;
    }

    public String getMiAppKey() {
        return miAppKey;
    }
}
