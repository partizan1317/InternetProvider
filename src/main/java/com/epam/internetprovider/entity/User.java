package com.epam.internetprovider.entity;


import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

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

    private final Long id;
    private final String login;
    private String name;
    private String surname;
    private final Boolean admin;
    private final Boolean blocked;
    private BigDecimal amount;
    private final Tariff tariff;

    public User(Long id, String name, String surname,String login, BigDecimal amount, Boolean isAdmin,
                Boolean isBlocked, Tariff tariff) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.amount = amount;
        this.admin = isAdmin;
        this.blocked = isBlocked;
        this.tariff = tariff;
        this.amount.setScale(2, RoundingMode.HALF_UP);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getLogin() {
        return login;
    }

    public Tariff getTariff() {
        return tariff;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public boolean isAdmin() {
        return admin;
    }
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(getId(), user.getId()) && Objects.equals(getLogin(), user.getLogin()) && Objects.equals(getName(), user.getName()) && Objects.equals(getSurname(), user.getSurname()) && Objects.equals(admin, user.admin) && Objects.equals(blocked, user.blocked) && Objects.equals(getAmount(), user.getAmount()) && Objects.equals(getTariff(), user.getTariff());
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (tariff != null ? tariff.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (blocked ? 1 : 0);
        result = 31 * result + (admin ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", isAdmin=" + admin +
                ", isBlocked=" + blocked +
                ", amount=" + amount +
                ", tariff=" + tariff +
                '}';
    }
}
