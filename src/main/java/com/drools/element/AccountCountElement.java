package com.drools.element;

import com.drools.model.Element;

/**
 * @author sen.huang
 *         Date: 2018/8/7
 */
public class AccountCountElement extends Element {
    private static final String NAME = "账户数量";
    private static final String KEY = "accountCount";

    public AccountCountElement(){
        super.key = KEY;
        super.name = NAME;
    }
}
