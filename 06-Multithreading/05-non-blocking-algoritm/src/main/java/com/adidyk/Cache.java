package com.adidyk;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Class StartUi for create jar file and run program (Parallel Search).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 05.05.2018.
 * @version 1.0.
 */
class Cache {

    /**
     * @param map - is.
     */
    private ConcurrentHashMap<Integer, User> map = new ConcurrentHashMap<>();

    /**
     * @param version - is.
     */
    private int version;

    /**
     * @param model - is.
     */
    private Model model = new Model();

    /**
     * @param user - is user.
     * add - is add.
     * @return - true.
     */
    boolean add(User user) {
        boolean result = false;
        if (this.model.versionControl()) {
            if (!this.map.containsKey(user.getId())) {
                this.map.put(user.getId(), user);
                result = true;
            }
            this.version++;
            model.modification = this.version;
        }
        return result;
    }

    /**
     *
     * @param user - is key.
     * @return - is.
     */
    boolean update(User user) {
        boolean result = false;
        /*
        if (this.map.containsKey(key)) {
            User user = this.map.get(key);
            if (user.getVersion() == this.map.get(key).getVersion()) {
                user.setRole(role);
                result = true;
            } else {
                throw new OptimisticException("optimistic exception");
            }
        }
        */
        return result;
    }

    /**
     * today a do not write anething kodeblock.
     * @param user - is key.
     * @return - is.
     */
    boolean delete(User user) {
        boolean result = false;
        if (this.map.containsKey(user.getId())) {
            this.map.remove(user.getId());
            result = true;
        }
        return result;
    }

    /**
     * @param key - is key.
     * @return resuult.
     */
    User get(Integer key) {
        User result = null;
        if (this.map.containsKey(key)) {
            result = this.map.get(key);
        }
        return result;
    }

    /**
     *
     * @return - is.
     */
    ConcurrentHashMap<Integer, User> getAll() {
        return this.map;
    }

    /**
     *
     */
    private class Model {

        /**
         * @param version - is.
         */
        private int modification;

        /**
         *
         */
        private boolean versionControl() {
            boolean result = false;
            if (version == modification) {
                result = true;
            } else {
                throw new OptimisticException("optimistic exception");
            }
            return result;
        }

    }

}