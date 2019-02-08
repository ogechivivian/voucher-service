package com.voucherz.voucherservice.api.dao;

import com.voucherz.voucherservice.api.model.Discount;

import java.util.List;

public interface DiscountDao extends BaseDao<Discount> {

    List<Discount> findByDiscountType(String voucherType);

    Discount findByDiscountCode (String discountCode);

}
