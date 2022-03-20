package com.song.worterdemo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.song.worterdemo.R;
import com.song.worterdemo.entity.Alphabet;
import com.song.worterdemo.fragment.AlphabetDialogFragment;

import java.util.List;

public class AlphabetRecyclerViewAdapter extends RecyclerView.Adapter<AlphabetRecyclerViewAdapter.MyViewHolder> {

    private List<Alphabet> data;

    public void setData(List<Alphabet> data){
        this.data=data;
    }

    /**
     * 填充组件Fragment
     */
    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_original;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //绑定tv
            tv_original=itemView.findViewById(R.id.tv_original);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //
                    if(onItemClickListener!=null){
                        onItemClickListener.OnItemClick(v,data.get(getLayoutPosition()));
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_original,parent,false);
        return new AlphabetRecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlphabetRecyclerViewAdapter.MyViewHolder holder, int position) {
        String alphabet=data.get(position).getAlphabetCapital()+data.get(position).getAlphabetLower();
        holder.tv_original.setText(alphabet);
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
        public void OnItemClick(View view, Alphabet data);
    }

    //需要外部访问，所以需要设置set方法，方便调用
    private AlphabetRecyclerViewAdapter.OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(AlphabetRecyclerViewAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


}
