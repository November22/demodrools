package com.drools.test;

import com.drools.model.Customer;
import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.definition.KnowledgePackage;
import org.drools.io.impl.ClassPathResource;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.rule.FactHandle;

import java.util.Collection;
import java.util.List;

/**
 * @author sen.huang
 * @date 2018/8/5.
 */
public class TestFunction {
    public static void main(String[] args) {
        KnowledgeBuilder knowledgeBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        knowledgeBuilder.add(new ClassPathResource("drl/test-function.drl"), ResourceType.DRL);
        Collection<KnowledgePackage> packages = knowledgeBuilder.getKnowledgePackages();
        KnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
        knowledgeBase.addKnowledgePackages(packages);

        StatefulKnowledgeSession session = knowledgeBase.newStatefulKnowledgeSession();
        session.fireAllRules();
        session.dispose();
        System.out.println("===========end===========");
    }
}
