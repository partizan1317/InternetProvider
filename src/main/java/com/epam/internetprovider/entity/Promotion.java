package com.epam.internetprovider.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Promotion implements Identifiable, Serializable {

    private static final long serialVersionUID = 8835924595971370213L;
    private long id;
    private String name;
    private String startDate;
    private String endDate;
    private BigDecimal discount;

    public Promotion (long id, String name, String startDate, String endDate, BigDecimal discount) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.discount = discount;
    }

    @Override
    public Long getId() {
        return id;
    }
}
