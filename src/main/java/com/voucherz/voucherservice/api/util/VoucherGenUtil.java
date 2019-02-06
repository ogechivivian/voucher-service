package com.voucherz.voucherservice.api.util;



import com.voucherz.voucherservice.api.controller.model.DiscountRequest;
import com.voucherz.voucherservice.api.controller.model.GiftRequest;
import com.voucherz.voucherservice.api.controller.model.ValueRequest;

import java.util.Random;

public class VoucherGenUtil {

    public static String getAlphaNumericString(int n)
    {
        // chose a Character random from this String
        String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index = (int)(alphaNumericString.length() * Math.random());

            // add Character one by one in end of sb
            sb.append(alphaNumericString.charAt(index));
        }
        return sb.toString();
    }
    public static String getLowerCaseAlphabet(int n){
        String lowercase = "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(n);
        for (int i =0; i < n; i++){
            int index = (int)(lowercase.length()* Math.random());
            sb.append(lowercase.charAt(index));
            System.out.println(sb);
        }

        return sb.toString();
    }

    public static String getUpperCaseAlphabet(int n){
        String numeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder(n);
        for (int i =0; i < n; i++){
            int index = (int)(numeric.length()* Math.random());
            sb.append(numeric.charAt(index));
        }
        return sb.toString();
    }

    public static String getNumeric(int n){
        String numeric = "0123456789";
        StringBuilder sb = new StringBuilder(n);
        for (int i =0; i < n; i++){
            int index = (int)(numeric.length()* Math.random());
            sb.append(numeric.charAt(index));
        }
        return sb.toString();
    }

    public static String getPatternedCode(String pattern, String separator, String charset){
        int sep = pattern.indexOf(separator);
        String beforeSeparator = pattern.substring(0, sep);
        String afterSeparator = pattern.substring(sep);
        int beforeCount = beforeSeparator.length();
        int afterCount = afterSeparator.length();

        String codeBefore;
        String codeAfter;

        switch (charset.toLowerCase()) {
            case "lower":
                codeBefore = getLowerCaseAlphabet(beforeCount);
                codeAfter = getLowerCaseAlphabet(afterCount);
                break;
            case "upper":
                codeBefore = getUpperCaseAlphabet(beforeCount);
                codeAfter = getUpperCaseAlphabet(afterCount);
                break;
            case "number":
                codeBefore = getNumeric(beforeCount);
                codeAfter = getNumeric(afterCount);
                break;
            default:
                codeBefore = getAlphaNumericString(beforeCount);
                codeAfter = getAlphaNumericString(afterCount);
                break;
        }

        String patternedCode = String.format("%s%s%s", codeBefore, separator, codeAfter);
        return patternedCode;

    }

    public static String withPrefix(String code, String prefix) {
        return prefix + code;
    }

    public static String withPostFix(String code, String postfix) {
        return code + postfix;
    }


    public static String  getPatternlessCode(DiscountRequest discountRequest){

        String generatedCode;


        if (discountRequest.getCharset().equalsIgnoreCase("AlphaNumeric")) {
            generatedCode = VoucherGenUtil.getAlphaNumericString(discountRequest.getLength());
            discountRequest.setCode(generatedCode);
        }
        else if (discountRequest.getCharset().equalsIgnoreCase("Numeric")){
            generatedCode = VoucherGenUtil.getNumeric(discountRequest.getLength());
            discountRequest.setCode(generatedCode);
        }
        else if (discountRequest.getCharset().equalsIgnoreCase("Lowercase")){
            generatedCode = VoucherGenUtil.getLowerCaseAlphabet(discountRequest.getLength());
            discountRequest.setCode(generatedCode);
            discountRequest.setCode(generatedCode);
        }

        else {
            generatedCode = VoucherGenUtil.getUpperCaseAlphabet(discountRequest.getLength());
            discountRequest.setCode(generatedCode);
        }

        return generatedCode;
    }

    public static String  getPatternlessCode(ValueRequest valueRequest){

        String generatedCode;


        if (valueRequest.getCharset().equalsIgnoreCase("AlphaNumeric")) {
            generatedCode = VoucherGenUtil.getAlphaNumericString(valueRequest.getLength());
            valueRequest.setCode(generatedCode);
        }
        else if (valueRequest.getCharset().equalsIgnoreCase("Numeric")){
            generatedCode = VoucherGenUtil.getNumeric(valueRequest.getLength());
            valueRequest.setCode(generatedCode);
        }
        else if (valueRequest.getCharset().equalsIgnoreCase("Lowercase")){
            generatedCode = VoucherGenUtil.getLowerCaseAlphabet(valueRequest.getLength());
            valueRequest.setCode(generatedCode);
        }

        else {
            generatedCode = VoucherGenUtil.getUpperCaseAlphabet(valueRequest.getLength());
            valueRequest.setCode(generatedCode);
        }

        return generatedCode;
    }

    public static String  getPatternlessCode(GiftRequest giftRequest){

        String generatedCode;


        if (giftRequest.getCharset().equalsIgnoreCase("AlphaNumeric")) {
            generatedCode = VoucherGenUtil.getAlphaNumericString(giftRequest.getLength());
            giftRequest.setCode(generatedCode);
        }
        else if (giftRequest.getCharset().equalsIgnoreCase("Numeric")){
            generatedCode = VoucherGenUtil.getNumeric(giftRequest.getLength());
            giftRequest.setCode(generatedCode);
        }
        else if (giftRequest.getCharset().equalsIgnoreCase("Lowercase")){
            generatedCode = VoucherGenUtil.getLowerCaseAlphabet(giftRequest.getLength());
            giftRequest.setCode(generatedCode);
        }

        else {
            generatedCode = VoucherGenUtil.getUpperCaseAlphabet(giftRequest.getLength());
            giftRequest.setCode(generatedCode);
        }

        return generatedCode;
    }
}