package com.github.lifequote.mailman.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

public class CommonUtils {

    private static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public static String generateUid() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replaceAll("[\\-]", "");
    }


    public static String getCurrentTime() {
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }
}
