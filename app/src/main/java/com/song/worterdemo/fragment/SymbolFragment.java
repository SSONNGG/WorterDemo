package com.song.worterdemo.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.song.worterdemo.R;
import com.song.worterdemo.adapter.SymbolRecyclerViewAdapter;
import com.song.worterdemo.entity.Symbol;
import com.song.worterdemo.viewmodel.SymbolViewModel;

import java.util.List;


public class SymbolFragment extends Fragment {

    View rootView;
    //不同种类的音标数据
    List<Symbol> symbol;
    //RecyclerView适配器
    SymbolRecyclerViewAdapter adapter;
    RecyclerView recyclerView;
    SymbolViewModel viewModel;

    public SymbolFragment() {

    }

    public static SymbolFragment newInstance() {
        SymbolFragment fragment = new SymbolFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //绑定ViewModel
        viewModel=new ViewModelProvider(this).get(SymbolViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(rootView==null){
            rootView= inflater.inflate(R.layout.fragment_symbol, container, false);
        }
        //配置数据和RecylerView
        initRecyclerView();
        return rootView;
    }

    /**
     * 配置RecyclerView
     */
    private void initRecyclerView(){
        //获取-长元音
        recyclerView=rootView.findViewById(R.id.rv_vowels_long);
        adapter=new SymbolRecyclerViewAdapter();
        //设置layoutManager
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),5));
        //设置Adapter
        recyclerView.setAdapter(adapter);
        //配置数据，使用livedata监控数据变化
        viewModel.getSymbolByCate("长元音").observe(getViewLifecycleOwner(), new Observer<List<Symbol>>() {
            @Override
            public void onChanged(List<Symbol> symbols) {
                adapter.setData(symbols);
                adapter.notifyDataSetChanged();
            }
        });
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