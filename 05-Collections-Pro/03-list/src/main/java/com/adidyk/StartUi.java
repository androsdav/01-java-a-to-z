package com.adidyk;

public class StartUi {

    // main - its only for compile jar file and use collections Stack
    public static void main(String[] arg) {
        //System.out.println("SimpleArrayList, SimpleLinkedList, SimpleStack, SimpleQueue");

        System.out.println();

        User user1 = new User("1", "1", 1);
        User user2 = new User("1", "1", 1);
        User user3 = new User("2", "2", 2);

        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
        System.out.println(user3.hashCode());
/*
        SimpleNode<User> node5 = new SimpleNode<>(new User("4", "0",4), null);
        SimpleNode<User> node4 = new SimpleNode<>(new User("3", "3",3), node5);
        SimpleNode<User> node3 = new SimpleNode<>(new User("3", "3",3), node4);
        SimpleNode<User> node2 = new SimpleNode<>(new User("2", "2",2), node3);
        SimpleNode<User> node1 = new SimpleNode<>(new User("1", "1",1), node2);
        SimpleNode<User> node0 = new SimpleNode<>(new User("0", "0",0), node1);
//        node5.next = node0;
        Cycle cycle = new Cycle();
        cycle.hasCycle(node0);

        /*
        SimpleNode<String> node4 = new SimpleNode<>("string4", null);
        SimpleNode<String> node3 = new SimpleNode<>("string3", node4);
        SimpleNode<String> node2 = new SimpleNode<>("string2", node3);
        SimpleNode<String> node1 = new SimpleNode<>("string1", node2);
        SimpleNode<String> node0 = new SimpleNode<>("string0", node1);
        Cycle cycle = new Cycle();
        cycle.hasCycle(node0);

        /*
        System.out.println();
        System.out.println(node);
        System.out.println(node1);
        System.out.println(node2);
        System.out.println(node3);
        System.out.println(node4);
        */
    }

}

