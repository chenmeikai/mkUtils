package com.chenmeikai.utils.date;

import java.util.Calendar;

public class WeekUtil {

    public static String getTodayWeek() {
        Calendar calendar = Calendar.getInstance();
        int week = calendar.get(Calendar.DAY_OF_WEEK);
        String str = "";
        switch (week) {
        case 1:
            str = "星期天";
            break;
        case 2:
            str = "星期一";
            break;
        case 3:
            str = "星期二";
            break;
        case 4:
            str = "星期三";
            break;
        case 5:
            str = "星期四";
            break;
        case 6:
            str = "星期五";
            break;
        case 7:
            str = "星期六";
            break;
        }

        return str;
    }
    
}
