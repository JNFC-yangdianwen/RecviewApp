package com.example.yangdianwen.recviewapp.Task;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.yangdianwen.recviewapp.Adapter.MyAdapter;
import com.example.yangdianwen.recviewapp.Bean.JsonBean;
import com.example.yangdianwen.recviewapp.HttpUtils.HttpOnline;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangdianwen on 16-6-18.
 * 使用异步线程获取网络数据
 */
//public class MyAsyncTask extends AsyncTask<String,Integer,String>{
//    private static final String TAG = "MyAsyncTask";
//    private List<JsonBean.Results> mArrayList;
//    public   static MyAdapter myAdapter;
//    private Context context;
//        public MyAsyncTask(Context context){
//         this.context=context;
//        }
//    //获取数据
//    @Override
//    protected String doInBackground(String... params) {
//        HttpOnline httpOnline=new HttpOnline();
//        String results = httpOnline.getData();
//        Log.d(TAG, "doInBackground: "+results);
//        return results;
//    }
//    // 解析数据
//    @Override
//    protected void onPreExecute() {
//        super.onPreExecute();
//
//    }
//
//    @Override
//    protected void onPostExecute(String json) {
//        super.onPostExecute(json);
//        ArrayList<JsonBean.Results> resultses = Parsegson(json);
//        myAdapter = new MyAdapter(context);
//        myAdapter.addAllData(resultses);
//    }
//
//    @Override
//    protected void onProgressUpdate(Integer... values) {
//        super.onProgressUpdate(values);
//    }
//
//    private ArrayList<JsonBean.Results> Parsegson(String json) {
//        mArrayList = new ArrayList<>();
//        Gson gson = new Gson();
//        //调用fromJson方法解析数据
//        JsonBean bean = gson.fromJson(json, JsonBean.class);
//        List<JsonBean.Results> Results = bean.getResults();
//        // 往数据集合中添加数据
//        for (int i = 0; i < Results.size(); i++) {
//            mArrayList.add(Results.get(i));
//        }
//        return (ArrayList<JsonBean.Results>) mArrayList;
//    }
//}
