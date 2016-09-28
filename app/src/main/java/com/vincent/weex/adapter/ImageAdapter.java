package com.vincent.weex.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.adapter.IWXImgLoaderAdapter;
import com.taobao.weex.common.WXImageStrategy;
import com.taobao.weex.dom.WXImageQuality;
import com.vincent.weex.R;

/**
 * @author Vincent.M
 * @date 16/9/28
 * @copyright ©2016 孟祥程 All Rights Reserved
 * @desc Weex 加载图片
 */
public class ImageAdapter implements IWXImgLoaderAdapter {
    @Override
    public void setImage(final String url, final ImageView view, WXImageQuality quality, WXImageStrategy strategy) {
        WXSDKManager.getInstance().postOnUiThread(new Runnable() {

            @Override
            public void run() {
                Glide.with(WXEnvironment.getApplication()).load(url).placeholder(R.drawable.bg_notus).crossFade().dontAnimate().into(view);
            }
        }, 0);
    }
}
