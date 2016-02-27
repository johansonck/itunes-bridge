package be.sonck.itunes.bridge.impl.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by johansonck on 25/02/16.
 */
public final class CalendarUtil {

    private static final String DATE_FORMAT = "yyyy-MM-dd";


    public static String formatDate(Calendar calendar) {
        return calendar == null ? null : new SimpleDateFormat(DATE_FORMAT).format(calendar.getTime());
    }
}
