//package com.voucherz.voucherservice.api.service.impl;
//
//import com.voucherz.voucherservice.api.controller.model.VoucherRequest;
//import com.voucherz.voucherservice.api.dao.impl.VoucherDaoImpl;
//import com.voucherz.voucherservice.api.model.Gift;
//import com.voucherz.voucherservice.api.model.Voucher;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//
//
//@Service
//public class VoucherServiceImpl {
//    public VoucherDaoImpl voucherDao;
//    public Voucher voucher;
//
//    public VoucherServiceImpl(VoucherDaoImpl voucherDao, Voucher voucher) {
//        this.voucherDao = voucherDao;
//        this.voucher = voucher;
//    }
//
//    public String redeemingVoucher(String code, VoucherRequest voucherRequest){
//        Voucher voucher = voucherDao.findByCode(code);
//          Date currentdate = new Date();
//        if (voucher.getVoucherType().equalsIgnoreCase("Value") || voucher.getVoucherType().equalsIgnoreCase("Discount")){
//            if (voucher == null)
//            {
//                return "Voucher not Exist";
//            }
//            if (voucher.getExpirationDate().after(currentdate)){
//                return "Expired Voucher";
//            }
//
//
//                voucherDao.updatestatus(code);
//
//        }
//        else if(voucher.getVoucherType().equalsIgnoreCase("Gift")){
//            Gift gift = voucherDao.findGiftCode(voucher.getId());
//
//            if (gift !=null){
//                if (gift.getValue() >= gift.getTotalUsed() + )
//            }
//        }
//            Gift gift = voucherDao.
//
//    }
//
//
//}
