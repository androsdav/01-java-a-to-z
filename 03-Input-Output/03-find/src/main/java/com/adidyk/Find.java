package com.adidyk;

import java.io.File;

import static com.adidyk.Filter.filter;

public class Find {

    public void find(String root) {
        String name = "pom.txt";
        File file = new File(root);
        boolean findTrue = false;

        //FilenameFilter filter = new FilenameFilter() {
        //    @Override
        //    public boolean accept(File dir, String name) {
                //String name1 = name.toLowerCase();
        //        String test = name.matches();
        //        return false;
        //    }
        //}


        File[] items = file.listFiles(filter);
            //@Override
            //public boolean accept(File dir, String name) {
            //    String mask = name.toLowerCase();
          //      if (mask.endsWith(".txt")) {
         //           return true;
         //       }
         //       return false;
         //   }
        //});
        if (items != null) {
            for (File item : items) {
                if (item.isDirectory()) {
                    find(item.getPath());
                } else if (item.isFile()) {
                    if (name.equals(item.getName())) {
                        //findTrue = true;
                        System.out.println(item.getPath());
                    }
                }
            }
        }
    }
}
