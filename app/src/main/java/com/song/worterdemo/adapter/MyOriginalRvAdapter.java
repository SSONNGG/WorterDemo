package com.song.worterdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.song.worterdemo.R;
import com.song.worterdemo.entity.Alphabet;

import java.util.List;

public class MyOriginalRvAdapter extends RecyclerView.Adapter<MyOriginalRvAdapter.MyViewHolder>{

    private List<Alphabet> data;
    private Context context;

    public MyOriginalRvAdapter(List<Alphabet> data, Context context) {
        this.data = data;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView text;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //绑定tv
            text=itemView.findViewById(R.id.tv_original);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //可以选择直接在本位置直接写业务处理
                    //Toast.makeText(context,"点击了xxx",Toast.LENGTH_SHORT).show();
                    //此处回传点击监听事件
                    if(onItemClickListener!=null){
                        onItemClickListener.OnItemClick(v, data.get(getLayoutPosition()));
                    }
                }
            });

        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_original,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return data ==null?0:data.size();
    }


    /**
     * 设置item的监听事件的接口
     */
    public interface OnItemClickListener {
        /**
         * 接口中的点击每一项的实现方法，参数自己定义
         *
         * @param view 点击的item的视图
         * @param data 点击的item的数据
         */
        public void OnItemClick(View view,Alphabet data);
    }

    //需要外部访问，所以需要设置set方法，方便调用
    private MyOriginalRvAdapter.OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(MyOriginalRvAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

}
