package com.song.worterdemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.webkit.WebView;
import android.widget.TextView;

import com.song.worterdemo.R;
import com.song.worterdemo.entity.Article;
import com.song.worterdemo.utils.StatusBarUtil;

import org.w3c.dom.Text;

public class ArticleInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_info);
        //需要切换颜色就调用即可
        StatusBarUtil.setStatusBarMode(this, true, R.color.white);

        bindingData();
    }

    private void bindingData() {
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        Article article= (Article) bundle.getSerializable("article");
        TextView title=findViewById(R.id.tv_artlcle_title);
        TextView subTitle=findViewById(R.id.tv_article_subtitle);
        TextView content=findViewById(R.id.tv_article_content);

        title.setText(article.getArticleTitle());
        subTitle.setText(article.getArticleSubTitle());
        content.setText(article.getArticleContent());
    }
}