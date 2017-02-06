package com.adidyk.server;

public class MenuApi {

    private Api api;
    private Input input;
    private UserAction[] actions = new UserAction[2];


    //
    MenuApi(Input input, Api api) {
        this.input = input;
        this.api = api;
    }

    //
    protected void fillAction() {
        this.actions[0] = new EnterDir();
        this.actions[1] = new ExitDir();
    }

    //
    protected void select(int key) {
        this.actions[key - 1].execute(this.input, this.api);
    }

    public void show() {
        System.out.println();
        System.out.println(" ------------------------------Tracker Menu --------------------------------");
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
        System.out.println(" ---------------------------------------------------------------------------");
    }

    //
    private class EnterDir implements UserAction {
        @Override
        public int key() {
            return 1;
        }
        @Override
        public void execute(Input input, Api api) {
            String nameDir = input.ask("Input name directory");
            String[] listDir = api.enterDir(nameDir);
            for (String list : listDir) {
                System.out.println(" ----  " +list);
            }
        }
        @Override
        public String info() {
            return String.format(" %s%s%s", this.key(), ".", " Enter Dir.");
        }
    }

    //
    private class ExitDir implements UserAction {
        @Override
        public int key() {
            return 2;
        }
        @Override
        public void execute(Input input, Api api) {
            String[] listDir = api.exitDir();
            for (String list : listDir) {
                System.out.println(" --- " +list);
            }

        }
        @Override
        public String info() {
            return String.format(" %s%s%s", this.key(), ".", " Enter Dir.");
        }
    }


















}