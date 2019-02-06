package com.voucherz.voucherservice.api.controller;


import com.voucherz.voucherservice.api.controller.model.GiftRequest;
import com.voucherz.voucherservice.api.dao.GiftDao;
import com.voucherz.voucherservice.api.model.Gift;
import com.voucherz.voucherservice.api.service.GiftService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("api/voucher")
public class GiftController {
    private GiftService giftService;
    private final GiftDao giftDao;

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public GiftController(GiftService giftService, GiftDao giftDao) {
        this.giftService = giftService;
        this.giftDao = giftDao;
    }

    @RequestMapping(value = "bulk/gift/create", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Gift> createGiftVoucher(@RequestBody @Validated final GiftRequest giftRequest) {
//        Response response = null;
        int numOfTimeCode = giftRequest.getNumberOfCodeToGenerate();
        Gift voucher = null;
        for (int i = 0; i < numOfTimeCode; i++) {

            voucher = giftService.createGiftVoucher(giftRequest);
            log.info(String.format("Bulk Gift Voucher Created"), voucher);
        }
        return new ResponseEntity<>(voucher, HttpStatus.CREATED);
    }

    @RequestMapping(value = "single/gift/create", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Gift> createSingleGiftVoucher(@RequestBody @Validated final GiftRequest giftRequest) {
//        Response response = null;

//        int numOfTimeCode = giftRequest.getNumberOfCodeToGenerate();
        Gift voucher = null;
//        for (int i = 0; i < numOfTimeCode; i++) {
            voucher = giftService.createSingleGiftVoucher(giftRequest);
//        }
        return new ResponseEntity<>(voucher, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/search/*/{type}", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Gift> findByGiftType(@PathVariable("type") String voucherType) {

        List<Gift>  vouchers = giftService.getGiftVoucherType(voucherType);

        return vouchers;
    }
    @RequestMapping(value = "update/gift/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public boolean updateGiftVoucher(@PathVariable( "id" ) Integer id, @RequestBody @Validated final Gift gift) {
        return giftDao.update(gift);
    }

    @RequestMapping(value = "search/gift/{code}", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Gift findByGiftCode(@PathVariable( "code" ) String code) {
        Gift gift = giftDao.findByGiftCode(code);
        return gift;
    }
}
