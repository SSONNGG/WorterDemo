package com.song.worterdemo.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.song.worterdemo.R;
import com.song.worterdemo.adapter.WordbookRecyclerViewAdapter;
import com.song.worterdemo.entity.Word;
import com.song.worterdemo.entity.WordAndSymbol;
import com.song.worterdemo.service.AudioService;
import com.song.worterdemo.viewmodel.WordViewModel;

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
        return rootView;
    }

    private void initRecyclerView(){
        recyclerView=rootView.findViewById(R.id.rv_wordbook_list);
        WordViewModel viewModel=new ViewModelProvider(this).get(WordViewModel.class);
        viewModel.getWordBook(1).observe(getActivity(), new Observer<List<WordAndSymbol>>() {
            @Override
            public void onChanged(List<WordAndSymbol> wordAndSymbols) {
                //创建adapter
                WordbookRecyclerViewAdapter adapter=new WordbookRecyclerViewAdapter(wordAndSymbols,getActivity());
                //设置Adapter
                recyclerView.setAdapter(adapter);
                //设置layoutManager
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
                //设置监听
                adapter.setOnItemClickListener(new WordbookRecyclerViewAdapter.OnItemClickListener() {
                    @Override
                    public void OnItemClick(View view, WordAndSymbol data) {
                        showDialog(data);
//                        Intent intent = new Intent(getActivity(), AudioService.class);
//                        intent.putExtra("query", data.getWordContent());
//                        getActivity().startService(intent);
                    }
                });
            }
        });
    }



    private void showDialog(WordAndSymbol data) {
        WordDialogFragment dialogFragment=new WordDialogFragment();
        dialogFragment.setData(data);
        dialogFragment.show(getChildFragmentManager(),null);
    }
}