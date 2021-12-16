package com.example.utils;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The date formatter
 * -- dd: day in month (number)
 * -- MM: month in year (number)
 * -- yyyy: year
 *
 * See this link for details https://docs.oracle.com/javase/tutorial/i18n/format/simpleDateFormat.html
 */
public class DateUtils {

    private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    // read a date and parse/convert to a date
    public static Date parseDate(String dateStr) throws ParseException {
        return formatter.parse(dateStr);
    }

    // read a date and format/convert to a string
    public static String formatDate(Date date) {
        String result = null;
        if (date != null) {
            result = formatter.format(date);
        }

        return result;
    }
}
