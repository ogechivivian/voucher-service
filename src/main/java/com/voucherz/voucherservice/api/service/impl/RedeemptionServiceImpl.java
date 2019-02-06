package com.voucherz.voucherservice.api.service.impl;

import com.voucherz.voucherservice.api.controller.model.RedeemptionRequest;
import com.voucherz.voucherservice.api.dao.VoucherDao;
import com.voucherz.voucherservice.api.model.Discount;
import com.voucherz.voucherservice.api.model.Redeemption;
import com.voucherz.voucherservice.api.model.Voucher;
import com.voucherz.voucherservice.api.service.RedeemptionService;
import org.springframework.stereotype.Service;

@Service
public class RedeemptionServiceImpl implements RedeemptionService {

    private RedeemptionRequest redeemptionRequest;
    private Voucher voucher;
    private Discount discount;
    private VoucherDao voucherDao;





    private Redeemption confirmingVoucher(RedeemptionRequest redeemptionRequest) {
        String checkCode = redeemptionRequest.getCode();

//        Voucher voucher = voucherDao. (redeemptionRequest.getCode());

        if (voucher.getCode().equals(checkCode) &&
            (redeemptionRequest.getExpirationDate().before(voucher.getExpirationDate()) &&
                redeemptionRequest.getExpirationDate().equals(voucher.getExpirationDate())
                && redeemptionRequest.getRedeemedAmount().equals(discount.getDiscountValue()))){

            Redeemption redeemption = new Redeemption();

            redeemption.setRedeemedDate(redeemptionRequest.getRedeemedDate());
            redeemption.setRedeemedAmount(redeemptionRequest.getRedeemedAmount());

        }
        else if(voucher.getCode().equals(checkCode) &&
            (redeemptionRequest.getExpirationDate().before(voucher.getExpirationDate()) &&
                redeemptionRequest.getExpirationDate().equals(voucher.getExpirationDate())
                && redeemptionRequest.getRedeemedAmount().equals(discount.getDiscountValue()))){

        }
        return null;
    }
}
