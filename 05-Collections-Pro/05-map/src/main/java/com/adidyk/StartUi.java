package com.adidyk;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Class "StartUi" for create Map and puts key = user and value = new Object().
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 21.07.2017.
 * @version 1.0.
 */
public class StartUi {

    /**
     * main - creates map and puts two element in map - first, new Object()
     * and second, new Object().
     * @param arg nothing
     */
    public static void main(String[] arg) {
        System.out.println();
        User first  = new User("Bob", "Bill", 3, new GregorianCalendar(1992, 2, 2));
        System.out.println();
        User second = new User("Bill", "Bob", 3, new GregorianCalendar(1992, 2, 2));
        System.out.println();
        Map<User, Object> map = new HashMap<>();
        map.put(first, new Object());
        map.put(second, new Object());
        System.out.println(map);
        //
        //
        Byte xByte = 120;
        Short xShort = 1245;
        Integer xInt = 2147483647;
        Long xLong = 123456789L;
        Float xFloat = 9.2F;
        Double xDouble = 456.234D;
        Character xChar = 'F';
        Boolean xBoolean = true;
        String xString = "string";

        System.out.println("1. Byte:    " + xByte.hashCode());
        System.out.println("2. Short:   " + xShort.hashCode());
        System.out.println("3. Int:     " + xInt.hashCode());
        System.out.println("4. Long:    " + xLong.hashCode());
        System.out.println("5. Float:   " + xFloat.hashCode());
        System.out.println("6. Double:  " + xDouble.hashCode());
        System.out.println("7. Char:    " + xChar.hashCode());
        System.out.println("8. Boolean: " + xBoolean.hashCode());
        System.out.println("8. String:  " + xString.hashCode());

        System.out.println("9. All:     " + xByte.hashCode() + xShort.hashCode() + xInt.hashCode()
        + xLong.hashCode() + xFloat.hashCode() + xDouble.hashCode() + xChar.hashCode() + xBoolean.hashCode() + xString.hashCode());

        System.out.println("first: " + first.hashCode());

        // hash String
        int hash = 0;
            for (int i = 0; i < xString.length(); i++) {
                hash = 31 * hash + (int) xString.charAt(i);
            }
        System.out.println("String hash my:  " + hash);
        System.out.println("Test print char:  " + (int) xString.charAt(0));
        //
        //
        // Beat operation
        System.out.println();
        int a = 10;
        int b = 7;
        System.out.println("OR  | : " + a + " | " + b + " = " +  (a | b));
        System.out.println("AND & : " + a + " & " + b + " = " +  (a & b));
        System.out.println("XOR ^ : " + a + " ^ " + b + " = " +  (a ^ b));
        System.out.println("NOT ~ : " + ~(a | b));
        System.out.println("<<    : " +  (b << 2));
        System.out.println(">>    : " +  (a >> 1));
        int i = 192;
        System.out.println("i << 1 : " + (i << 1));
        System.out.println("i << 1 : " + (i >> 1));
        System.out.println("i << 1 : " + (i >>> 1));
        int c = 1;
        System.out.println("i << 29: " + (c << 29));
        System.out.println("i << 29: " + (c << 30));
        System.out.println("i << 29: " + (c << 31));
        System.out.println("i << 29: " + (c << 32));
        System.out.println("The end today");
        System.out.println();
        System.out.println(15 % 5);

        System.out.println();
        System.out.println("Collision");
        String int1 = "123";
        String int2 = "123";
        System.out.println(int1.hashCode());
        System.out.println(int2.hashCode());

        System.out.println();
        System.out.println(first.hashCode());
        System.out.println(second.hashCode());



    }

}