package com.epam.internetprovider.entity;

import java.io.Serializable;

public class Tariff implements Identifiable, Serializable {

    public static final String TABLE = "tariff";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String START_DATE = "start_date";
    public static final String END_DATE = "end_date";
    public static final String IS_PAID = "is_paid";
    public static final String IS_DELETED = "is_deleted";

    private static final long serialVersionUID = -3777795008301041939L;
    private long id;
    private String name;
    private String startDate;
    private String endDate;
    private boolean isPaid;
    private boolean isDeleted;

    public Tariff(long id, String name, String startDate, String endDate, boolean isPaid, boolean isDeleted) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isPaid = isPaid;
        this.isDeleted = isDeleted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Long getId() {
        return id;
    }
}
