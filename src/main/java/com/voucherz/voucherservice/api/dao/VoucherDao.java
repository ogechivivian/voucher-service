package com.voucherz.voucherservice.api.dao;

import com.voucherz.voucherservice.api.model.Voucher;

public interface VoucherDao extends BaseDao<Voucher> {
    Voucher findByCode(String code);
    Voucher findGiftCode(String code);
}
