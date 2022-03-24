package com.song.worterdemo.fragment;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.barryzhang.tcontributionsview.TContributionsView;
import com.barryzhang.tcontributionsview.adapter.IntArraysContributionsViewAdapter;
import com.barryzhang.tcontributionsview.adapter.PositionContributionsViewAdapter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.song.worterdemo.R;
import com.song.worterdemo.adapter.MyContributionsViewAdapter;

//我的
public class MyFragment extends Fragment {

    View rootView;
    TContributionsView contributionsView;

    public MyFragment() {
    }

    public static MyFragment newInstance(){
        MyFragment fragment=new MyFragment();
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
            rootView= inflater.inflate(R.layout.fragment_my, container, false);
        }

        //创建请求配置，配置占位符
        RequestOptions requestOptions=new RequestOptions()
                .placeholder(R.drawable.pic_user)
                .error(R.drawable.pic_user)
                .fallback(R.drawable.pic_user)
                .override(80,80);//强制指定加载图片的大小


        ImageView iv=rootView.findViewById(R.id.iv_pic);
        Glide.with(getActivity())
                .load("https://s2.loli.net/2022/03/23/w3ShNOnkuDL59of.jpg")
                .apply(requestOptions)
                .transform(new CircleCrop())
                .into(iv);

        initContributionsView();


        return rootView;
    }

    public void initContributionsView(){
        contributionsView=rootView.findViewById(R.id.cv_signin);
        IntArraysContributionsViewAdapter contributionsViewAdapter=new IntArraysContributionsViewAdapter();
        Integer arrays[][]={
            {0,0,0,0,0,0,0,0,1,1,1,1,1,1},
            {0,0,0,0,0,0,0,0,1,1,1,1,1,1},
            {0,0,0,0,0,0,0,0,1,1,1,1,1,1},
            {0,0,0,0,0,0,0,0,1,1,1,1,1,1},
            {0,0,0,0,0,0,0,0,0,0,1,1,1,1},

        };
        contributionsViewAdapter.setArrays(arrays);
        contributionsView.setAdapter(contributionsViewAdapter);
    }
}
