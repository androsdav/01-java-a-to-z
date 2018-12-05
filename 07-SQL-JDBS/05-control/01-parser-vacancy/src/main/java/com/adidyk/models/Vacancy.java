package com.adidyk.models;

import java.util.Date;

/**
 * Class Vacancy for create object vacancy with param: theme, author, answers, viewers, date.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 23.10.2018.
 * @version 1.0.
 */
public class Vacancy {

    /**
     * @param theme - theme vacancy.
     */
    private String theme;

    /**
     * @param author - author vacancy.
     */
    private String author;

    /**
     * @param answers - number of answers to vacancy.
     */
    private int answers;

    /**
     * @param viewers - number of viewers to vacancy.
     */
    private int viewers;

    /**
     * @param date - date create vacancy.
     */
    private Date date;

    /**
     * Vacancy - constructor.
     * @param theme - theme vacancy.
     * @param author - author vacancy.
     * @param answers - number of answers to vacancy.
     * @param viewers - number of viewers to vacancy.
     * @param date - date create vacancy.
     */
    public Vacancy(String theme, String author, int answers, int viewers, Date date) {
        this.theme = theme;
        this.author = author;
        this.answers = answers;
        this.viewers = viewers;
        this.date = date;
    }

    /**
     * setTheme - sets theme vacancy.
     * @param theme - theme vacancy.
     */
    public void setTheme(String theme) {
        this.theme = theme;
    }

    /**
     * setAuthor - sets author vacancy.
     * @param author - author vacancy.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * setAnswers - sets number of answers to vacancy.
     * @param answers - number of answers to vacancy.
     */
    public void setAnswers(int answers) {
        this.answers = answers;
    }

    /**
     * setViewers - sets number of viewers to vacancy.
     * @param viewers - number of viewers to vacancy.
     */
    public void setViewers(int viewers) {
        this.viewers = viewers;
    }

    /**
     * setDate - sets date create vacancy.
     * @param date - date create vacancy.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * getTheme - returns theme vacancy.
     * @return - returns theme vacancy.
     */
    public String getTheme() {
        return theme;
    }

    /**
     * getAuthor - returns author vacancy.
     * @return - returns author vacancy.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * getAnswers - returns number of answers to vacancy.
     * @return - returns number of answers to vacancy.
     */
    public int getAnswers() {
        return answers;
    }

    /**
     * getViewers - returns number of viewers to vacancy.
     * @return - returns number of viewers to vacancy.
     */
    public int getViewers() {
        return viewers;
    }

    /**
     * getDate - returns date create vacancy.
     * @return - returns date create vacancy.
     */
    public Date getDate() {
        return date;
    }

    /**
     * equals - returns boolean result.
     * @param obj - object of class Vacancy.
     * @return - returns boolean result "true" if answers, viewers, theme, author, date of vacancy is same,
     * and returns "false" - isn`t same.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Vacancy)) {
            return false;
        }
        Vacancy vacancy = (Vacancy) obj;
        if (this.answers != vacancy.answers) {
            return false;
        }
        if (this.viewers != vacancy.viewers) {
            return false;
        }
        if (!this.theme.equals(vacancy.theme)) {
            return false;
        }
        if (!this.author.equals(vacancy.author)) {
            return false;
        }
        return this.date.equals(vacancy.date);
    }

    /**
     * hashCode - returns hashCode for vacancy.
     * @return - returns hashCode for vacancy.
     */
    @Override
    public int hashCode() {
        int result = this.theme.hashCode();
        result = 31 * result + this.author.hashCode();
        result = 31 * result + this.answers;
        result = 31 * result + this.viewers;
        result = 31 * result + this.date.hashCode();
        return result;
    }

    /**
     * toString - returns string format.
     * @return - returns all information for vacancy.
     */
    @Override
    public String toString() {
        return String.format("%s%s%s%s%s%s%s%s%s%s%s%s",
                "Vacancy{", "theme=", this.theme, ", author=", this.author,
                ", answers=", this.answers, ", viewers=", this.viewers, ", date=", this.date, '}');
    }

}