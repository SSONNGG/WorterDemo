package com.song.worterdemo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.song.worterdemo.R;
import com.song.worterdemo.adapter.MyRecyclerViewAdapter;
import com.song.worterdemo.entity.ArticleTempo;
import com.song.worterdemo.utils.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

public class ArticleActivity extends AppCompatActivity {

    View rootView;//定义view用来设置fragment的layout

    public RecyclerView recyclerView;//定义RecyclerView

    private List<ArticleTempo> article=new ArrayList<>();   //临时数据
    //自定义recyclerveiw的适配器
    private MyRecyclerViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        //需要切换颜色就调用即可
        StatusBarUtil.setStatusBarMode(this, true, R.color.white);

        initData();

        recyclerView=findViewById(R.id.rv_article_list);
        MyRecyclerViewAdapter adapter=new MyRecyclerViewAdapter(article,ArticleActivity.this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ArticleActivity.this,LinearLayoutManager.VERTICAL,false));
        //设置监听事件
        adapter.setOnItemClickListener(new MyRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, ArticleTempo data) {
                //监听事件业务处理
                Toast.makeText(ArticleActivity.this,"我是item", Toast.LENGTH_SHORT).show();
            }
        });
    }


    /*
     * 模拟数据
     */
    private void initData(){
        for(int i=0;i<20;i++){
            ArticleTempo tempo=new ArticleTempo();
            tempo.setTitleMain("古英语");
            tempo.setTitleSub("公元550-1066年");
            tempo.setArticleContent("由一组北海日耳曼方言发展而成的，这些方言最初是由日耳曼部落在弗里西亚，下萨克森，日德兰和瑞典南部沿海地区所说的。");
            article.add(tempo);
        }
    }


}