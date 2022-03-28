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

    public static final String ZERO = "zero";
    public static final String NEGATIVE = "negative";
    public static final String SPACE = " ";
    public static final String MILLION = "million";
    public static final String THOUSAND = "thousand";
    public static final String HUNDRED = "hundred";
    public static final String[] INDNUM = {"zero", "one", "two", "three", "four", "five", "six",
            "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen",
            "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    public static final String[] DECNUM = {"twenty", "thirty", "forty", "fifty", "sixty",
            "seventy", "eighty", "ninety"};
    private static final String[] CN_NUM = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
    private static final String[] CN_UNIT = {"", "十", "百", "千", "万", "十", "百", "千", "亿", "十", "百", "千"};
    private static final String CN_NEGATIVE = "负";
    private static final String CN_POINT = "点";


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

    public String TransDayOrdinal(int day){
        String res="";
        String[] days=new String[]{
                "First","Second","Third","Fourth","Fifth","Sixth","Seventh","Eighth","Ninth","Tenth",
                "Eleven","Twelfth","Thirteenth","Fourteenth","Fifteenth","Sixteenth","Seventeenth","Eighteenth","Nineteenth","Twentieth",
                "Twenty-first","Twenty-Second","Twenty-Third","Twenty-fourth","Twenty-fifth","Twenty-sixth","Twenty-seventh","Twenty-eighth","Twenty-nine",
                "Thirtieth","Thirty-first"
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

    public String TransMonthofLunar(int month) {
        String res="";
        switch (month){
            case 0:
                res="First month(of the lunar year)";
                break;
            case 1:
                res="Second month(of the lunar year)";
                break;
            case 2:
                res="Third month(of the lunar year)";
                break;
            case 3:
                res="Fourth month(of the lunar year)";
                break;
            case 4:
                res="Fifth month(of the lunar year)";
                break;
            case 5:
                res="Sixth month(of the lunar year)";
                break;
            case 6:
                res="Seventh month(of the lunar year)";
                break;
            case 7:
                res="Eighth month(of the lunar year)";
                break;
            case 8:
                res="Ninth month(of the lunar year)";
                break;
            case 9:
                res="Tenth month(of the lunar year)";
                break;
            case 10:
                res="Eleventh month(of the lunar year)";
                break;
            case 11:
                res="Twelfth month(of the lunar year)";
                break;
        }
        return res;
    }

    //数字转换为中文
    public String TransNumToCN(int intNum) {
        StringBuffer sb = new StringBuffer();
        boolean isNegative = false;
        if (intNum < 0) {
            isNegative = true;
            intNum *= -1;
        }
        int count = 0;
        while(intNum > 0) {
            sb.insert(0, CN_NUM[intNum % 10] + CN_UNIT[count]);
            intNum = intNum / 10;
            count++;
        }

        if (isNegative)
            sb.insert(0, CN_NEGATIVE);


        return sb.toString().replaceAll("零[千百十]", "零").replaceAll("零+万", "万")
                .replaceAll("零+亿", "亿").replaceAll("亿万", "亿零")
                .replaceAll("零+", "零").replaceAll("零$", "");
    }

    //数字转换英文
    public String TransNum(int i) {
        StringBuilder sb = new StringBuilder();
        if(i == 0) {
            return ZERO;
        }
        if(i < 0) {
            sb.append(NEGATIVE).append(SPACE);
            i *= -1;
        }
        if(i >= 1000000) {
            sb.append(numFormat(i / 1000000)).append(SPACE).append(MILLION).append(SPACE);
            i %= 1000000;

        }
        if(i >= 1000) {
            sb.append(numFormat(i / 1000)).append(SPACE).append(THOUSAND).append(SPACE);

            i %= 1000;
        }
        if(i < 1000){
            sb.append(numFormat(i));
        }
        return (new StringBuilder()).append(Character.toUpperCase(sb.charAt(0))).append(sb.substring(1)).toString();
    }

    // 3位数转英文
    public String numFormat(int i) {
        StringBuilder sb = new StringBuilder();
        if(i >= 100) {
            sb.append(INDNUM[i / 100]).append(SPACE).append(HUNDRED).append(SPACE);
        }
        i %= 100;
        if(i != 0) {
            if(i >= 20) {
                sb.append(DECNUM[i / 10 -2]);
                if(i % 10 != 0) {
                    sb.append("-").append(INDNUM[i % 10]);
                }
            }else {
                sb.append(INDNUM[i]);
            }
        }
        return sb.toString();
    }



}
