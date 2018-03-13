package cn.vobile.akka.di;

import akka.actor.Actor;
import akka.actor.IndirectActorProducer;
import org.springframework.context.ApplicationContext;

/**
 * 通过spring来注入actor
 *
 * @author awo
 * @create 2018-03-09 下午3:09
 **/
public class SpringActorProducer implements IndirectActorProducer{

    private ApplicationContext applicationContext;

    private String actorBeanName;

    public SpringActorProducer(ApplicationContext applicationContext,String actorBeanName){
        this.applicationContext = applicationContext;
        this.actorBeanName = actorBeanName;
    }

    @Override
    public Actor produce() {
        return (Actor) applicationContext.getBean(actorBeanName);
    }

    @Override
    public Class<? extends Actor> actorClass() {
        return (Class<? extends Actor>) applicationContext.getType(actorBeanName);
    }
}
