package com.voucherz.voucherservice.api.controller;

import com.voucherz.voucherservice.api.dao.RedeemptionDao;
import com.voucherz.voucherservice.api.model.Redeemption;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/voucher")
public class RedeemptionController {

    private RedeemptionDao redeemptionDao;
    public RedeemptionController(RedeemptionDao redeemptionDao) {
        this.redeemptionDao = redeemptionDao;
    }

//    @RequestMapping(value = "redeemption/{code}", method = RequestMethod.PUT)
//    @ResponseStatus(HttpStatus.OK)
//    public boolean updateDiscountVoucher(@PathVariable( "id" ) Integer id, @RequestBody @Validated final Redeemption redeemption) {
//        return redeemptionDao.update(redeemption);
//    }
}
