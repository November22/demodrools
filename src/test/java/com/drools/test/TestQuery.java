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
import org.drools.runtime.rule.QueryResults;
import org.drools.runtime.rule.QueryResultsRow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author sen.huang
 * @date 2018/8/5.
 */
public class TestQuery {
    public static void main(String[] args) {
        KnowledgeBuilder knowledgeBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        knowledgeBuilder.add(new ClassPathResource("drl/test-query.drl"), ResourceType.DRL);
        Collection<KnowledgePackage> packages = knowledgeBuilder.getKnowledgePackages();
        KnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
        knowledgeBase.addKnowledgePackages(packages);

        StatefulKnowledgeSession session = knowledgeBase.newStatefulKnowledgeSession();
        List<Customer> customerList = getCustomerList();
        for(Customer customer:customerList){
            FactHandle insert = session.insert(customer);
        }
        //执行query需要在dispose之前
        QueryResults queryResults = session.getQueryResults("testQuery");
        for (QueryResultsRow qr : queryResults) {
            Customer c = (Customer)qr.get("customer");
            System.out.println(c);
        }

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
