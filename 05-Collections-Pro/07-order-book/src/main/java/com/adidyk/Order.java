package com.adidyk;

/**
 * Class User for create user (object) with params: name, children and birthday.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 21.07.2017.
 * @version 1.0.
 */
public class Order {

    /**
     * book - is identification action.
     */
    private String book;

    /**
     * operation - is type operation: buy or sell.
     */
    private String operation;

    /**
     * price - is price.
     */
    private double price;

    /**
     * volume - is volume of application, how many lots(shares) to buy / sell.
     */
    private int volume;

    /**
     * id - is id.
     */
    private int id;

    /**
     * Constructor - is constructor.
     * @param book is book.
     * @param operation is operation.
     * @param price is price.
     * @param volume is volume.
     * @param id is id.
     */
    Order(String book, String operation, double price, int volume, int id) {
        this.book = book;
        this.operation = operation;
        this.price = price;
        this.volume = volume;
        this.id = id;
    }

    /**
     *
     * @param string is string.
     */
    public void purse(String string) {
        /*
        char[] book;
        String[] order = new String[5];
        int position = 0;
        int pos1 = 0;
        int pos2 = 0;
        boolean start = false;
        boolean end = false;
        for (int index = 0; index < string.length(); index++) {
            char ch = string.charAt(index);
            if (string.charAt(index) == '"') {
                pos1 = index;
                //int pos = index++;
                do {
                    pos2 = index;
                } while (string.charAt(++index) != '"');// {
                order[position] = string.substring(pos1, pos2);

//                    order[position] = "".concat(Character.toString(string.charAt(pos)));
//                    System.out.print(order[0]);
//                }
                //index = pos;
                start = true;
            }
//            if (start && string.charAt(index++) == '"') {
//                pos2 = index;
//                start = false;
            //}
        }
        System.out.print("" +order[0]);
        */
    }

    /**
     *
     * @return all param for Order
     */
    @Override
    public String toString() {
        return String.format("%s%s%s%s%s%s%s%s%s%s%s%s", "Order{", "book=", this.book, ", operation=", this.operation,
                ", price=", this.price, ", volume=", this.volume, ", id=", this.id, "}");
    }

}