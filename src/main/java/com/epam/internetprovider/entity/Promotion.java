package com.epam.internetprovider.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Promotion implements Identifiable, Serializable {

    public static final String TABLE = "promotion";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String START_DATE = "start_date";
    public static final String END_DATE = "end_date";
    public static final String DISCOUNT = "discount";
    public static final String TARIFF_ID = "tariff_id";
    public static final String IS_DELETED = "is_deleted";

    private static final long serialVersionUID = 8835924595971370213L;
    private long id;
    private String name;
    private String startDate;
    private String endDate;
    private BigDecimal discount;
    private long tariffId;
    private boolean isDeleted;

    public Promotion (long id, String name, String startDate, String endDate, BigDecimal discount,
                      long tariffId, boolean isDeleted) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.discount = discount;
        this.tariffId = tariffId;
        this.isDeleted = isDeleted;
    }

    @Override
    public Long getId() {
        return id;
    }
}
