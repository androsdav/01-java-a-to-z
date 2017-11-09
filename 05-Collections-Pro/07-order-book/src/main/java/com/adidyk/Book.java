package com.adidyk;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Class User for create user (object) with params: name, children and birthday.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 21.07.2017.
 * @version 1.0.
 */
public class Book {

    /**
     *
     * @param orders is orders
     */
    void readerXML(File orders) {
        try (BufferedReader br = new BufferedReader(new FileReader(orders))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                if (line.startsWith("<A")) {
                    System.out.println("order");
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
