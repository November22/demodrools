package com.drools.model;

import java.math.BigDecimal;

/**
 * @author sen.huang
 * @date 2018/8/5.
 */
public class Result {
    private BigDecimal fee;

    public void addFee(BigDecimal addFee){
        if(fee == null){
            fee = addFee;
        }else{
            fee = fee.add(addFee);
        }
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Result{" +
                "fee=" + fee +
                '}';
    }
}
