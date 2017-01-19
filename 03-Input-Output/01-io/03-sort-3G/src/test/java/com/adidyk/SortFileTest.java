package com.adidyk;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortFileTest {

    private String[] rowsFact;

    @Test
    public void sort() throws IOException {
        String[] rowsSource = {"11", "0", "55555", "222", "4444", "333"};
        String[] rowsActuality = {"0", "11", "222", "333", "4444", "55555"};
        File source = new File("sourceTest.txt");
        File distance = new File("distanceTest.txt");
        try (RandomAccessFile rafSource = new RandomAccessFile(source, "rw")) {
            for (String row : rowsSource) {
                rafSource.writeBytes(row.concat(System.lineSeparator()));
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        SortFile sf = new SortFile();
        sf.sort(source, distance);
        try (RandomAccessFile rafDistance = new RandomAccessFile(distance, "rw")) {
            String row;
            String rows = "";
            while((row = rafDistance.readLine()) != null) {
                rows = rows.concat(row).concat(System.lineSeparator());
            }
            this.rowsFact = rows.split(System.lineSeparator());
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        source.delete();
        distance.delete();
        assertThat(this.rowsFact, is(rowsActuality));
    }

}
