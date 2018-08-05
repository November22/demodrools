package com.drools.test;

import com.drools.model.Fact;
import com.drools.model.Result;
import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.definition.KnowledgePackage;
import org.drools.io.impl.ClassPathResource;
import org.drools.runtime.StatefulKnowledgeSession;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * @author sen.huang
 * @date 2018/8/5.
 */
public class TestJd {
    public static void main(String[] args) {
        KnowledgeBuilder kb = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kb.add(new ClassPathResource("drl/test2.drl"),ResourceType.DRL);
        Collection<KnowledgePackage> kp = kb.getKnowledgePackages();
        //验证错误信息
        if(kb.hasErrors()){
            System.out.println("规则文件错误"+kb.getErrors());
            return;
        }
        KnowledgeBase base = KnowledgeBaseFactory.newKnowledgeBase();
        base.addKnowledgePackages(kp);
        base.getStatefulKnowledgeSessions();
        StatefulKnowledgeSession session = base.newStatefulKnowledgeSession();

        Fact fact = new Fact();
        fact.setOrderAmount(new BigDecimal(250));
        session.insert(fact);
        session.setGlobal("rt",new Result());
        session.fireAllRules();
        Object result = session.getGlobal("rt");
        System.out.println(result);

    }
}
