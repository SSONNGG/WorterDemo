package com.song.worterdemo.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.song.worterdemo.R;
import com.song.worterdemo.adapter.SymbolRecyclerViewAdapter;
import com.song.worterdemo.dao.SymbolDao;
import com.song.worterdemo.db.AlphabetDatabase;
import com.song.worterdemo.db.SymbolDatabase;
import com.song.worterdemo.entity.Symbol;

import java.util.List;


public class SymbolFragment extends Fragment {

    View rootView;
    //不同种类的音标数据
    List<Symbol> symbol;
    //RecyclerView适配器
    SymbolRecyclerViewAdapter adapter;
    RecyclerView recyclerView;
    //数据库配置
    SymbolDatabase database;
    SymbolDao symbolDao;





    public SymbolFragment() {

    }



    public static SymbolFragment newInstance() {
        SymbolFragment fragment = new SymbolFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //数据库操作
        database= SymbolDatabase.getSymbolDatabase(getActivity());
        symbolDao=database.getSymbolDao();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if(rootView==null){
            rootView= inflater.inflate(R.layout.fragment_alphabet, container, false);
        }
        //配置数据和RecylerView
        initRecyclerView();

        return rootView;
    }




    /*
     * 配置数据
     */
    private void initData(String s){
//        symbol=symbolDao.getSymbolByCate(s);
//        Log.e("TAG", "initData: "+symbol.toString() );
    }

    /**
     * 配置RecyclerView
     */
    private void initRecyclerView(){
        //获取-长元音
        recyclerView=rootView.findViewById(R.id.rv_vowels_long);
//        initData("长元音");
        //创建Adapter
        adapter=new SymbolRecyclerViewAdapter(symbol,getActivity());
        //设置Adapter
        recyclerView.setAdapter(adapter);

        //获取-短元音
//        recyclerView=rootView.findViewById(R.id.rv_vowels_short);
//        initData("短元音");
//        //创建Adapter
//        adapter=new SymbolRecyclerViewAdapter(symbol,getActivity());
//        //设置Adapter
//        recyclerView.setAdapter(adapter);

        //设置layoutManager
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),5));
        //设置监听事件
        adapter.setOnItemClickListener(new SymbolRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, Symbol data) {
                //监听事件业务处理
                Toast.makeText(getActivity(),"我是item"+data.getSymbolId(), Toast.LENGTH_SHORT).show();
            }
        });


    }

}