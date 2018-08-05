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

/**
 * @author sen.huang
 * @date 2018/8/5.
 */
public class TestAgendaGroup {

    public static void main(String[] args) {
        KnowledgeBuilder knowledgeBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        knowledgeBuilder.add(new ClassPathResource("drl/test4-agenda-group.drl"),ResourceType.DRL);
        Collection<KnowledgePackage> knowledgePackages = knowledgeBuilder.getKnowledgePackages();
        KnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
        knowledgeBase.addKnowledgePackages(knowledgePackages);
        StatefulKnowledgeSession session = knowledgeBase.newStatefulKnowledgeSession();
        //激活
        session.getAgenda().getAgendaGroup("test").setFocus();

        FactHandle handle = session.insert(new Customer("小八", 38, true));
        session.fireAllRules();
        session.dispose();
        //删除工作内存中对象，防止内存泄漏
        session.retract(handle);
    }
}
