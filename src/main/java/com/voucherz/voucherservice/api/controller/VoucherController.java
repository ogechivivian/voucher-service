package com.voucherz.voucherservice.api.controller;

import com.voucherz.voucherservice.api.controller.model.VoucherRequest;
import com.voucherz.voucherservice.api.dao.VoucherDao;
import com.voucherz.voucherservice.api.model.Voucher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/voucher")
public class VoucherController {
    private VoucherDao voucherDao;

    @Autowired
    public VoucherController(VoucherDao voucherDao) {
        this.voucherDao = voucherDao;
    }

    @RequestMapping(value = "/disable/{code}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void disableVoucher(@PathVariable( "code" ) String code) {

       voucherDao.updatestatus(code);
    }

    @RequestMapping(value = "redeem/", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Voucher> createSingleGiftVoucher(@RequestBody @Validated final VoucherRequest voucherRequest){
        Voucher voucher = null;


        return null;
    }
}
