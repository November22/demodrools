package com.drools.dto;

import com.drools.model.Element;

import java.util.List;

/**
 * @author sen.huang
 *         Date: 2018/8/6
 */
public class TemplateDTO {
    /**
     * 模板条件
     */
    private List<Element> conditions;

    /**
     * 计算规则
     */
    private Element calculate;

    /**
     * 结果规则
     */
    private List<Element> results;

    public List<Element> getConditions() {
        return conditions;
    }

    public void setConditions(List<Element> conditions) {
        this.conditions = conditions;
    }

    public Element getCalculate() {
        return calculate;
    }

    public void setCalculate(Element calculate) {
        this.calculate = calculate;
    }

    public List<Element> getResults() {
        return results;
    }

    public void setResults(List<Element> results) {
        this.results = results;
    }
}
