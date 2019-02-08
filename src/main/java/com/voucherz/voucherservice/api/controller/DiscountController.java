package com.voucherz.voucherservice.api.controller;

import com.voucherz.voucherservice.api.controller.model.DiscountRequest;
import com.voucherz.voucherservice.api.dao.DiscountDao;
//import com.voucherz.voucherservice.api.event.AuditMessage;
import com.voucherz.voucherservice.api.model.Discount;
import com.voucherz.voucherservice.api.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("api/voucher")
@CrossOrigin("*")
public class DiscountController {

    private DiscountService discountService;

    private DiscountDao discountDao;

    @Autowired
    public DiscountController(DiscountService discountService, DiscountDao discountDao) {
        this.discountService = discountService;
        this.discountDao = discountDao;
    }

    @RequestMapping(value = "discount/bulk/create", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Discount> createVoucher(@RequestBody @Validated final DiscountRequest discountRequest) {
//        Response response = null;
       int numOfTimeCode = discountRequest.getNumberOfCodeToGenerate();
        Discount voucher = null;
        for (int i = 0; i < numOfTimeCode; i++) {
//            AuditMessage event =new AuditMessage("created bulk voucher", "merchantid", new Date());
            voucher = discountService.createVoucher(discountRequest);
        }
        return new ResponseEntity<>(voucher, HttpStatus.CREATED);
    }
    @RequestMapping(value = "discount/single/create", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Discount> createSingleGiftVoucher(@RequestBody @Validated final DiscountRequest discountRequest) {
//        Response response = null;

//        int numOfTimeCode = giftRequest.getNumberOfCodeToGenerate();
        Discount voucher = null;
//        for (int i = 0; i < numOfTimeCode; i++) {
        //            AuditMessage event =new AuditMessage("created bulk voucher", "merchantid", new Date());
        voucher = discountService.createVoucher(discountRequest);
//        }
        return new ResponseEntity<>(voucher, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/search/bytype/{type}", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Discount> findByDiscountType(@PathVariable("type") String voucherType) {


        List<Discount>  vouchers = discountService.getVoucherByType(voucherType);

        return vouchers;
    }

    @RequestMapping(value = "/update/discount/{code}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateDiscountVoucher(@PathVariable( "code" ) String code, @RequestBody @Validated final Discount discount) {

        discountDao.update(discount);
    }

    @RequestMapping(value = "/discount/search/{code}", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Discount findByDiscountCode(@PathVariable( "code" ) String code) {
        Discount discount = discountDao.findByDiscountCode(code);
        return discount;
    }
//    @RequestMapping(value = "search/gift/{code}", method = RequestMethod.GET)
//    @ResponseBody
//    @ResponseStatus(HttpStatus.OK)
//    public Gift findByGiftCode(@PathVariable( "code" ) String code) {
//        Gift gift = giftDao.findByGiftCode(code);
//        return gift;
//    }
}
//    private final DiscountDao discountDao;
//
//    public DiscountController(DiscountDao discountDao) {
//        this.discountDao = discountDao;
//    }

//    @RequestMapping(method = RequestMethod.POST)
//    @ResponseBody
//    @ResponseStatus(HttpStatus.CREATED)
//    public Discount createDiscount(@RequestBody @Validated final Discount discount){
////        generatedcode = VoucherGenUtil.generateVoucher();
////        System.out.println("Yawa don gas" + discount.getDiscountTypeId());
//
//        return discountService.createDiscount(discount);
//    }

