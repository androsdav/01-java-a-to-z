package com.adidyk;

public class StartUi {

    public static void main(String[] arg) {
        System.out.println("HashCode");
        User user = new User("tom", 33);
        int hashCode = user.hashCode();
        System.out.println("hashCode:  " +hashCode);


        System.out.println(user);
    }

}