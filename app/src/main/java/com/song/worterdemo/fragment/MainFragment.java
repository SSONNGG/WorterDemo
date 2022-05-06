package com.song.worterdemo.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.song.worterdemo.R;
import com.song.worterdemo.activity.ArticleActivity;
import com.song.worterdemo.activity.ArticleInfoActivity;
import com.song.worterdemo.adapter.ArticleRecyclerViewAdapter;
import com.song.worterdemo.entity.Article;
import com.song.worterdemo.utils.DateUtil;
import com.song.worterdemo.viewmodel.ArticleViewModel;
import com.song.worterdemo.viewmodel.ReviewQuestionViewModel;

import java.util.Calendar;
import java.util.List;

//本源
public class MainFragment extends Fragment{

    View rootView;//定义view用来设置fragment的layout

    public RecyclerView recyclerView;//定义RecyclerView

    //自定义recyclerveiw的适配器
    private ArticleRecyclerViewAdapter adapter;



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

        bindingTime();
        //对recycleview进行配置
//        initRecyclerView();
        //绑定文章
        bingdingArticle();

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

    private void bingdingArticle() {
        ArticleViewModel viewModel=new ViewModelProvider(this).get(ArticleViewModel.class);
        viewModel.getArticleIndex().observe(getActivity(), new Observer<List<Article>>() {
            @Override
            public void onChanged(List<Article> articles) {
                //获取
                recyclerView=rootView.findViewById(R.id.rv_article);
                //创建Adapter
                adapter=new ArticleRecyclerViewAdapter(articles,getActivity());
                //设置Adapter
                recyclerView.setAdapter(adapter);
                //设置layoutManager
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
                //设置监听事件
                adapter.setOnItemClickListener(new ArticleRecyclerViewAdapter.OnItemClickListener() {
                    @Override
                    public void OnItemClick(View view, Article data) {
                        //监听事件业务处理
                        Intent intent=new Intent(getActivity(), ArticleInfoActivity.class);
                        Bundle bundle=new Bundle();
                        bundle.putSerializable("article",data);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                });
            }
        });
    }

    private void bindingTime() {
        TextView tv_date=rootView.findViewById(R.id.tv_date);
        TextView tv_weekday=rootView.findViewById(R.id.tv_weekday);
        DateUtil util=new DateUtil();
        String date=util.TransMonth(Calendar.getInstance().get(Calendar.MONTH))+" "+util.TransDay(Calendar.getInstance().get(Calendar.DATE)-1);
        String weekday=util.TransWeek(Calendar.getInstance().get(Calendar.DAY_OF_WEEK)-1);
        tv_date.setText(date);
        tv_weekday.setText(weekday);
    }

    /*
     * 配置界面数据
     */
    private void initData(){
        SharedPreferences sp= this.getActivity().getSharedPreferences("SPWorter", Context.MODE_PRIVATE);
        //获取SP文件,默认为1
        int SymbolGroup=sp.getInt("SymbolGroup",1);
        TextView tv_symbol_group=rootView.findViewById(R.id.tv_symbol_group);
        tv_symbol_group.setText("第 "+SymbolGroup+" 组音标");
        //绑定复习单词数据
        TextView tv_general=rootView.findViewById(R.id.tv_general);
        ReviewQuestionViewModel reviewQuestionViewModel=new ViewModelProvider(this).get(ReviewQuestionViewModel.class);
        reviewQuestionViewModel.getReviewQuestion().observe(getActivity(),reviewVOS -> {
            tv_general.setText("共 "+ reviewVOS.size() +" 个单词需要复习");
        });


    }

}
