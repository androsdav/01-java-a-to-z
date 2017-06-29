package com.adidyk;

public class StartUi {

    // main - its only for compile jar file and use collections Stack
    public static void main(String[] arg) {

        SimpleStack<User> stack = new SimpleStack<>();

        System.out.println("\nEmpty: ");
        System.out.println(stack.empty() +"\n");

        System.out.println("Push: ");
        stack.push(new User("0", "0", 0));
        stack.push(new User("1", "1", 1));
        stack.push(new User("2", "2", 2));
        stack.push(new User("3", "3", 3));
        stack.push(new User("4", "4", 4));
        System.out.println(stack.peek());
        System.out.println("Pop: " +stack.pop() +"Last:" +stack.peek() +stack.size());
        System.out.println("Pop: " +stack.pop() +"Last:" +stack.peek() +stack.size());
        System.out.println("Pop: " +stack.pop() +"Last:" +stack.peek() +stack.size());

       // System.out.println(stack.search(new User("0", "0", 0)));

    }
}
        /*
        System.out.println("SimpleArrayList and SimpleLinkedList and  Comparable");


        Stack<User> stack = new Stack<>();
        stack.add(new User("1", "Bob", 12));
        stack.add(new User("2", "Bill", 13));
        stack.add(new User("3", "Ben", 14));
        stack.add(new User("4", "Amanda", 15));
        stack.add(0, new User("1.1", "Eman", 11));

        System.out.println("Use get  index");
        System.out.println(stack.get(3));

        Iterator<User> it = stack.iterator();

        System.out.println();
        System.out.println("Use Iterator");
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println();
        System.out.println("Use forEach");
        for (Object user : stack) {
            System.out.println(user);
        }

        System.out.println();
        System.out.println("Use peek");
        System.out.println(stack.peek());

        System.out.println();
        System.out.println("Use empty");
        System.out.println(stack.empty());

        System.out.println();
        System.out.println("Use pop");
        System.out.println(stack.pop());
        System.out.println();
        for (Object user : stack) {
            System.out.println(user);
        }

        System.out.println();
        System.out.println("Use push");
        System.out.println("Return method push: " +stack.push(new User("33", "Anatoliy", 45)));
        System.out.println();
        for (User user : stack) {
            System.out.println(user);
        }

        System.out.println();
        System.out.println("Use search");
        System.out.println(stack.search(new User("1.1", "Eman", 11)));
        System.out.println(stack.search(new User("1", "Bob", 12)));
        System.out.println(stack.search(new User("2", "Bill", 13)));
        System.out.println(stack.search(new User("3", "Ben", 14)));
        System.out.println(stack.search(new User("33", "Anatoliy", 45)));
        System.out.println((stack.search(new User("4", "Amanda", 15))));



        System.out.println("Stack classsssssssssssssss");

        SimpleOldStack<User> stk = new SimpleOldStack<>();
        stk.add(new User("0", "0", 0));
        stk.add(new User("1", "1", 1));
        stk.add(new User("2", "2", 2));
        stk.add(new User("3", "3", 3));
        stk.add(new User("4", "4", 4));

        for (User user : stk) {
            System.out.println(user);
        }

        Queue<User> queue = new ArrayDeque<>(); */
