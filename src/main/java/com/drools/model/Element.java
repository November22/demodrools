package com.drools.model;

/**
 * @author sen.huang
 *         Date: 2018/8/6
 *         Template决定每个规则的长度，输入框的内容的类型
 */
public class Element {
    /**
     * 输入元素的类型
     */
    protected String key;

    /**
     * 输入元素类型的名称
     */
    protected String name;

    /**
     * 加减乘除空
     */
    protected String operator;

    /**
     * 下一个元素
     */
    private Element rightElement;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Element getRightElement() {
        return rightElement;
    }

    public void setRightElement(Element rightElement) {
        this.rightElement = rightElement;
    }
}
