package com.song.worterdemo.fragment;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;

import com.song.worterdemo.R;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NumDateFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NumDateFragment extends Fragment {
    View rootView;
    EditText etmonth;
    EditText etday;


    public NumDateFragment() {
    }

    public static NumDateFragment newInstance() {
        NumDateFragment fragment = new NumDateFragment();
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
            rootView=inflater.inflate(R.layout.fragment_num_date, container, false);
        }

        //初始化控件
        etmonth=rootView.findViewById(R.id.et_month);
        etday=rootView.findViewById(R.id.et_day);

        //点击事件
        showDateOnClick(etmonth,etday);

        return rootView;
    }


    @SuppressLint("ClickableViewAccessibility")    //解决Click冲突问题
    protected void showDateOnClick(final EditText month, final EditText day){
        //点击事件传递接触
        month.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    showDatePickDlg(month,day);
                    return true;
                }

                return false;

            }
        });

        day.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    showDatePickDlg(month,day);
                    return true;
                }

                return false;

            }
        });

        //改变日期
        month.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    showDatePickDlg(month,day);
                }

            }
        });

        //改变日期
        day.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    showDatePickDlg(month,day);
                }

            }
        });



    }

    //选择日期,改变文本
    protected void showDatePickDlg(final EditText month,final EditText day) {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                month.setText( (monthOfYear + 1) + " 月" );
                day.setText( dayOfMonth + " 日");
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }


}