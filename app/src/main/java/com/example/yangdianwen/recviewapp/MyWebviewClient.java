package com.example.yangdianwen.recviewapp;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by yangdianwen on 16-6-18.
 * 这是一个加载网页的基类，继承WebViewClient
 */
public class MyWebviewClient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return  true;
    }
}
