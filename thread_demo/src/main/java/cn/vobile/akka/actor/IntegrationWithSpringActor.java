package cn.vobile.akka.actor;

import akka.actor.*;
import cn.vobile.akka.service.CountService;
import cn.vobile.akka.spring.SpringExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * 与spring整合的actor，
 * 利用该actor可以使用ioc容器进行注入其他类
 *
 * @author awo
 * @create 2018-03-09 下午2:52
 **/
public class IntegrationWithSpringActor extends UntypedActor{

    private CountService countService;
    private int countResult;

    public void setCountService(CountService countService) {
        this.countService = countService;
    }

    public CountService getCountService() {
        return countService;
    }

    @Override
    public void onReceive(Object message) throws Exception {
        for (int i=0;i<100;i++){
            countResult = countService.increaseCount();
        }
        System.out.println("count result is " + countResult);
        getContext().stop(getSelf());
    }


    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        //获取actorSystem
        ActorSystem actorSystem = (ActorSystem) applicationContext.getBean("actorSystem");
        //创建springExt对象
        SpringExtension.SpringExt springExt = SpringExtension.getInstance().get(actorSystem);
        //初始化数据
        springExt.initialize(applicationContext);
        ActorRef actorRef = actorSystem.actorOf(springExt.props("integrationWithSpringActor"),"integrationWithSpringActor");

        //监听actor执行完毕后，直接退出system
        actorSystem.actorOf(Props.create(WatcherActor.class,actorRef),"watcherActor");

        actorRef.tell(1,ActorRef.noSender());


    }
}
