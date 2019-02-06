package com.voucherz.voucherservice.api.service;

import com.voucherz.voucherservice.api.controller.model.ValueRequest;
import com.voucherz.voucherservice.api.model.Discount;
import com.voucherz.voucherservice.api.model.Value;

import java.util.List;

public interface ValueService {
    Value createValueVoucher(ValueRequest valueRequest);
    Value createSingleValueVoucher(ValueRequest valueRequest);
    List<Value> getValueVoucheType(String type);
}
