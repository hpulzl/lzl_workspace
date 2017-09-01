package test;

import aop.AbcInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: li_zhilei
 * @Date: create in 10:33 17/7/18.
 * @description:
 */
public class AopTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        AbcInterface testTarget = (AbcInterface) applicationContext.getBean("testProxy");
        testTarget.method();
    }
}
