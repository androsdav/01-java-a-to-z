package com.adidyk.start;


import com.adidyk.models.User;

public class StartUiTest {

    public static void main(String[] args) {
        System.out.println("Start");
        Input input = new ConsoleInput();
        Bank  bank = new Bank();
        bank.addUser(new User("1", "1"));
        bank.addUser(new User("Adolf", "16375"));
        bank.addUser(new User("Rudolf", "22445"));
        bank.addUser(new User("Bob", "35336"));

    }
}
