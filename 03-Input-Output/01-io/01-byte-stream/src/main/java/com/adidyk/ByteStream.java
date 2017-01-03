package com.adidyk;

import java.io.BufferedInputStream;
import java.io.InputStream;

public class ByteStream {

    public boolean isNumber(InputStream in) {
        boolean number = false;

        try (BufferedInputStream bis = new BufferedInputStream(in)) {

            int stream;
            while((stream = bis.read()) != -1) {
                float str = (float)stream;
                System.out.println(str);
            }

        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return number;
    }
}
