package com.voucherz.voucherservice.api.controller;

import com.voucherz.voucherservice.api.controller.model.DiscountRequest;
import com.voucherz.voucherservice.api.dao.DiscountDao;
import com.voucherz.voucherservice.api.model.Discount;
import com.voucherz.voucherservice.api.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "bulk/discount/create", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Discount> createVoucher(@RequestBody @Validated final DiscountRequest discountRequest) {
//        Response response = null;
       int numOfTimeCode = discountRequest.getNumberOfCodeToGenerate();
        Discount voucher = null;
        for (int i = 0; i < numOfTimeCode; i++) {
            voucher = discountService.createVoucher(discountRequest);
        }
        return new ResponseEntity<>(voucher, HttpStatus.CREATED);
    }
    @RequestMapping(value = "single/discount/create", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Discount> createSingleGiftVoucher(@RequestBody @Validated final DiscountRequest discountRequest) {
//        Response response = null;

//        int numOfTimeCode = giftRequest.getNumberOfCodeToGenerate();
        Discount voucher = null;
//        for (int i = 0; i < numOfTimeCode; i++) {
        voucher = discountService.createVoucher(discountRequest);
//        }
        return new ResponseEntity<>(voucher, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/search/{type}", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Discount> findByDiscountType(@PathVariable("type") String voucherType) {

        List<Discount>  vouchers = discountService.getVoucherByType(voucherType);

        return vouchers;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public boolean updateDiscountVoucher(@PathVariable( "id" ) Integer id, @RequestBody @Validated final Discount discount) {
        return discountDao.update(discount);
    }

    @RequestMapping(value = "search/discount/{code}", method = RequestMethod.GET)
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

