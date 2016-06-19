package com.example.yangdianwen.recviewapp.HttpUtils;

import android.net.Uri;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

/**
 * Created by yangdianwen on 16-6-18.
 */
public class HttpOnline {
    private static final String TAG = "HttpOnline";
    private StringBuffer sb = new StringBuffer();;

    public String  getData() {
        String PATH="http://gank.io/api/";
        String SEARCH="search";
        String QUERY="query";
        String LISTVIEW="listview";
        String CATEGORY="category";
        String ANDRIOD="Android";
        String COUNT="count";
        String FIRST="10";
        String PAGE="page";
        String NUM="1";
        Uri uri= Uri.parse(PATH).buildUpon()
                .appendQueryParameter(SEARCH,"search")
                .appendQueryParameter(QUERY,"query")
                .appendQueryParameter(LISTVIEW,"listview")
                .appendQueryParameter(CATEGORY,"category")
                .appendQueryParameter(ANDRIOD,"Android")
                .appendQueryParameter(COUNT,"count")
                .appendQueryParameter(FIRST,"10")
                .appendQueryParameter(PAGE,"page")
                .appendQueryParameter(NUM,"1").build();
   URL url=null;
        try {
            //获取网络地址
            url=new URL("http://gank.io/api/search/query/listview/category/Android/count/10/page/1");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            //设置请求方式
            urlConnection.setRequestMethod("GET");
            //获取io流
            InputStream is = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            //创建缓冲区

            String line = null;
            while ((line= br.readLine()) != null) {
                sb.append(line);
            }

        } catch (Exception e) {
            Log.d(TAG, "getData: 获取数据异常");
        }
        return sb.toString();
    }

}
