package com.song.worterdemo.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.song.worterdemo.R;
import com.song.worterdemo.adapter.AlphabetRecyclerViewAdapter;
import com.song.worterdemo.entity.Alphabet;
import com.song.worterdemo.viewmodel.AlphabetViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AlphabetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AlphabetFragment extends Fragment {

    View rootView;
    //RecyclerView适配器
    AlphabetRecyclerViewAdapter adapter;
    //定义RecyclerView
    RecyclerView recyclerView;
    AlphabetViewModel alphabetViewModel;



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
        alphabetViewModel=new ViewModelProvider(this).get(AlphabetViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if(rootView==null){
            rootView= inflater.inflate(R.layout.fragment_alphabet, container, false);
        }
        //配置recyclerView和加载数据
        initRecyclerView();
        return rootView;
    }

    /**
     * 对Recyleview进行配置
     */
    private void initRecyclerView(){
        //获取
        recyclerView=rootView.findViewById(R.id.rv_alphabet);
        adapter=new AlphabetRecyclerViewAdapter();
        //设置layoutManager
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),5));
        //设置Adapter
        recyclerView.setAdapter(adapter);
        //配置数据,使用livedata监控数据变化
        alphabetViewModel.getAlphabetLive().observe(getViewLifecycleOwner(), new Observer<List<Alphabet>>() {
            @Override
            public void onChanged(List<Alphabet> alphabets) {
                adapter.setData(alphabets);
                adapter.notifyDataSetChanged();
            }
        });
        //设置监听事件
        adapter.setOnItemClickListener(new AlphabetRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, Alphabet data) {
                //监听事件业务处理
                showDialog(data);
            }
        });
    }

    private void showDialog(Alphabet data){
        AlphabetDialogFragment alphabetDialogFragment=new AlphabetDialogFragment();
        alphabetDialogFragment.setData(data);
        alphabetDialogFragment.show(getChildFragmentManager(),null);
    }

}