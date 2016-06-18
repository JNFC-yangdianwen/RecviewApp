package com.example.yangdianwen.recviewapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yangdianwen.recviewapp.Bean.JsonBean;
import com.example.yangdianwen.recviewapp.R;

import java.util.List;

/**
 * Created by yangdianwen on 16-6-18.
 * 这是一个数据适配器继承了RecyclerView.Adapter 必须使用ViewHolder进行优化，
 *   在这个类中创建自己的ViewHolder继承RecyclerView.ViewHolder
 * 在此类中要实现recycle中的item的点击事件
 *
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements View.OnClickListener
{
    private List<JsonBean.Results> mData;
    private LayoutInflater mInflater;
    private MyItemClickListener mListener;

    //空参构造器
    public MyAdapter(){

    }
    //constructor适配器的构造器
    public  MyAdapter(Context context,List<JsonBean.Results> list){
       mInflater=LayoutInflater.from(context);
       this.mData=list;
    };
    //添加数据
    public void addAllData(List<JsonBean.Results> list){
       mData.addAll(list);
    }
   //设置item点击事件的方法
    public void setOnItemClickListener(MyItemClickListener listener){
        this.mListener = listener;
    }
    //初始化viewholder，初始化item
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(
                mInflater.inflate(R.layout.item_cardview, parent,
                false),mListener);
        return holder;
    }
    //绑定viewholder时 则去设置Cardview中子控件
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        JsonBean.Results jsonBean=mData.get(position);
           holder.textView.setText(jsonBean.getDesc());
    }
    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onClick(View v) {

    }

    /**
     * 创建一个自己的viewholder类继承自RecyclerView.ViewHolder
     * 初始化Cardview中子控件
     */
    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textView;
        //MyViewHolder的构造器，对cardview中的控件进行初始化，初始化listener
        public MyViewHolder(View itemView,MyItemClickListener listener) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.cd_tv);
            mListener=listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(mListener != null){
                mListener.onItemClick(v,getPosition());
            }
        }
    }
    //item的点击事件接口
    public interface MyItemClickListener {
        public void onItemClick(View view,int postion);
    }
}
