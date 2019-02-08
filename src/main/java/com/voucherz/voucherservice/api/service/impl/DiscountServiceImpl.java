package com.voucherz.voucherservice.api.service.impl;

import com.voucherz.voucherservice.api.controller.model.DiscountRequest;
import com.voucherz.voucherservice.api.dao.impl.DiscountDaoImpl;
import com.voucherz.voucherservice.api.model.Discount;
import com.voucherz.voucherservice.api.service.DiscountService;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.voucherz.voucherservice.api.util.VoucherGenUtil.*;

@Service
public class DiscountServiceImpl implements DiscountService {
    public DiscountDaoImpl discountDao;

    public DiscountServiceImpl(DiscountDaoImpl discountDao) {
        this.discountDao = discountDao;
    }

    @Override
    public Discount createVoucher(DiscountRequest discountRequest) {
        String pattern = discountRequest.getPattern();
        String voucherCode = (pattern.isEmpty() || pattern.equals(null)) ? getPatternlessCode(discountRequest) :
                getPatternedCode(discountRequest.getPattern(), discountRequest.getSeparator(), discountRequest.getCharset());

        voucherCode = withPrefix(voucherCode, discountRequest.getPrefix());
        voucherCode = withPostFix(voucherCode, discountRequest.getPostfix());


//        Voucher voucher = new Voucher();
        Discount discount = new Discount();
        discount.setCode(voucherCode);
        discount.setStartDate(discountRequest.getStartDate());
        discount.setExpirationDate(discountRequest.getExpirationDate());
        discount.setStatus(discountRequest.getStatus());
        discount.setVoucherType(discountRequest.getVoucherType());
        discount.setCharset(discountRequest.getCharset());
        discount.setPostfix(discountRequest.getPostfix());
        discount.setPrefix(discountRequest.getPrefix());
        discount.setAdditionalInfo(discountRequest.getAdditionalInfo());
        discount.setMerchantId(discountRequest.getMerchantId());
        discount.setLength(discountRequest.getLength());
        discount.setCategory(discountRequest.getCategory());
        discount.setDiscountType(discountRequest.getDiscountType());
//        discount.setDiscountType(discountRequest.getDiscountType());
        discount.setDiscountValue(discountRequest.getDiscountValue());
//        discount.setDiscountAmount(discountRequest.getDiscountAmount());
//        discount.setDiscountPercent(discountRequest.getDiscountPercent());

        return discountDao.create(discount);
    }


    @Override
    public List<Discount> getVoucherByType(String voucherType) {

        List<Discount> discounts = null;

        if (voucherType.equalsIgnoreCase("Discount")) {
            discounts = discountDao.findByDiscountType("Discount");
            return discounts;
        }
        return discounts;
    }



// else if (voucherType.equalsIgnoreCase("Gift")) {
//
//            return voucherDao.findByVoucherType("Gift");
//
//        } else {
//            vouchers = voucherDao.findByVoucherType("Value");
//
//            return vouchers;
//        }
//    }
}
