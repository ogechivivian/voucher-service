package com.voucherz.voucherservice.api.service.impl;

import com.voucherz.voucherservice.api.controller.model.ValueRequest;
import com.voucherz.voucherservice.api.dao.impl.ValueDaoImpl;

import com.voucherz.voucherservice.api.model.Value;
import com.voucherz.voucherservice.api.service.ValueService;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.voucherz.voucherservice.api.util.VoucherGenUtil.*;
@Service
public class ValueServiceImpl implements ValueService {

    public ValueDaoImpl valueDao;

    public ValueServiceImpl(ValueDaoImpl valueDao) {
        this.valueDao = valueDao;
    }

    @Override
    public Value createValueVoucher(ValueRequest valueRequest) {
        String pattern = valueRequest.getPattern();
        String voucherCode = (pattern.isEmpty() || pattern.equals(null)) ? getPatternlessCode(valueRequest) :
                getPatternedCode(valueRequest.getPattern(), valueRequest.getSeparator(), valueRequest.getCharset());

        voucherCode = withPrefix(voucherCode, valueRequest.getPrefix());
        voucherCode = withPostFix(voucherCode, valueRequest.getPostfix());


//        Voucher voucher = new Voucher();
        Value value = new Value();
        value.setCode(voucherCode);
        value.setStartDate(valueRequest.getStartDate());
        value.setExpirationDate(valueRequest.getExpirationDate());
        value.setStatus(valueRequest.getStatus());
        value.setVoucherType(valueRequest.getVoucherType());
        value.setCharset(valueRequest.getCharset());
        value.setPostfix(valueRequest.getPostfix());
        value.setPrefix(valueRequest.getPrefix());
        value.setAdditionalInfo(valueRequest.getAdditionalInfo());
        value.setMerchantId(valueRequest.getMerchantId());
        value.setLength(valueRequest.getLength());
        value.setCategory(valueRequest.getCategory());
        value.setAmount(valueRequest.getAmount());

        return valueDao.create(value);
    }

    @Override
        public Value createSingleValueVoucher(ValueRequest valueRequest) {
        String pattern = valueRequest.getPattern();
        String voucherCode = (pattern.isEmpty() || pattern.equals(null)) ? getPatternlessCode(valueRequest) :
                getPatternedCode(valueRequest.getPattern(), valueRequest.getSeparator(), valueRequest.getCharset());

        voucherCode = withPrefix(voucherCode, valueRequest.getPrefix());
        voucherCode = withPostFix(voucherCode, valueRequest.getPostfix());


//        Voucher voucher = new Voucher();
        Value value = new Value();
        value.setCode(voucherCode);
        value.setStartDate(valueRequest.getStartDate());
        value.setExpirationDate(valueRequest.getExpirationDate());
        value.setStatus(valueRequest.getStatus());
        value.setVoucherType(valueRequest.getVoucherType());
        value.setCharset(valueRequest.getCharset());
        value.setPostfix(valueRequest.getPostfix());
        value.setPrefix(valueRequest.getPrefix());
        value.setAdditionalInfo(valueRequest.getAdditionalInfo());
        value.setMerchantId((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        value.setLength(valueRequest.getLength());
        value.setCategory(valueRequest.getCategory());
        value.setAmount(valueRequest.getAmount());

        return valueDao.create(value);
    }


    @Override
    public List<Value> getValueVoucheType(String type) {
        List<Value> values = null;

        if (type.equalsIgnoreCase("Value")) {
            values = valueDao.findByValueType("value");
            return values;
        }
        return values;
    }

}


