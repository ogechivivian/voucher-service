package com.voucherz.voucherservice.api.dao;

import com.voucherz.voucherservice.api.model.Value;

import java.util.List;

public interface ValueDao extends BaseDao<Value> {

    List<Value> findByValueType(String value);
    Value findByValueCode(String valueCode);
}
