package com.drools.billtemplate;

import com.drools.dto.RuleTemplateDTO;
import com.drools.dto.TemplateDTO;
import com.drools.facade.TemplateFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author sen.huang
 *         Date: 2018/8/7
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:application-drools-test.xml")
public class TestBill {

    @Autowired
    private TemplateFacade facade;

    @Test
    public void test(){
        RuleTemplateDTO ruleTemplateDTO = new RuleTemplateDTO();
        TemplateDTO templateDTO = new TemplateDTO();


    }

}
