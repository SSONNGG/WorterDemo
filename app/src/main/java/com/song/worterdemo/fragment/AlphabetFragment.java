package com.song.worterdemo.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.song.worterdemo.R;
import com.song.worterdemo.adapter.AlphabetRecyclerViewAdapter;
import com.song.worterdemo.dao.AlphabetDao;
import com.song.worterdemo.db.AlphabetDatabase;
import com.song.worterdemo.entity.Alphabet;
import com.song.worterdemo.entity.AlphabetCapAndLow;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AlphabetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AlphabetFragment extends Fragment {

    View rootView;

    //字母数据
    List<AlphabetCapAndLow> alphabetCapAndLow;
    List<Alphabet> alphabets;
    //RecyclerView适配器
    AlphabetRecyclerViewAdapter adapter;
    AlphabetDatabase database;
    AlphabetDao alphabetDao;
    RecyclerView recyclerView;//定义RecyclerView


    public AlphabetFragment() {
    }

    public static AlphabetFragment newInstance() {
        AlphabetFragment fragment = new AlphabetFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //数据库操作
        database=AlphabetDatabase.getAlphabetDatabase(getActivity());
        alphabetDao=database.getAlphabetDao();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if(rootView==null){
            rootView= inflater.inflate(R.layout.fragment_alphabet, container, false);
        }

        //配置recyclerView
        //配置数据
        initData();
        initRecyclerView();
        return rootView;

    }

    /*
     * 配置数据
     */
    private void initData(){
        alphabetCapAndLow=alphabetDao.getAllCapAndLowAlphabet();
        Log.e("TAG", "initData: "+alphabetCapAndLow.toString() );
    }

    /**
     * 对Recyleview进行配置
     */
    private void initRecyclerView(){
        //获取
        recyclerView=rootView.findViewById(R.id.rv_alphabet);
        //创建Adapter
        adapter=new AlphabetRecyclerViewAdapter(alphabetCapAndLow,getActivity());
        //设置Adapter
        recyclerView.setAdapter(adapter);
        //设置layoutManager
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),5));
        //设置监听事件
        adapter.setOnItemClickListener(new AlphabetRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, AlphabetCapAndLow data) {
                //监听事件业务处理
                Toast.makeText(getActivity(),"我是item"+data.getAlphabetId(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}