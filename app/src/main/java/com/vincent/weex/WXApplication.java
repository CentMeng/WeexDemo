package com.vincent.weex;

import android.app.Application;

import com.taobao.weex.InitConfig;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKEngine;
import com.vincent.weex.adapter.ImageAdapter;

/**
 * @author Vincent.M
 * @date 16/9/28
 * @copyright ©2016 孟祥程 All Rights Reserved
 * @desc
 */
public class WXApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //代码中启动Weex RunTime，用于渲染UI
        WXEnvironment.addCustomOptions("appName","TBSample");
        InitConfig config = new InitConfig.Builder()
                .setImgAdapter(new ImageAdapter())
                .build();
        WXSDKEngine.initialize(this, config);
    }
}
