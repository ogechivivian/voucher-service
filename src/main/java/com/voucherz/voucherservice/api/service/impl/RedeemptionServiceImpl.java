package com.voucherz.voucherservice.api.service.impl;

import com.voucherz.voucherservice.api.controller.model.RedeemptionRequest;
import com.voucherz.voucherservice.api.dao.VoucherDao;
import com.voucherz.voucherservice.api.model.*;
import com.voucherz.voucherservice.api.service.RedeemptionService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RedeemptionServiceImpl implements RedeemptionService {

    private RedeemptionRequest redeemptionRequest;
    private Voucher voucher;
    private Discount discount;
    private VoucherDao voucherDao;
    private Value value;
    private Gift gift;





    public Redeemption redeemingVoucher(RedeemptionRequest redeemptionRequest) {
//        Voucher voucher = voucherDao.(redeemptionRequest.getCode());
        String checkCode = redeemptionRequest.getCode();
        String changeStatus = "Voucher Used";

//        Date currentdate = new Date();
        if (voucher.getCode().equals(checkCode) &&
            (redeemptionRequest.getExpirationDate().before(voucher.getExpirationDate()) &&
                redeemptionRequest.getExpirationDate().equals(voucher.getExpirationDate())
                && redeemptionRequest.getRedeemedAmount().equals(discount.getDiscountValue()) && voucher.getStatus().equalsIgnoreCase("Active"))){

            Redeemption redeemption = new Redeemption();

            redeemption.setRedeemedDate(redeemptionRequest.getRedeemedDate());
            redeemption.setRedeemedAmount(redeemptionRequest.getRedeemedAmount());
            redeemption.setRedeemptionStatus(changeStatus);

        }
        else if(voucher.getCode().equals(checkCode) &&
            (redeemptionRequest.getExpirationDate().before(voucher.getExpirationDate()) &&
                redeemptionRequest.getExpirationDate().equals(voucher.getExpirationDate())
                && redeemptionRequest.getRedeemedAmount().equals(value.getAmount()) && voucher.getStatus().equalsIgnoreCase("Active"))){

            Redeemption redeemption = new Redeemption();

            redeemption.setRedeemedDate(redeemptionRequest.getRedeemedDate());
            redeemption.setRedeemedAmount(redeemptionRequest.getRedeemedAmount());
            redeemption.setRedeemptionStatus(changeStatus);

        }

        else if(voucher.getCode().equals(checkCode) &&
            (redeemptionRequest.getExpirationDate().before(voucher.getExpirationDate()) &&
                redeemptionRequest.getExpirationDate().equals(voucher.getExpirationDate())
                && redeemptionRequest.getRedeemedAmount().equals(gift.getValue()) && voucher.getStatus().equalsIgnoreCase("Active"))){
            Redeemption redeemption = new Redeemption();


        }

        return null;
    }
}
