package com.voucherz.voucherservice.api.model;

public class Discount extends Voucher {
    private String discountType;
//    private boolean Percent;
    private Double discountValue;

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

//    public boolean isPercent() {
//        return Percent;
//    }
//
//    public void setPercent(boolean percent) {
//        Percent = percent;
//    }

    public Double getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(Double discountValue) {
        this.discountValue = discountValue;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "discountType='" + discountType + '\'' +
//                ", Percent=" + Percent +
                ", discountValue=" + discountValue +
                '}';
    }
}
