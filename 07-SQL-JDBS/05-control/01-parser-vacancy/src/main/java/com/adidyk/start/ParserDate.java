package com.adidyk.start;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;
import static com.adidyk.setup.Constant.*;


/**
 * Class StartUi for create jar file and start program.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 23.10.2018.
 * @version 1.0.
 */
public class ParserDate {

    /**
     *
     */
    private final DateFormat format = new SimpleDateFormat("d MMM yy, HH:mm", new Locale("ru", "RU"));

    /**
     *
     * @return date.
     */
    Date parse(String string) {
        Date date = null;
        if (PATTERN_TODAY.matcher(string).find()) {
            date = this.getTodayDate();
        } else if (PATTERN_YESTERDAY.matcher(string).find()) {
            date = this.getYesterdayDate();
        } else {
            try {
                date = this.format.parse(string);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return date;
    }

    /**
     *
     * @return date.
     */
    private Date getTodayDate() {
        return new Date();
    }

    /**
     *
     * @return yesterday.
     */
    private Date getYesterdayDate() {
        final Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }

    /**
     *
     * @return yesterday.
     */
    Date getYesterdayDate(Date date) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }

    /**
     *
     * @param date - is date.
     * @return
     */
    public String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        return sdf.format(date);
    }

}
