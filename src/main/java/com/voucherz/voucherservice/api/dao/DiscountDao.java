package com.voucherz.voucherservice.api.dao;

import com.voucherz.voucherservice.api.model.Discount;

import java.util.List;

public interface DiscountDao extends BaseDao<Discount> {
//    Discount create(String code);
    List<Discount> findByDiscountType(String discountType);

    Discount findByDiscountCode (String discountCode);

}
