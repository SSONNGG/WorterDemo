package com.song.worterdemo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.song.worterdemo.R;
import com.song.worterdemo.adapter.ArticleRecyclerViewAdapter;
import com.song.worterdemo.entity.Article;
import com.song.worterdemo.utils.StatusBarUtil;
import com.song.worterdemo.viewmodel.ArticleViewModel;

import java.util.List;

public class ArticleActivity extends AppCompatActivity {

    public RecyclerView recyclerView;//定义RecyclerView

    //自定义recyclerveiw的适配器
    private ArticleRecyclerViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        //需要切换颜色就调用即可
        StatusBarUtil.setStatusBarMode(this, true, R.color.white);

        bingdingArticle();
    }

    private void bingdingArticle() {
        ArticleViewModel viewModel=new ViewModelProvider(this).get(ArticleViewModel.class);
        viewModel.getAllArticle().observe(this, new Observer<List<Article>>() {
            @Override
            public void onChanged(List<Article> articles) {
                //获取
                recyclerView=findViewById(R.id.rv_article_list);
                ArticleRecyclerViewAdapter adapter=new ArticleRecyclerViewAdapter(articles,ArticleActivity.this);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(ArticleActivity.this,LinearLayoutManager.VERTICAL,false));
                //设置监听事件
                adapter.setOnItemClickListener(new ArticleRecyclerViewAdapter.OnItemClickListener() {
                    @Override
                    public void OnItemClick(View view, Article data) {
                        //监听事件业务处理
                        Intent intent=new Intent(ArticleActivity.this, ArticleInfoActivity.class);
                        Bundle bundle=new Bundle();
                        bundle.putSerializable("article",data);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                });
            }
        });
    }


}