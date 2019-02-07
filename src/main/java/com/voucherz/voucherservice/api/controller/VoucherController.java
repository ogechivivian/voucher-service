package com.voucherz.voucherservice.api.controller;

import com.voucherz.voucherservice.api.dao.VoucherDao;
import com.voucherz.voucherservice.api.model.Voucher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/voucher")
public class VoucherController {
    private VoucherDao voucherDao;

    @RequestMapping(value = "/disable/{code}", method = RequestMethod.PUT)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable( "code" ) String code, @RequestBody @Validated final Voucher voucher) {
        voucherDao.delete(voucher);
    }
}
