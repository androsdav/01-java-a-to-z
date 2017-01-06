package com.adidyk;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RemoveAbuseTest {

    @Test
    public void dropAbuse() throws IOException {
        RemoveAbuse ra = new RemoveAbuse();
        String[] abuse = {"abuse1", "abuse2", "abuse3"};
        String textIn = "down up left abuse1 abuse2 glass cat dog abuse3 friend abuse3 set";
        String result = "down up left glass cat dog friend set ";
        byte[] bufferIn = textIn.getBytes();
        byte[] bufferResult = result.getBytes();
        ByteArrayInputStream bais = new ByteArrayInputStream(bufferIn);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ra.dropAbuses(bais, baos, abuse);
        byte[] bufferOut = baos.toByteArray();
        assertThat(bufferOut, is(bufferResult));
    }

}
