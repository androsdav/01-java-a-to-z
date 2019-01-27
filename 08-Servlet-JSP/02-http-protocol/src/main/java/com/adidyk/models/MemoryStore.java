package com.adidyk.models;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

/**
 * Class MemoryStore consists next method for container of users: add, update, delete, findById, findAll.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 27.01.2019.
 * @version 1.0.
 */
public class MemoryStore implements Store {

    /**
     * @param instance - link variable to object of class MemoryStore (singleton).
     */
    private static final Store instance = new MemoryStore();

    /**
     * @param users - container for users (link variable to object of class ArrayList).
     */
    private List<User> users = new CopyOnWriteArrayList<>();

    /**
     * @param id - user id.
     */
    private int id = 1;

    /**
     * MemoryStore - private constructor.
     */
    private MemoryStore() {

    }

    /**
     * getInstance - returns link variable to object of class MemoryStore (singleton).
     * @return - returns link variable to object of class MemoryStore (singleton).
     */
    public static Store getInstance() {
        return instance;
    }

    /**
     * add - adds user to container.
     * @param user - user (link variable to object of class User).
     */
    @Override
    public User add(User user) {
        user.setId(this.generateId());
        this.users.add(user);
        return user;
    }

    /**
     * update - updates user by id in container.
     * @param user - user (link variable to object of class User).
     */
    @Override
    public void update(User user) {
        IntStream.range(0, this.users.size()).
                filter(index -> user.getId().equals(this.users.get(index).getId())).
                findFirst().ifPresent(index -> this.users.set(index, user));
    }

    /**
     * delete - deletes user by id from container.
     * @param id - user id.
     * @return - returns id.
     */
    @Override
    public String delete(String id) {
        IntStream.range(0, this.users.size()).
                filter(index -> id.equals(this.users.get(index).getId())).
                findFirst().ifPresent(index -> this.users.remove(index));
        return id;
    }

    /**
     * findById - finds user by id in container.
     * @param id - user id.
     * @return - returns user id.
     */
    public User findById(String id) {
        return this.users.stream().filter(item -> id.equals(item.getId())).findFirst().get();
    }

    /**
     * findAll - returns all user from container.
     * @return - returns all user.
     */
    public List<User> findAll() {
        return this.users;
    }

    /**
     * generateId - generates id for user.
     * @return - returns user id.
     */
    private String generateId() {
        return String.valueOf(this.id++);
    }

}