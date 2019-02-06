package com.voucherz.voucherservice.api.model;

public class Gift extends Voucher {
    private Double value;
    private Double totalUsed;
    private Double balance;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getTotalUsed() {
        return totalUsed;
    }

    public void setTotalUsed(Double totalUsed) {
        this.totalUsed = totalUsed;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Gift{" +
                "value=" + value +
                ", totalUsed=" + totalUsed +
                ", balance=" + balance +
                '}';
    }
}
