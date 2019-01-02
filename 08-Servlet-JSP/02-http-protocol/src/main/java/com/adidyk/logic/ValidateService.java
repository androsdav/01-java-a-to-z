package com.adidyk.logic;

import com.adidyk.models.MemoryStore;
import com.adidyk.models.Store;
import com.adidyk.models.User;

import java.util.List;

/**
 * Class PostFormServlet uses form and method POST to enter name and surname and returns entered name and surname.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 26.12.2018.
 * @version 1.0.
 */
public class ValidateService implements Validate {

    /**
     *
     */
    private final MemoryStore logic = new MemoryStore();


    /**
     *
     * @param user - user.
     * @return - is.
     */
    @Override
    public User add(User user) {
        this.logic.add(user);
        return user;
    }

    /**
     *
     * @param user - user.
     */
    @Override
    public void update(User user) {
        this.logic.update(user);

    }

    /**
     *
     * @param id - user id.
     * @return - is.
     */
    @Override
    public String delete(String id) {
        this.logic.delete(id);
        return id;
    }

    /**
     *
     * @param id - user id.
     * @return - is.
     */
    @Override
    public User findById(String id) {
        return this.logic.findById(id);
    }

    /**
     *
     * @return - is.
     */
    @Override
    public List<User> findAll() {
        return this.logic.findAll();
    }

}