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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author sen.huang
 *         Date: 2018/8/2
 */
public class TestDrl1 {
    public static void main(String[] args) {
        KnowledgeBuilder knowledgeBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        knowledgeBuilder.add(new ClassPathResource("drl/test1.drl"), ResourceType.DRL);
        Collection<KnowledgePackage> packages = knowledgeBuilder.getKnowledgePackages();
        KnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
        knowledgeBase.addKnowledgePackages(packages);

        StatefulKnowledgeSession session = knowledgeBase.newStatefulKnowledgeSession();
        List<Customer> customerList = getCustomerList();
        for(Customer customer:customerList){
            FactHandle insert = session.insert(customer);
        }
        session.fireAllRules();
        session.dispose();
        System.out.println("===========end===========");
    }


    public static List<Customer> getCustomerList(){
        List<Customer> customers = new ArrayList<Customer>();
        customers.add(new Customer("小三",23,false));
        customers.add(new Customer("小四",26,true));
        customers.add(new Customer("小五",29,false));
        customers.add(new Customer("小六",32,true));
        customers.add(new Customer("小七",35,false));
        customers.add(new Customer("小八",38,true));
        return customers;
    }
}
