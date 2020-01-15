package com.ars.testgateway.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Test {

    public static void main(String args[]) throws ParseException {
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd 24:00:00");
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = df.format(day);
        Date date = df.parse(s);
        List<String> dates = new ArrayList<>();
        for (int i = 0; i < 23; i++) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.HOUR, 1);
            date = cal.getTime();
            String s1 = format.format(date);
            dates.add(s1);
        }

        System.out.println(1222);
    }
}
