package com.adidyk.servlets;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

public class ExampleFunction {

    private final Map<String, Function<String, Boolean>> dispatch = new HashMap<>();

    public Function<String, Boolean> add() {
        return msg -> {
            System.out.println("add user to list");
            return true;
        };
    }

    public Function<String, Boolean> update() {
        return msg -> {
            System.out.println("update user");
            return true;
        };
    }

    public Function<String, Boolean> delete() {
        return add -> {
            System.out.println("delete user from list");
            return true;
        };
    }

    public void init() {
        this.load("add", this.add());
        this.load("update", this.update());
        this.load("delete", this.delete());
    }

    public void load(String action, Function<String, Boolean> handle) {
        this.dispatch.put(action, handle);
    }

    public boolean sent(String action) {
        return this.dispatch.get(action).apply(action);
    }

    public static void main(String[] arg) {
        ExampleFunction example = new ExampleFunction();
        example.init();
        System.out.println(example.sent("add"));
        System.out.println(example.sent("delete"));
        System.out.println(example.sent("update"));
        System.out.println(example.sent("addd"));
        //System.out.println("test");

    }


}
