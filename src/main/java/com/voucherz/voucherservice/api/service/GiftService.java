package com.voucherz.voucherservice.api.service;

import com.voucherz.voucherservice.api.controller.model.GiftRequest;
import com.voucherz.voucherservice.api.model.Discount;
import com.voucherz.voucherservice.api.model.Gift;

import java.util.List;

public interface GiftService {
    Gift createGiftVoucher(GiftRequest giftRequest);
    List<Gift> getGiftVoucherType(String  voucherType);

}
