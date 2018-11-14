package com.adidyk.start;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

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
    private final Locale locale = new Locale("ru", "RU");

    /**
     *
     */
    private final DateFormat format = new SimpleDateFormat("d MMM yy, HH:mm", this.locale);

    /**
     *
     */
    private Pattern patternToday = Pattern.compile("(?i)\\bсегодня\\b");

    /**
     *
     */
    private Pattern patternYesterday = Pattern.compile("(?i)\\bвчера\\b");



    /**
     *
     * @return date.
     */
    Date parse(String string) {
        Date date = null;
        if (this.patternToday.matcher(string).find()) {
            date = this.getTodayDate();
        } else if (this.patternYesterday.matcher(string).find()) {
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
     * @param date
     * @return
     */
    public String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        return sdf.format(date);
    }

    //***************** parser string to date
    /*
        System.out.println();
    String string = "24 янв 18, 13:28";
    Locale locale = new Locale("ru", "RU");
    //DateFormat format = new SimpleDateFormat("d MMM yy, HH:mm", locale);
    DateFormat format = new SimpleDateFormat("dd MMM yy, HH:mm", locale);
    Date date = null;
        try {
        date = format.parse(string);
    } catch (ParseException e) {
        e.printStackTrace();
    }
        System.out.println(date);
    //***************** may format date
        System.out.println();
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        System.out.println(sdf.format(date));
    //***************** search substring in string use RU
    String string1 = "24 сегодня 18, 13:28";
    Pattern today = Pattern.compile("(?i)\\bсегодня\\b");
    Matcher matcher = today.matcher(string1);
    //Pattern yesterday = Pattern.compile("вчера");
        /*
        if (today.matcher(string).find()) {
            System.out.println("вывод русс");
        }
        */
    /*
        System.out.println(matcher.find());
        System.out.println(matcher.group());
    */

}
