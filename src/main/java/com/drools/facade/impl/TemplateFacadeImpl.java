package com.drools.facade.impl;

import com.alibaba.fastjson.JSON;
import com.drools.dto.RuleTemplateDTO;
import com.drools.facade.TemplateFacade;

/**
 * @author sen.huang
 *         Date: 2018/8/7
 */
public class TemplateFacadeImpl implements TemplateFacade {

    @Override
    public RuleTemplateDTO create(RuleTemplateDTO templateDTO) {
        String ruleTemplateDetails = JSON.toJSONString(templateDTO.getTemplateDTO());
        System.out.println("计费规则模板文件["+ruleTemplateDetails+"]");
        return null;
    }
}
