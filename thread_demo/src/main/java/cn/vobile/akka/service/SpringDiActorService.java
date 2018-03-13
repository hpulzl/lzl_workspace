package cn.vobile.akka.service;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import cn.vobile.akka.actor.WatcherActor;
import cn.vobile.akka.di.SpringExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * akka与spring整合
 *
 * @author awo
 * @create 2018-03-13 下午2:07
 **/
@Service
public class SpringDiActorService {
    @Autowired
    private SpringExtension springExtension;

    public void doSpringActor(ApplicationContext applicationContext){
        //获取actorSystem
        ActorSystem actorSystem = (ActorSystem) applicationContext.getBean("actorSystem");
        //初始化数据
        springExtension.initialize(applicationContext);
        ActorRef actorRef = actorSystem.actorOf(springExtension.props("integrationWithSpringActor"),"integrationWithSpringActor");

        //监听actor执行完毕后，直接退出system
        actorSystem.actorOf(Props.create(WatcherActor.class,actorRef),"watcherActor");

        actorRef.tell(1,ActorRef.noSender());
    }

}
