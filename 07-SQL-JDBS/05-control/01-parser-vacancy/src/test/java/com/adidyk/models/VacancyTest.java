package com.adidyk.models;

import org.junit.Test;
import java.util.Date;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class Vacancy for testing methods of class Vacancy.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 06.12.2018.
 * @version 1.0.
 */
public class VacancyTest {

    /**
     * @param vacancy - link variable to object of class Vacancy.
     */
    private final Vacancy vacancy = new Vacancy("java", "andrey", 10, 100, new Date(1000));

    /**
     * setThemeTest - tests method setTheme of class Vacancy.
     */
    @Test
    public void setThemeTest() {
        this.vacancy.setTheme("java script");
        assertThat("java script", is(this.vacancy.getTheme()));
    }

    /**
     * setAuthorTest - tests method setAuthor of class Vacancy.
     */
    @Test
    public void setAuthorTest() {
        this.vacancy.setAuthor("bob");
        assertThat("bob", is(this.vacancy.getAuthor()));
    }

    /**
     * setAnswersTest - tests method setAnswers of class Vacancy.
     */
    @Test
    public void setAnswersTest() {
        this.vacancy.setAnswers(12);
        assertThat(12, is(this.vacancy.getAnswers()));
    }

    /**
     * setViewersTest - tests method setViewers of class Vacancy.
     */
    @Test
    public void setViewersTest() {
        this.vacancy.setViewers(123);
        assertThat(123, is(this.vacancy.getViewers()));
    }

    /**
     * setDateTest - tests method setDate of class Vacancy.
     */
    @Test
    public void setDateTest() {
        this.vacancy.setDate(new Date(2000));
        assertThat(new Date(2000), is(this.vacancy.getDate()));
    }

    /**
     * getThemeTest - tests methos getTheme of class Vacancy.
     */
    @Test
    public void getThemeTest() {
        assertThat("java", is(this.vacancy.getTheme()));
    }

    /**
     * getAuthorTest - test method getAuthor of class Vacancy.
     */
    @Test
    public void getAuthorTest() {
        assertThat("andrey", is(this.vacancy.getAuthor()));
    }

    /**
     * getAnswersTest - tests method getAnswers of class Vacancy.
     */
    @Test
    public void getAnswersTest() {
        assertThat(10, is(this.vacancy.getAnswers()));
    }

    /**
     * getViewersTest - tests method getViewers of class Vacancy.
     */
    @Test
    public void getViewersTest() {
        assertThat(100, is(this.vacancy.getViewers()));
    }

    /**
     * getDateTest - tests method getDate of class Vacancy.
     */
    @Test
    public void getDateTest() {
        assertThat(new Date(1000), is(this.vacancy.getDate()));
    }

    /**
     * equalsTest - test method equals of class Vacancy.
     */
    @Test
    public void equalsTest() {
        Vacancy vacancyNew = new Vacancy("perl", "andrey", 11, 95, new Date(1000));
        vacancyNew.setTheme("java");
        vacancyNew.setAnswers(10);
        vacancyNew.setViewers(100);
        assertThat(new Vacancy("java", "andrey", 10, 100, new Date(1000)), is(this.vacancy));
    }

}