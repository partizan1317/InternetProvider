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
    public static final String IS_BLOCKED = "is_blocked";
    public static final String TARIFF_ID = "tariff_id";

    private long id;
    private String login;
    private String name;
    private String surname;
    private boolean isAdmin;
    private boolean isBlocked;
    private BigDecimal amount;
    private long tariff_id;

    public User(long id, String name, String surname,String login, BigDecimal amount, boolean isAdmin,
                boolean isBlocked,long tariff_id) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.amount = amount;
        this.isAdmin = isAdmin;
        this.isBlocked = isBlocked;
        this.tariff_id = tariff_id;
    }

    public User(long id, String login) {
        this.id = id;
        this.login = login;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public long getTariff_id() {
        return tariff_id;
    }

    public void setTariff_id(long tariff_id) {
        this.tariff_id = tariff_id;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    @Override
    public Long getId() {
        return id;
    }
}
