package com.song.worterdemo.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
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
    SymbolRecyclerViewAdapter adapterLong;
    SymbolRecyclerViewAdapter adapterShort;
    SymbolRecyclerViewAdapter adapterDouble;
    SymbolRecyclerViewAdapter adapterClear;
    SymbolRecyclerViewAdapter adapterTurbid;
    SymbolRecyclerViewAdapter adapterNose;
    SymbolRecyclerViewAdapter adapterTongue;
    SymbolRecyclerViewAdapter adapterSemi;
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
        BindViewVowelsLong();
        BindViewVowelsShort();
        BindViewVowelsDouble();
        BindViewConClear();
        BindViewConTurbid();
        BindViewConNose();
        BindViewConTongue();
        BindViewConSemi();
    }

    private void BindViewVowelsLong(){
        //获取-长元音
        recyclerView=rootView.findViewById(R.id.rv_vowels_long);
        adapterLong=new SymbolRecyclerViewAdapter();
        //设置layoutManager
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),5));
        //设置Adapter
        recyclerView.setAdapter(adapterLong);
        //配置数据，使用livedata监控数据变化
        viewModel.getSymbolByCate("长元音").observe(getViewLifecycleOwner(), new Observer<List<Symbol>>() {
            @Override
            public void onChanged(List<Symbol> symbols) {
                adapterLong.setData(symbols);
                adapterLong.notifyDataSetChanged();
            }
        });
        //设置监听事件
        adapterLong.setOnItemClickListener(new SymbolRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, Symbol data) {
                //监听事件业务处理
                Toast.makeText(getActivity(),"我是item"+data.getSymbolContent(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void BindViewVowelsShort(){
        //获取-短元音
        recyclerView=rootView.findViewById(R.id.rv_vowels_short);
        adapterShort=new SymbolRecyclerViewAdapter();
        //设置layoutManager
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),5));
        //设置Adapter
        recyclerView.setAdapter(adapterShort);
        //配置数据，使用livedata监控数据变化
        viewModel.getSymbolByCate("短元音").observe(getViewLifecycleOwner(), new Observer<List<Symbol>>() {
            @Override
            public void onChanged(List<Symbol> symbols) {
                adapterShort.setData(symbols);
                adapterShort.notifyDataSetChanged();
            }
        });
        //设置监听事件
        adapterShort.setOnItemClickListener(new SymbolRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, Symbol data) {
                //监听事件业务处理
                Toast.makeText(getActivity(),"我是item"+data.getSymbolContent(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void BindViewVowelsDouble(){
        //获取-双元音
        recyclerView=rootView.findViewById(R.id.rv_vowels_double);
        adapterDouble=new SymbolRecyclerViewAdapter();
        //设置layoutManager
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),5));
        //设置Adapter
        recyclerView.setAdapter(adapterDouble);
        //配置数据，使用livedata监控数据变化
        viewModel.getSymbolByCate("双元音").observe(getViewLifecycleOwner(), new Observer<List<Symbol>>() {
            @Override
            public void onChanged(List<Symbol> symbols) {
                adapterDouble.setData(symbols);
                adapterDouble.notifyDataSetChanged();
            }
        });
        //设置监听事件
        adapterDouble.setOnItemClickListener(new SymbolRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, Symbol data) {
                //监听事件业务处理
                Toast.makeText(getActivity(),"我是item"+data.getSymbolContent(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void BindViewConClear(){
        //获取-清辅音
        recyclerView=rootView.findViewById(R.id.rv_consonants_clear);
        adapterClear=new SymbolRecyclerViewAdapter();
        //设置layoutManager
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),5));
        //设置Adapter
        recyclerView.setAdapter(adapterClear);
        //配置数据，使用livedata监控数据变化
        viewModel.getSymbolByCate("清辅音").observe(getViewLifecycleOwner(), new Observer<List<Symbol>>() {
            @Override
            public void onChanged(List<Symbol> symbols) {
                adapterClear.setData(symbols);
                adapterClear.notifyDataSetChanged();

            }
        });
        //设置监听事件
        adapterClear.setOnItemClickListener(new SymbolRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, Symbol data) {
                //监听事件业务处理
                Toast.makeText(getActivity(),"我是item"+data.getSymbolContent(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void BindViewConTurbid(){
        //获取-浊辅音
        recyclerView=rootView.findViewById(R.id.rv_consonants_turbid);
        adapterTurbid=new SymbolRecyclerViewAdapter();
        //设置layoutManager
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),5));
        //设置Adapter
        recyclerView.setAdapter(adapterTurbid);
        //配置数据，使用livedata监控数据变化
        viewModel.getSymbolByCate("浊辅音").observe(getViewLifecycleOwner(), new Observer<List<Symbol>>() {
            @Override
            public void onChanged(List<Symbol> symbols) {
                adapterTurbid.setData(symbols);
                adapterTurbid.notifyDataSetChanged();
            }
        });
        //设置监听事件
        adapterTurbid.setOnItemClickListener(new SymbolRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, Symbol data) {
                //监听事件业务处理
                Toast.makeText(getActivity(),"我是item"+data.getSymbolContent(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void BindViewConNose(){
        //获取-鼻音
        recyclerView=rootView.findViewById(R.id.rv_consonants_nose);
        adapterNose=new SymbolRecyclerViewAdapter();
        //设置layoutManager
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),5));
        //设置Adapter
        recyclerView.setAdapter(adapterNose);
        //配置数据，使用livedata监控数据变化
        viewModel.getSymbolByCate("鼻音").observe(getViewLifecycleOwner(), new Observer<List<Symbol>>() {
            @Override
            public void onChanged(List<Symbol> symbols) {
                adapterNose.setData(symbols);
                adapterNose.notifyDataSetChanged();
            }
        });
        //设置监听事件
        adapterNose.setOnItemClickListener(new SymbolRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, Symbol data) {
                //监听事件业务处理
                Toast.makeText(getActivity(),"我是item"+data.getSymbolContent(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void BindViewConTongue(){
        //获取-舌侧音
        recyclerView=rootView.findViewById(R.id.rv_consonants_tongue);
        adapterTongue=new SymbolRecyclerViewAdapter();
        //设置layoutManager
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),5));
        //设置Adapter
        recyclerView.setAdapter(adapterTongue);
        //配置数据，使用livedata监控数据变化
        viewModel.getSymbolByCate("舌侧音").observe(getViewLifecycleOwner(), new Observer<List<Symbol>>() {
            @Override
            public void onChanged(List<Symbol> symbols) {
                adapterTongue.setData(symbols);
                adapterTongue.notifyDataSetChanged();
            }
        });
        //设置监听事件
        adapterTongue.setOnItemClickListener(new SymbolRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, Symbol data) {
                //监听事件业务处理
                Toast.makeText(getActivity(),"我是item"+data.getSymbolContent(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void BindViewConSemi(){
        //获取-半元音
        recyclerView=rootView.findViewById(R.id.rv_consonants_semi);
        adapterSemi=new SymbolRecyclerViewAdapter();
        //设置layoutManager
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),5));
        //设置Adapter
        recyclerView.setAdapter(adapterSemi);
        //配置数据，使用livedata监控数据变化
        viewModel.getSymbolByCate("半元音").observe(getViewLifecycleOwner(), new Observer<List<Symbol>>() {
            @Override
            public void onChanged(List<Symbol> symbols) {
                adapterSemi.setData(symbols);
                adapterSemi.notifyDataSetChanged();
            }
        });
        //设置监听事件
        adapterSemi.setOnItemClickListener(new SymbolRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, Symbol data) {
                //监听事件业务处理
                Toast.makeText(getActivity(),"我是item"+data.getSymbolContent(), Toast.LENGTH_SHORT).show();
            }
        });
    }



}