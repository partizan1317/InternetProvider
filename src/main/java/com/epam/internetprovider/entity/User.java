package com.epam.internetprovider.entity;


import java.io.Serializable;
import java.math.BigDecimal;

public class User implements Identifiable, Serializable {

    public static final long serialVersionUID = -2989479181666795916L;
    
    public static final String NAME = "name";
    public static final String TABLE = "user";
    public static final String ID = "id";
    public static final String SURNAME = "surname";
    public static final String IS_ADMIN = "is_admin";
    public static final String AMOUNT = "amount";
    public static final String LOGIN = "login";

    private long id;
    private String login;
    private String name;
    private String surname;
    private boolean isAdmin;
    private boolean isBlocked;
    private BigDecimal amount;

    public User(long id, String name, String surname,String login, BigDecimal amount, boolean isAdmin,
                boolean isBlocked) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.login = login;
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
