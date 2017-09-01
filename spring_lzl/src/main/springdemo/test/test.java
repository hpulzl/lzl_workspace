package test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import entity.Person;

/**
 * @Author: li_zhilei
 * @Date: create in 11:11 17/5/3.
 * @description:
 */
public class test {
    public static void main(String[] args) {
        //通过xml创建bean
        xmlBeanFactory();
        //编程式创建bean
        defaultListableBeanFactory();
    }
    public static void defaultListableBeanFactory(){
        //加载配置文件
        ClassPathResource resource = new ClassPathResource("ApplicationContext.xml");
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(resource);
        //输出
        Person p = (Person) factory.getBean("person");
        System.out.println("p = " + p);
    }
    public static void xmlBeanFactory(){
        //加载配置文件
        ClassPathResource resource = new ClassPathResource("ApplicationContext.xml");
        //解析文件
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        //创建对应bean,依赖注入过程
        Person p = (Person) beanFactory.getBean("person");
        System.out.println("p = " + p);
    }
}
