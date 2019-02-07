package com.voucherz.voucherservice.api.controller.model;

import java.sql.Date;

public class RedeemptionRequest {
    private Date redeemedDate;
    private Integer redeemedCount;
    private Double redeemedAmount;
    private String redeemptionStatus;
    private String code;
    private Date expirationDate;
    private String voucherType;
    private String status;

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

    public String getRedeemptionStatus() {
        return redeemptionStatus;
    }

    public void setRedeemptionStatus(String redeemptionStatus) {
        this.redeemptionStatus = redeemptionStatus;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getVoucherType() {
        return voucherType;
    }

    public void setVoucherType(String voucherType) {
        this.voucherType = voucherType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "RedeemptionRequest{" +
            "redeemedDate=" + redeemedDate +
            ", redeemedCount=" + redeemedCount +
            ", redeemedAmount=" + redeemedAmount +
            ", redeemptionStatus='" + redeemptionStatus + '\'' +
            ", code='" + code + '\'' +
            ", expirationDate=" + expirationDate +
            ", voucherType='" + voucherType + '\'' +
            ", status='" + status + '\'' +
            '}';
    }
}
