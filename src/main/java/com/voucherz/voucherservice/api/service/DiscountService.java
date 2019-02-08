package com.voucherz.voucherservice.api.service;

import com.voucherz.voucherservice.api.controller.model.DiscountRequest;
import com.voucherz.voucherservice.api.model.Discount;

import java.util.List;

public interface DiscountService {
//    public Discount createDiscount(Discounscount discount);

    Discount createVoucher(DiscountRequest discountRequest);
    List<Discount> getVoucherByType(String  type);


}
