package com.epam.internetprovider.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Tariff implements Identifiable, Serializable {

    public static final String TABLE = "tariff";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String START_DATE = "start_date";
    public static final String END_DATE = "end_date";
    public static final String IS_PAID = "is_paid";
    public static final String IS_DELETED = "is_deleted";
    public static final String PRICE = "price";

    private static final long serialVersionUID = -3777795008301041939L;
    private final Long id;
    private final String name;
    private final Date startDate;
    private final Date endDate;
    private final Boolean isPaid;
    private Boolean deleted;
    private final BigDecimal price;

    public Tariff(Long id, String name, Date startDate, Date endDate, Boolean isPaid, Boolean isDeleted, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isPaid = isPaid;
        this.deleted = isDeleted;
        this.price = price;
    }

    public static Tariff byId(Long id) {
        return new Tariff(id, null, null, null, false, false, null);
    }

    public String getName() {
        return name;
    }

    public void setDeleted (Boolean deleted) {
        this.deleted = deleted;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tariff tariff = (Tariff) o;
        return Objects.equals(getId(), tariff.getId()) && Objects.equals(getName(), tariff.getName()) && Objects.equals(getStartDate(), tariff.getStartDate()) && Objects.equals(getEndDate(), tariff.getEndDate()) && Objects.equals(isPaid, tariff.isPaid) && Objects.equals(deleted, tariff.deleted) && Objects.equals(price, tariff.price);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (isPaid ? 1 : 0);
        result = 31 * result + (deleted ? 1 : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Tariff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", isPaid=" + isPaid +
                ", isDeleted=" + deleted +
                ", price= " + price +
                '}';
    }
}
