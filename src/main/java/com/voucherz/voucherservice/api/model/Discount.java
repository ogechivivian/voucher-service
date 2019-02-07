package com.voucherz.voucherservice.api.model;

import java.math.BigDecimal;

public class Discount extends Voucher {
    private String discountType;
    private Double discountValue;
    private Double discountAmount;
	private Double discountPercent;


    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public Double getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(Double discountValue) {
        this.discountValue = discountValue;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Double discountPercent) {
        this.discountPercent = discountPercent;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "discountType='" + discountType + '\'' +
                ", discountValue=" + discountValue +
                ", discountAmount=" + discountAmount +
                ", discountPercent=" + discountPercent +
                '}';
    }
}
