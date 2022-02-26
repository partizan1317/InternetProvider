package com.epam.internetprovider.entity;

import java.io.Serializable;

public class Tariff implements Identifiable, Serializable {

    private static final long serialVersionUID = -3777795008301041939L;
    private long id;
    private String name;
    private String startDate;
    private String endDate;
    private boolean isPaid;

    public Tariff(long id, String name, String startDate, String endDate, boolean isPaid) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isPaid = isPaid;
    }

    @Override
    public Long getId() {
        return id;
    }
}
