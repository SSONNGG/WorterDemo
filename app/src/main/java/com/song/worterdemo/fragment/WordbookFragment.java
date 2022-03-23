package com.song.worterdemo.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.song.worterdemo.R;
import com.song.worterdemo.adapter.WordbookRecyclerViewAdapter;
import com.song.worterdemo.entity.Word;
import com.song.worterdemo.entity.WordAndSymbol;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WordbookFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WordbookFragment extends Fragment {
    View rootView;

    public RecyclerView recyclerView;   //定义RecyclerView

    private List<WordAndSymbol> wordAndSymbols=new ArrayList<>();
    //自定义recyclerveiw的适配器
    private WordbookRecyclerViewAdapter adapter;

    public WordbookFragment() {

    }


    public static WordbookFragment newInstance() {
        WordbookFragment fragment = new WordbookFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(rootView==null){
            rootView=inflater.inflate(R.layout.fragment_wordbook, container, false);
        }
        //配置recyclerview
        initRecyclerView();
        initData();
        return rootView;
    }

    private void initRecyclerView(){
        recyclerView=rootView.findViewById(R.id.rv_wordbook_list);
        //创建adapter
        adapter=new WordbookRecyclerViewAdapter(wordAndSymbols,getActivity());
        //设置Adapter
        recyclerView.setAdapter(adapter);
        //设置layoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        //设置监听
        adapter.setOnItemClickListener(new WordbookRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, WordAndSymbol data) {
                Toast.makeText(getActivity(),data.getWordTrans(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initData(){
        for(int i=0;i<20;i++){
            WordAndSymbol wordAndSymbol=new WordAndSymbol();
            wordAndSymbol.setSymbolId(1);
            wordAndSymbol.setWordContent("car");
            wordAndSymbol.setWordTrans("n. 汽车，轿车；（电梯的）梯厢\nn. 汽车，轿车；（电梯的）梯厢");
            wordAndSymbol.setSymbolId(1);
            wordAndSymbol.setSymbolContent("[ɑ:]");
            wordAndSymbol.setUkSymbol("[kɑ:(r)]");
            wordAndSymbol.setUsaSymbol("[kɑ:r]");
            wordAndSymbol.setSymbolGroup(1);
            wordAndSymbol.setIsraw(1);
            wordAndSymbols.add(wordAndSymbol);
        }

    }
}