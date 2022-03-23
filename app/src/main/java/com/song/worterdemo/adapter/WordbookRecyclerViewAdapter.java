package com.song.worterdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.song.worterdemo.R;
import com.song.worterdemo.entity.Symbol;
import com.song.worterdemo.entity.Word;
import com.song.worterdemo.entity.WordAndSymbol;

import java.util.List;

public class WordbookRecyclerViewAdapter extends RecyclerView.Adapter<WordbookRecyclerViewAdapter.MyViewHolder> {
    List<WordAndSymbol> data;
    private Context context;


    public void setData(List<WordAndSymbol> data){
        this.data=data;
    }


    public WordbookRecyclerViewAdapter(List<WordAndSymbol> data, Context context) {
        this.data = data;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView wordcontent;
        private TextView wordsymbol_uk;
        private TextView wordsymbol_usa;
        private TextView wordsymbol;
        private TextView wordtrans;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            wordcontent=itemView.findViewById(R.id.tv_wordcontent);
            wordsymbol_uk=itemView.findViewById(R.id.tv_wordsymbol_uk);
            wordsymbol_usa=itemView.findViewById(R.id.tv_wordsymbol_usa);
            wordsymbol=itemView.findViewById(R.id.tv_wordsymbol);
            wordtrans=itemView.findViewById(R.id.tv_wordtrans);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
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
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_wordbook,parent,false);
        return new WordbookRecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.wordcontent.setText(data.get(position).getWordContent());
        holder.wordsymbol_uk.setText("英"+data.get(position).getUkSymbol());
        holder.wordsymbol_usa.setText("美"+data.get(position).getUsaSymbol());
        holder.wordsymbol.setText("词源："+data.get(position).getSymbolContent());
        holder.wordtrans.setText(data.get(position).getWordTrans());

    }

    @Override
    public int getItemCount() {
        return data==null?0:data.size();
    }

    /**
     * 设置每个item点击事件的接口
     */

    public interface OnItemClickListener{
        public void OnItemClick(View view,WordAndSymbol data);
    }

    //供给外部访问调用的set方法
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }


}
