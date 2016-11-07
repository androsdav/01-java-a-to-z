package com.adidyk.start;

public class StubInput implements Input {

    private String[] answers;
    private int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    public String ask(String question) {
        return this.answers[this.position++];
    }

    public int ask(String queestion, int[] range) {
       // throw new UnsupportedOperationException("Unsupported operation");
        return -1;
    }
}
