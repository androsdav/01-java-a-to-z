package com.adidyk.start;

public interface Input {

    String ask(String question);

    // overload method
    int ask(String question, int[] range);
}
