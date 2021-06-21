package com.AlbertAbuav.DogAndOwner.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static String beautifyDate(Date date) {
        return simpleDateFormat.format(date);
    }

}
