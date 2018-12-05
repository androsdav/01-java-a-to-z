package com.adidyk.models;

import org.apache.log4j.Level;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggingEvent;

/**
 * ANSIColorLayout is a Log4J Layout that formats messages using ANSI colors.
 *
 * Each level (DEBUG,INFO,WARN) has its own color that you can customize.
 * To use this file, in your log4j.properties or log4j.xml specify ANSIColorLayout
 * instead of a PatternLayout.
 *
 *
 * <b>log4j.properties</b>
 *
 * log4j.appender.A1.layout=org.osuosl.logging.ANSIColorLayout
 * log4j.appender.A1.layout.ConversionPattern=%-5p [%d{MM-dd-yyyy HH:mm:ss}] %c - %m%n
 *
 * log4j.appender.A1.layout.all=\u001B[1;37m
 * log4j.appender.A1.layout.fatal=\u001B[0;31m
 * log4j.appender.A1.layout.error=\u001B[0;31m
 * log4j.appender.A1.layout.warn=\u001B[1;33m
 * log4j.appender.A1.layout.info=\u001B[0;37m
 * log4j.appender.A1.layout.debug=\u001B[0;36m
 * #log4j.appender.A1.layout.reset=\u001B[1;37m
 * log4j.appender.A1.layout.stacktrace=\u001B[0;31m
 * log4j.appender.A1.layout.defaultcolor=\u001B[1;37m
 *
 * @author peter
 *         Date: Nov 30, 2005
 *         Time: 1:24:35 PM
 */
public class ColorPatternLayout extends PatternLayout {

    private static final String DEFAULT_COLOR_ALL = "\u001B[1;37m";
    private static final String DEFAULT_COLOR_FATAL = "\u001B[1;31m";
    private static final String DEFAULT_COLOR_ERROR = "\u001B[1;31m";
    private static final String DEFAULT_COLOR_WARN = "\u001B[1;33m";
    private static final String DEFAULT_COLOR_INFO = "\u001B[0;37m";
    private static final String DEFAULT_COLOR_DEBUG = "\u001B[1;36m";
    //public static final String DEFAULT_COLOR_RESET = "\u001B[1;37m";
    //public static final String DEFAULT_COLOR_STACKTRACE = "\u001B[0;31m";
    private static final String DEFAULT_COLOR = "\u001B[1;37m";


    /**
     *  format - is format.
     * @param event - is event.
     * @return
     */
    public String format(LoggingEvent event) {
        StringBuilder buffer = new StringBuilder();
        switch (event.getLevel().toInt()) {
            case Level.ALL_INT:
                buffer.append(DEFAULT_COLOR_ALL);
                break;
            case Level.FATAL_INT:
                buffer.append(DEFAULT_COLOR_FATAL);
                break;
            case Level.ERROR_INT:
                buffer.append(DEFAULT_COLOR_ERROR);
                break;
            case Level.WARN_INT:
                buffer.append(DEFAULT_COLOR_WARN);
                break;
            case Level.INFO_INT:
                buffer.append(DEFAULT_COLOR_INFO);
                break;
            case Level.DEBUG_INT:
                buffer.append(DEFAULT_COLOR_DEBUG);
                break;
        }
        buffer.append(super.format(event));
        buffer.append(DEFAULT_COLOR);
        return buffer.toString();
    }

}