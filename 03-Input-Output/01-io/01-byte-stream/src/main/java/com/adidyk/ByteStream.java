package com.adidyk;

import java.io.BufferedInputStream;
import java.io.InputStream;

public class ByteStream {

    public boolean isNumber(InputStream in) {
        boolean number = false;

        try (BufferedInputStream bis = new BufferedInputStream(in)) {

            byte[] buffer = new byte[bis.available()];
            bis.read(buffer, 0, buffer.length);
            String str = new String(buffer, "cp1251");
            System.out.println(str);

            //for (byte buff : buffer) {
            //    System.out.print(buff);

            //}



        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return number;
    }
}
