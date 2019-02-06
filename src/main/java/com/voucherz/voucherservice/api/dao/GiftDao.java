package com.voucherz.voucherservice.api.dao;

import com.voucherz.voucherservice.api.model.Gift;

import java.util.List;

public interface GiftDao extends BaseDao<Gift> {
    List<Gift> findByGiftType(String giftype);
    Gift findByGiftCode (String giftCode);
}
