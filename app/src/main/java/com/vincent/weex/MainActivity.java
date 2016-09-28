package com.vincent.weex;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import com.taobao.weex.IWXRenderListener;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.WXRenderStrategy;
import com.taobao.weex.utils.WXFileUtils;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.ac_main)
public class MainActivity extends AppCompatActivity {

    @ViewById
    FrameLayout container;
    private WXSDKInstance mWeexInstance;

    @AfterViews
    void afterView(){
        // sdk 实例
        mWeexInstance = new WXSDKInstance(this);
        mWeexInstance.registerRenderListener(new IWXRenderListener() {

            // sdk 将 js 文件渲染成 view 对象回调
            @Override
            public void onViewCreated(WXSDKInstance wxsdkInstance, View view) {
                if (container != null) {
                    container.addView(view); // 添加到界面
                }
            }

            @Override
            public void onRenderSuccess(WXSDKInstance wxsdkInstance, int i, int i1) {

            }

            @Override
            public void onRefreshSuccess(WXSDKInstance wxsdkInstance, int i, int i1) {

            }

            @Override
            public void onException(WXSDKInstance wxsdkInstance, String s, String s1) {

            }
        });
        // 加载 js 文件
        mWeexInstance.render("001",
                WXFileUtils.loadAsset("build.js", this),
                null, null, -1, -1,
                WXRenderStrategy.APPEND_ASYNC);
    }

}
