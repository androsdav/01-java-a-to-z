package com.adidyk.models;

/**
 * Class StartUi for create jar file and start program.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 23.10.2018.
 * @version 1.0.
 */
public class Vacancy {

    /**
     * @param theme - theme.
     */
    private String theme;

    /**
     * @param author - author.
     */
    private String author;

    /**
     * @param answers - answers.
     */
    private int answers;

    /**
     * @param viewers - viewers.
     */
    private int viewers;

    /**
     * @param date - date.
     */
    private String date;

    /**
     * Vacancy - constructor.
     * @param theme - theme vacancy.
     * @param author - author vacancy.
     * @param answers - number of answers for vacancy.
     * @param viewers - viewers.
     * @param date - date for create theme.
     */
    public Vacancy(String theme, String author, int answers, int viewers, String date) {
        this.theme = theme;
        this.author = author;
        this.answers = answers;
        this.viewers = viewers;
        this.date = date;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getAnswers() {
        return answers;
    }

    public void setAnswers(int answers) {
        this.answers = answers;
    }

    public int getViewers() {
        return viewers;
    }

    public void setViewers(int viewers) {
        this.viewers = viewers;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    /**
     *
     * @param obj - obj.
     * @return - return true or false.
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
     * hashCode - hashCode.
     * @return - returns ?.
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
     * toString - to string.
     * @return - string format.
     */
    @Override
    public String toString() {
        return "Vacancy{" +
                "theme='" + this.theme + '\'' +
                ", author='" + this.author + '\'' +
                ", answers=" + this.answers +
                ", viewers=" + this.viewers +
                ", date='" + this.date + '\'' +
                '}';
    }
}