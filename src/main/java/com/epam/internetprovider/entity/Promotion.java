package com.epam.internetprovider.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

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
    private final Long id;
    private final String name;
    private final Date startDate;
    private final Date endDate;
    private final BigDecimal discount;
    private final Tariff tariff;
    private final Boolean isDeleted;

    public Promotion (Long id, String name, Date startDate, Date endDate, BigDecimal discount,
                      Tariff tariff, Boolean isDeleted) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.discount = discount;
        this.tariff = tariff;
        this.isDeleted = isDeleted;
    }

    public String getName() {
        return name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public Tariff getTariff() {
        return tariff;
    }

    public Boolean getDeleted() {
        return isDeleted;
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
        Promotion promotion = (Promotion) o;
        return Objects.equals(getId(), promotion.getId()) && Objects.equals(getName(), promotion.getName()) && Objects.equals(getStartDate(), promotion.getStartDate()) && Objects.equals(getEndDate(), promotion.getEndDate()) && Objects.equals(getDiscount(), promotion.getDiscount()) && Objects.equals(getTariff(), promotion.getTariff()) && Objects.equals(isDeleted, promotion.isDeleted);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (discount != null ? discount.hashCode() : 0);
        result = 31 * result + (tariff != null ? tariff.hashCode() : 0);
        result = 31 * result + (isDeleted ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", discount=" + discount +
                ", tariff=" + tariff +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
