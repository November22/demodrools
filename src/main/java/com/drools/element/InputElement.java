package com.drools.element;

import com.drools.model.Element;

/**
 * @author sen.huang
 *         Date: 2018/8/7
 */
public class InputElement extends Element{

    private static final String NAME = "文本框";
    private static final String KEY = "input";

    public InputElement(){
        super.key = KEY;
        super.name = NAME;
    }

}
