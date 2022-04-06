package com.song.worterdemo.fragment;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.song.worterdemo.R;
import com.song.worterdemo.utils.DateUtil;

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NumDateFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NumDateFragment extends Fragment {
    View rootView;
    EditText etmonth;
    EditText etday;
    EditText etnum;
    TextView tvmonthfirst;
    TextView tvmonthsecond;
    TextView tvdayfirst;
    TextView tvdaysecond;
    TextView tvnumcn;
    TextView tvnumen;
    DateUtil util=new DateUtil();

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


        bindingControls();
        initDate();
        //点击事件
        initNum();
        showDateOnClick(etmonth,etday);
        return rootView;
    }

    private void bindingControls(){
        //初始化控件
        etmonth=rootView.findViewById(R.id.et_month);
        etday=rootView.findViewById(R.id.et_day);
        etnum=rootView.findViewById(R.id.et_num);
        tvnumcn=rootView.findViewById(R.id.tv_num_ch);
        tvnumen=rootView.findViewById(R.id.tv_num_en);
        tvmonthfirst=rootView.findViewById(R.id.tv_month_first);
        tvmonthsecond=rootView.findViewById(R.id.tv_month_second);
        tvdayfirst=rootView.findViewById(R.id.tv_day_first);
        tvdaysecond=rootView.findViewById(R.id.tv_day_second);
    }



    //初始化控件中数据
    private void initDate(){
        //修改控件显示日期为今天
        int month=Calendar.getInstance().get(Calendar.MONTH)+1;
        int day=Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        String monthHint=month+" 月";
        String dayHint=day+" 日";
        etmonth.setHint(monthHint);
        etday.setHint(dayHint);
        //修改翻译部分控件为今天
        tvmonthfirst.setText(util.TransMonth(month-1));
        tvmonthsecond.setText(util.TransMonthofLunar(month-1));
        tvdayfirst.setText(util.TransDayOrdinal(day-1));
        tvdaysecond.setText(util.TransDay(day-1));
    }

    private void initNum(){
            //editText有变化的时候，再响应内容
            etnum.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }
                @Override
                public void afterTextChanged(Editable s) {
                    if(TextUtils.isEmpty(etnum.getText())){
                        tvnumcn.setText("零");
                        tvnumen.setText("Zero");
                    }else if(etnum.getText().toString().length()>9){
                        tvnumcn.setText("Too long");
                        tvnumen.setText("只支持输入九位数");

                    }
                else{
                        int num=Integer.parseInt(etnum.getText().toString());
                        tvnumcn.setText(util.TransNumToCN(num));
                        tvnumen.setText(util.TransNum(num));
                    }
                }
            });
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
                Log.e("TAG", "month: "+monthOfYear+1+"day: "+dayOfMonth );
                //转换为英文，修改相关layout
                tvmonthfirst.setText(util.TransMonth(monthOfYear));
                tvmonthsecond.setText(util.TransMonthofLunar(monthOfYear));
                tvdayfirst.setText(util.TransDayOrdinal(dayOfMonth-1));
                tvdaysecond.setText(util.TransDay(dayOfMonth-1));
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }


}