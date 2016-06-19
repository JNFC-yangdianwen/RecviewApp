package com.example.yangdianwen.recviewapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import com.example.yangdianwen.recviewapp.Adapter.MyAdapter;
import com.example.yangdianwen.recviewapp.Bean.JsonBean;
import com.example.yangdianwen.recviewapp.HttpUtils.HttpOnline;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
/**
 * 这是主界面
 *
 */
public class MainActivity extends AppCompatActivity  {
    private static final String TAG = "MainActivity";
    private RecyclerView rc_view;
    private List<JsonBean.Results> mArrayList;
    public static String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rc_view = (RecyclerView) findViewById(R.id.rv);
        //recycle设置布局管理器
        rc_view.setLayoutManager(new LinearLayoutManager(this));
        //执行异步任务加载数据
        new MyAsyncTask().execute();
    }
/**
 *   这是一个执行异步任务的内部类继承了AsyncTask类
 *   重写父类的 doInBackground（）方法  获取网络数据，
 *         onPostExecute（）方法，处理网络数据，解析数据
 *
 */
    class MyAsyncTask extends AsyncTask<String, Integer, String> implements MyAdapter.MyItemClickListener {
        private static final String TAG = "MyAsyncTask";
        //获取数据
        @Override
        protected String doInBackground(String... params) {
            //使用http的封装类获取数据
            HttpOnline httpOnline = new HttpOnline();
            String results = httpOnline.getData();
            Log.d(TAG, "doInBackground: " + results);
            return results;
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        // 处理数据
        @Override
        protected void onPostExecute(String json) {
            super.onPostExecute(json);
              Parsegson(json);
            //创建适配器
            MyAdapter dataAapter=new MyAdapter(MainActivity.this,mArrayList);
            rc_view.setAdapter(dataAapter);
            //recycle中的item的点击事件是在其adapter中绑定的,调用adapter类中的setOnItemClickListener方法
            // 实现OnItemClickListener接口
            dataAapter.setOnItemClickListener(this);
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }


    //解析json数据的方法
        private List<JsonBean.Results> Parsegson(String json) {
            mArrayList = new ArrayList<>();
            Gson gson = new Gson();
            //调用fromJson方法解析数据
            JsonBean bean = gson.fromJson(json, JsonBean.class);
            List<JsonBean.Results> data = bean.getResults();
            // 往数据集合中添加数据
            for (int i = 0; i < data.size(); i++) {
                mArrayList.add(data.get(i));
            }
            return  mArrayList;
        }
//        //json解析数据的方法
//        public String parseJson(String json) {
//            try {
//                JSONObject jsonObject = new JSONObject(json);
//                int count = (int) jsonObject.get("count");
//                boolean error = (boolean) jsonObject.get("error");
//                JSONArray results = jsonObject.getJSONArray("results");
//                for (int i = 0; i < results.length(); i++) {
//                    String desc = (String) results.getJSONObject(i).get("desc");
//                    String publishedAt = (String) results.getJSONObject(i).get("publishedAt");
//                    String readability = (String) results.getJSONObject(i).get("readability");
//                    String type = (String) results.getJSONObject(i).get("type");
//                    String url = (String) results.getJSONObject(i).get("url");
//                    String who = (String) results.getJSONObject(i).get("who");
//                }
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//            return null;
//        }
        //每个item的点击事件
        @Override
        public void onItemClick(View view, int postion) {
            for (int i = 0; i <mArrayList.size() ; i++) {
                if (postion==i){
                    url = mArrayList.get(i).getUrl();
                    Intent intent=new Intent(MainActivity.this,Base_WebView.class);
                    startActivity(intent);
                }
            }
            Log.d(TAG, "onItemClick: 。。当前点击了第 "+postion+"个item");
        }
    }
}
