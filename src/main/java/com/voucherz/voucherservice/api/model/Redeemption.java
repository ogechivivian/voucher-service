package com.voucherz.voucherservice.api.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

public class Redeemption {
    private Date redeemedDate;
    private Integer redeemedCount;
    private Double redeemedAmount;

    public Date getRedeemedDate() {
        return redeemedDate;
    }

    public void setRedeemedDate(Date redeemedDate) {
        this.redeemedDate = redeemedDate;
    }

    public Integer getRedeemedCount() {
        return redeemedCount;
    }

    public void setRedeemedCount(Integer redeemedCount) {
        this.redeemedCount = redeemedCount;
    }

    public Double getRedeemedAmount() {
        return redeemedAmount;
    }

    public void setRedeemedAmount(Double redeemedAmount) {
        this.redeemedAmount = redeemedAmount;
    }

    @Override
    public String toString() {
        return "Redeemption{" +
            "redeemedDate=" + redeemedDate +
            ", redeemedCount=" + redeemedCount +
            ", redeemedAmount=" + redeemedAmount +
            '}';
    }
}
