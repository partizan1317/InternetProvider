package com.epam.internetprovider.entity;


import java.io.Serializable;
import java.math.BigDecimal;

public class User implements Identifiable, Serializable {

    private static final long serialVersionUID = -2989479181666795916L;
    private long id;
    private String login;
    private String name;
    private String surname;
    private String password;
    private boolean isAdmin;
    private boolean isBlocked;
    private BigDecimal amount;

    public User(long id, String name, String surname,String login, String password,  BigDecimal amount, boolean isAdmin,
                boolean isBlocked) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.amount = amount;
        this.isAdmin = isAdmin;
        this.isBlocked = isBlocked;
    }


    public User(long id, String login) {
        this.id = id;
        this.login = login;
    }

    @Override
    public Long getId() {
        return id;
    }
}
