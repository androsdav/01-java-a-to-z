package com.adidyk;

/**
 * Class "StartUi" for create jar file.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 21.07.2017.
 * @version 1.0.
 */
public class StartUi {

    /**
     * main - is only for create jar file.
     * @param arg nothing.
     */
    public static void main(String[] arg) {
        System.out.println("Tree");
        TreeBinary<Integer> tree = new TreeBinary<>();
        tree.add(10);
        tree.add(12);
        tree.add(5);
        tree.add(11);
        tree.add(13);
        tree.add(15);
        tree.add(5);
        tree.add(12);
        System.out.println(tree);
    }

}