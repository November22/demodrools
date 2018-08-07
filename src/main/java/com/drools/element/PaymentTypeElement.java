package com.drools.element;

import com.drools.model.Element;

/**
 * @author sen.huang
 *         Date: 2018/8/7
 */
public class PaymentTypeElement extends Element{
    private static final String NAME = "支付方式";
    private static final String KEY = "paymentType";

    public PaymentTypeElement(){
        super.key = KEY;
        super.name = NAME;
    }
}
