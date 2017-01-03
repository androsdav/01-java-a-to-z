package com.adidyk;

import java.io.BufferedInputStream;
import java.io.InputStream;

import static java.lang.Math.IEEEremainder;

public class ByteStream {

    public boolean isNumber(InputStream in) {
        boolean numberFlag = false;

        try (BufferedInputStream bis = new BufferedInputStream(in)) {

            byte[] buffer = new byte[bis.available()];
            bis.read(buffer, 0, buffer.length);
            Float number = Float.valueOf(new String(buffer, "cp1251"));
            double remainder = IEEEremainder(number, 2.0);
            if (remainder == 0) {
                numberFlag = true;
            }
            System.out.println(number);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return numberFlag;
    }
}
