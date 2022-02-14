package com.epam.internetprovider.entity;

public class User implements Identifable{

    private final long id;
    private final String login;

    public User(long id, String login) {
        this.id = id;
        this.login = login;
    }

    @Override
    public Long getId() {
        return null;
    }
}
