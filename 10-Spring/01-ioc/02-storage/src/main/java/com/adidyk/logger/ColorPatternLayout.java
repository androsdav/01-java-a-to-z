package com.adidyk.logger;

import org.apache.log4j.Level;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggingEvent;

/**
 * Class of ColorPatternLayout is a Log4J that formats messages using ANSI colors.
 * Each level (DEBUG, INFO, WARN, ERROR, FATAL) has its own color that can customize.
 * To use this file, in your log4j.properties or log4j.xml specify ColorPatternLayout
 * instead of a PatternLayout.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 04.12.2018.
 * @version 1.0.
 */
public class ColorPatternLayout extends PatternLayout {

    /**
     * @param DEFAULT_COLOR_INFO - default color info message.
     */
    private static final String DEFAULT_COLOR_INFO = "\u001B[0;36m";

    /**
     * @param DEFAULT_COLOR_DEBUG - default color debug message.
     */
    private static final String DEFAULT_COLOR_DEBUG = "\u001B[1;36m";

    /**
     * @param DEFAULT_COLOR_WARN - default color warn message.
     */
    private static final String DEFAULT_COLOR_WARN = "\u001B[1;33m";

    /**
     * @param DEFAULT_COLOR_ERROR - default color error message.
     */
    private static final String DEFAULT_COLOR_ERROR = "\u001B[1;31m";

    /**
     * @param DEFAULT_COLOR_FaTAL - default color fatal message.
     */
    private static final String DEFAULT_COLOR_FATAL = "\u001B[1;31m";

    /**
     * @param DEFAULT_COLOR_ALL - default color all message.
     */
    private static final String DEFAULT_COLOR_ALL = "\u001B[0;31m";

    /**
     * @param DEFAULT_COLOR_ - default color message.
     */
    private static final String DEFAULT_COLOR = "\u001B[0;37m";

    /**
     * format - produces a formatted string as specified by the conversion pattern.
     * @param event - link variable to object of class LoggingEvent.
     * @return - returns string format.
     */
    public String format(LoggingEvent event) {
        final StringBuilder buffer = new StringBuilder();
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