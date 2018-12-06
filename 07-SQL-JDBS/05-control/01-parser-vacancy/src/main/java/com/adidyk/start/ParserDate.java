package com.adidyk.start;

import org.apache.log4j.Logger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import static com.adidyk.setup.Constant.*;

/**
 * Class ParserDate used to purse date format: "d MMM yy, HH:mm" in russian.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 23.10.2018.
 * @version 1.0.
 */
class ParserDate {

    /**
     * @param logger - link variable to object of class Logger.
     */
    private static final Logger logger = Logger.getLogger(ParserDate.class);

    /**
     * @param format - date format for parsing date-string-format in russian to date-date-format.
     */
    private final DateFormat format = new SimpleDateFormat("d MMM yy, HH:mm", new Locale("ru", "RU"));

    /**
     * parse - parses date-string-format in russian to date-date-format.
     * If date-string-format contains pattern-today-format in russian, then returns today`s date, if
     * date-string-format contains pattern-yesterday-format in russian, then returns yesterday`s date.
     * @return - returns date-date-format from date-string-format or returns today`s date
     * if date-string-format contains pattern-today-format in russian or returns yesterday`s date
     * if date-string-format contains pattern-yesterday-format in russian.
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
            } catch (ParseException ex) {
                logger.error(ex.getMessage(), ex);
            }
        }
        return date;
    }

    /**
     * getTodayDate - returns today`s date.
     * @return - returns today`s date.
     */
    private Date getTodayDate() {
        return new Date();
    }

    /**
     * getYesterdayDate - returns yesterday`s date.
     * @return - returns yesterday`s date.
     */
    private Date getYesterdayDate() {
        final Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }

    /**
     * getYesterdayDate - returns yesterday`s date from input date.
     * @return - returns yesterday`s date from input date.
     */
    Date getYesterdayDate(Date date) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }

}