package com.song.worterdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.song.worterdemo.R;
import com.song.worterdemo.entity.Article;

import java.util.List;

public class ArticleRecyclerViewAdapter extends RecyclerView.Adapter<ArticleRecyclerViewAdapter.MyViewHolder> {


    private List<Article> data;
    private Context context;

    public ArticleRecyclerViewAdapter(List<Article> data, Context context) {
        this.data = data;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView title_main;
        private TextView title_sub;
        private TextView content;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //绑定tv
            title_main=itemView.findViewById(R.id.tv_title_main);
            title_sub=itemView.findViewById(R.id.tv_title_sub);
            content=itemView.findViewById(R.id.tv_content);
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


    /**
     * 创建ViewHolder方法
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_article,parent,false);
        return new MyViewHolder(view);
    }

    /**
     * 与数据绑定
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull ArticleRecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.title_main.setText(data.get(position).getArticleTitle());
        holder.title_sub.setText(data.get(position).getArticleSubTitle());
        holder.content.setText(data.get(position).getArticleContent());

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
        public void OnItemClick(View view, Article data);
    }

    //需要外部访问，所以需要设置set方法，方便调用
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


}
