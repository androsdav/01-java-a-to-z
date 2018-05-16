package com.adidyk;

import java.util.Map;
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
    private Map<Integer, User> cache = new ConcurrentHashMap<>();

    /**
     * @param user - is user.
     * add - is add.
     * @return - true.
     */
    User add(User user) {
        return cache.computeIfAbsent(user.getId(), key -> user);
    }

    /**
     *
     * @param user - is key.
     * @return - is.
     */
    boolean update(User user) {
        boolean result = false;
        if (this.cache.containsKey(user.getId())) {
            User oldUser = this.cache.get(user.getId());
            if (oldUser.getVersion() == this.cache.get(user.getId()).getVersion()) {
                oldUser.setRole(user.getRole());
                result = true;
            } else {
                throw new OptimisticException("optimistic exception");
            }
        }
        return result;
    }

    /**
     * today a do not write anething kodeblock.
     * @param user - is key.
     * @return - is.
     */
    boolean delete(User user) {
        return cache.remove(user.getId(), user);
    }

    /**
     * @param key - is key.
     * @return resuult.
     */
    User get(Integer key) {
        User result = null;
        if (this.cache.containsKey(key)) {
            result = this.cache.get(key);
        }
        return result;
    }

    /**
     *
     * @return - is.
     */
    Map<Integer, User> getAll() {
        return this.cache;
    }

}