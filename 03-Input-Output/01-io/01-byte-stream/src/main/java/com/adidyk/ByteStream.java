package com.adidyk;

import java.io.BufferedInputStream;
import java.io.InputStream;

public class ByteStream {

    // isNumber - checks that byte stream have only an even number
    public boolean isNumber(InputStream in) {
        boolean numberFlag = false;
        try (BufferedInputStream bis = new BufferedInputStream(in)) {
            byte[] buffer = new byte[bis.available()];
            bis.read(buffer, 0, buffer.length);
            Integer number = Integer.valueOf(new String(buffer, "cp1251"));
            if (number % 2 == 0) {
                numberFlag = true;
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return numberFlag;
    }

}


