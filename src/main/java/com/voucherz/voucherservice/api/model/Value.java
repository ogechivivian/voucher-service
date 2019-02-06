package com.voucherz.voucherservice.api.model;

public class Value extends Voucher{
    private Double amount;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Value{" +
                "amount=" + amount +
                '}';
    }
}
