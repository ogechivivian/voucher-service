package com.voucherz.voucherservice.api.service.impl;

import com.voucherz.voucherservice.api.controller.model.GiftRequest;
import com.voucherz.voucherservice.api.dao.impl.GiftDaoImpl;
import com.voucherz.voucherservice.api.model.Discount;
import com.voucherz.voucherservice.api.model.Gift;
import com.voucherz.voucherservice.api.service.GiftService;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.voucherz.voucherservice.api.util.VoucherGenUtil.*;

@Service
public class GiftServiceImpl implements GiftService {
    public GiftDaoImpl giftDao;
    private GiftRequest giftRequest;

    public GiftServiceImpl(GiftDaoImpl giftDao) {
        this.giftDao = giftDao;
    }

    @Override
    public Gift createGiftVoucher(GiftRequest giftRequest) {
        String pattern = giftRequest.getPattern();
        String voucherCode = (pattern.isEmpty() || pattern.equals(null)) ? getPatternlessCode(giftRequest) :
            getPatternedCode(giftRequest.getPattern(), giftRequest.getSeparator(), giftRequest.getCharset());

        voucherCode = withPrefix(voucherCode, giftRequest.getPrefix());
        voucherCode = withPostFix(voucherCode, giftRequest.getPostfix());


//        Voucher voucher = new Voucher();
        Gift gift = new Gift();
        gift.setCode(voucherCode);
        gift.setStartDate(giftRequest.getStartDate());
        gift.setExpirationDate(giftRequest.getExpirationDate());
        gift.setStatus(giftRequest.getStatus());
        gift.setVoucherType(giftRequest.getVoucherType());
        gift.setCharset(giftRequest.getCharset());
        gift.setPostfix(giftRequest.getPostfix());
        gift.setPrefix(giftRequest.getPrefix());
        gift.setAdditionalInfo(giftRequest.getAdditionalInfo());
        gift.setMerchantId(giftRequest.getMerchantId());
        gift.setLength(giftRequest.getLength());
        gift.setCategory(giftRequest.getCategory());
        gift.setValue(giftRequest.getValue());

        return giftDao.create(gift);
    }

    @Override
    public List<Gift> getGiftVoucherType(String voucherType) {
        List<Gift> gifts = null;

        if (voucherType.equalsIgnoreCase("Gift")) {
            gifts = giftDao.findByGiftType("Discount");
            return gifts;
        }
        return gifts;
    }



}
