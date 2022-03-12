package com.song.worterdemo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.song.worterdemo.R;
import com.song.worterdemo.activity.ArticleActivity;
import com.song.worterdemo.adapter.MyRecyclerViewAdapter;
import com.song.worterdemo.entity.ArticleTempo;

import java.util.ArrayList;
import java.util.List;

//本源
public class MainFragment extends Fragment{

    View rootView;//定义view用来设置fragment的layout

    public RecyclerView recyclerView;//定义RecyclerView

    private List<ArticleTempo> article=new ArrayList<>();   //临时数据
    //自定义recyclerveiw的适配器
    private MyRecyclerViewAdapter adapter;



    public MainFragment() {
    }

    /**
     * 使用工厂方法创建fragment
     * @return
     */
    public static MainFragment newInstance(){
        MainFragment fragment=new MainFragment();
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(rootView==null){
            rootView= inflater.inflate(R.layout.fragment_main, container, false);
        }
        //对recycleview进行配置
        initRecyclerView();
        //模拟数据
        initData();

        //给LinearLayout绑定点击事件
        LinearLayout layout = rootView.findViewById(R.id.ll_allArticle);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),ArticleActivity.class);
                startActivity(intent);
            }
        });
        return rootView;

    }

    /*
     * 模拟数据
     */
    private void initData(){
        for(int i=0;i<3;i++){
            ArticleTempo tempo=new ArticleTempo();
            tempo.setTitleMain("古英语");
            tempo.setTitleSub("公元550-1066年");
            tempo.setArticleContent("由一组北海日耳曼方言发展而成的，这些方言最初是由日耳曼部落在弗里西亚，下萨克森，日德兰和瑞典南部沿海地区所说的。");
            article.add(tempo);
        }
    }

    /**
     * 对Recyleview进行配置
     */
    private void initRecyclerView(){
        //获取
        recyclerView=rootView.findViewById(R.id.rv_article);
        //创建Adapter
        adapter=new MyRecyclerViewAdapter(article,getActivity());
        //设置Adapter
        recyclerView.setAdapter(adapter);
        //设置layoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        //设置监听事件
        adapter.setOnItemClickListener(new MyRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, ArticleTempo data) {
                //监听事件业务处理
                Toast.makeText(getActivity(),"我是item", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
