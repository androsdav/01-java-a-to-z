package com.adidyk;

import java.io.File;
import java.io.FilenameFilter;

public class Filter implements FilenameFilter {

   // public static FilenameFilter filter;

   // public static void init() {
   //     filter = new FilenameFilter() {
   //         @Override
   //         public boolean accept(File dir, String name) {

   //             if (name.equals("*dir")) {
   //                 return (new File(dir, name).isDirectory());
   //             } else {
   //                 return false;
   //             }
   //          //   if ((dir.isFile() && name.equals("pom.txt")) || dir.isDirectory()) {
             //       return true;
             //   } else {
             //       return false;
             //   }
    //        }
      //  };
    //}

    String mask;

    Filter(String mask) {
        this.mask = mask;
    }

    @Override
    public boolean accept(File dir, String name) {

        if (mask.equals("1")) {
            if (name.lastIndexOf('.') > 0) {
                int lastIndex = name.lastIndexOf('.');
                String str = name.substring(lastIndex);
                if (str.equals(".txt")) {
                    return true;
                }
            }
        }

        else if (mask.equals("2")) {
            if (name.equals("pom.txt")) {
                return true;
            }
        }

       return new File(dir, name).isDirectory();
    }
}
