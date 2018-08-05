package com.drools.model;

import java.math.BigDecimal;

/**
 * @author sen.huang
 * @date 2018/8/5.
 */
public class Fact {
    private BigDecimal orderAmount;

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }
}
