package com.adidyk;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ByteStreamTest {

    @Test
    public void isNumber() {

        String text = "123678";
        byte[] buffer = text.getBytes();
        ByteArrayInputStream baiStream = new ByteArrayInputStream(buffer);
        ByteStream bs = new ByteStream();
        boolean number = bs.isNumber(baiStream);
        assertThat(number, is(true));
    }

}
