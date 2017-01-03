package com.adidyk;

import java.io.BufferedInputStream;
import java.io.InputStream;

public class ByteStream {

    public boolean isNumber(InputStream in) {
        boolean number = false;

        try (BufferedInputStream bis = new BufferedInputStream(in)) {

            byte[] args = new byte[bis.available()];
            bis.read(args, 0, args.length);
            String argsStr = new String(args, "cp1251");
            Float argsFlo = Float.valueOf(argsStr);


            System.out.println(argsStr);
            System.out.println(argsFlo);


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
