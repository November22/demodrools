package com.drools.element;

import com.drools.model.Element;

/**
 * @author sen.huang
 *         Date: 2018/8/7
 */
public class OrderAmountElement extends Element{
    private static final String NAME = "订单金额";
    private static final String KEY = "orderAmount";

    public OrderAmountElement(){
        super.key = KEY;
        super.name = NAME;
    }
}
