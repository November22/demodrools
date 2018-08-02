package com.drools;

import com.drools.utils.Constants;
import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseConfiguration;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.definition.KnowledgePackage;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author sen.huang
 * @date 2018/7/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-drools-test.xml"})
public class test {

    private static Map<String,KnowledgeBase> knowledgeBasePool = new ConcurrentHashMap<String, KnowledgeBase>();

    private static String drl1 = "";
    private static String[] drls = {drl1};
    private static KnowledgeBase knowledgeBase;

    //将规则加入规则引擎
    static {
        if(drls.length > 0 ){
            //遍历规则文件
            for(String drl:drls){
                StringBuffer drlSb = new StringBuffer(drl);
                drlSb.insert(0,Constants.PACKAGE_STR+Constants.USER_FACT_PACKAGE);
                byte[] drlBytes = drlSb.toString().getBytes();
                //KnowledgeBuilder：用于收集规则文件，同时生成一批编译好的规则包
                KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
                kbuilder.add(ResourceFactory.newByteArrayResource(drlBytes), ResourceType.DRL);
                //验证规则文件是否有错误
                boolean hasErrors = kbuilder.hasErrors();

                //有错
                if(hasErrors){
                    KnowledgeBuilderErrors errors = kbuilder.getErrors();
                    StringBuffer errorMsg = new StringBuffer();
                    //取出错误信息
                    for(KnowledgeBuilderError error:errors){
                        errorMsg.append(error.getMessage());
                    }
                    System.out.println("规则文件错误信息["+errorMsg.toString()+"]");
                    throw new RuntimeException("规则存在错误:"+errorMsg.toString());
                }

                //生成规则包
                Collection<KnowledgePackage> knowledgePackages = kbuilder.getKnowledgePackages();
                //kbConf用来存放规则引擎运行时相关环境参数定义的配置
                KnowledgeBaseConfiguration base = KnowledgeBaseFactory.newKnowledgeBaseConfiguration();
                //KnowledgeBaseConfiguration 用来存放规则引擎运行时的相关环境参数设置
                base.setProperty("org.drools.sequential", "true");
                knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase(base);

                knowledgeBase.addKnowledgePackages(knowledgePackages);
            }
        }else{
            throw new RuntimeException("没有对应的规则");
        }
    }

    @Test
    public void testDrl1(){
        //与规则引擎进行交互
        StatefulKnowledgeSession session = knowledgeBase.newStatefulKnowledgeSession();

    }
}
