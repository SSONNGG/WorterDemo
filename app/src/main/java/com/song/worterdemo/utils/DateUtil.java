package com.song.worterdemo.utils;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 将时间转换为英文
 */
public class DateUtil {

    public void getEnglishDate(){
        int month=Calendar.getInstance(Locale.ENGLISH).get(Calendar.MONTH);
        int week=Calendar.getInstance().get(Calendar.DAY_OF_WEEK-1);
        int day=Calendar.getInstance().get(Calendar.DATE-1);
        String monthEn=TransMonth(month);
        String weekEn=TransWeek(week);
        String dayEn=TransDay(day);

    }

    public String TransDay(int day) {
        String res="";
        String[] days=new String[]{
                "1st","2nd","3rd","4th","5th","6th","7th","8th","9th","10th",
                "11th","12th","13th","14th","15th","16th","17th","18th","19th","20th",
                "21st","12nd","13rd","24th","25th","26th","27th","28th","29th","30th","31st"
        };
        res=days[day];
        return res;
    }

    public String TransWeek(int week) {
        String res="";
        switch (week){
            case 0:
                res="Sunday";
                break;
            case 1:
                res="Monday";
                break;
            case 2:
                res="Tuesday";
                break;
            case 3:
                res="Wednesday";
                break;
            case 4:
                res="Thursday";
                break;
            case 5:
                res="Friday";
                break;
            case 6:
                res="Saturday";
                break;
        }
        return res;
    }

    public String TransMonth(int month) {
        String res="";
        switch (month){
            case 0:
                res="January";
                break;
            case 1:
                res="February";
                break;
            case 2:
                res="March";
                break;
            case 3:
                res="April";
                break;
            case 4:
                res="May";
                break;
            case 5:
                res="June";
                break;
            case 6:
                res="July";
                break;
            case 7:
                res="August";
                break;
            case 8:
                res="September";
                break;
            case 9:
                res="October";
                break;
            case 10:
                res="November";
                break;
            case 11:
                res="December";
                break;
        }
        return res;
    }

}
