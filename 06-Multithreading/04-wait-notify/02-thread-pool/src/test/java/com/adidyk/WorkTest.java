package com.adidyk;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class WorkTest does testing of class Work.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 13.03.2018.
 * @version 1.0.
 */
public class WorkTest {

    /**
     * equalsTest - test method equals class Work.
     */
    @Test
    public void equalsTest() {
        final Work work1 = new Work(123, "work129");
        final Work work2 = new Work(123, "work129");
        assertThat(work1, is(work2));

    }

}