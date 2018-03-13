package cn.vobile.akka.actor;

import akka.actor.*;
import cn.vobile.akka.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 与spring整合的actor，
 * 利用该actor可以使用ioc容器进行注入其他类
 *
 * @author awo
 * @create 2018-03-09 下午2:52
 **/
@Component("integrationWithSpringActor")
@Scope("prototype")
public class IntegrationWithSpringActor extends UntypedActor{

    @Autowired
    private CountService countService;

    private int countResult;

    @Override
    public void onReceive(Object message) throws Exception {
        for (int i=0;i<100;i++){
            countResult = countService.increaseCount();
        }
        System.out.println("count result is " + countResult);
        getContext().stop(getSelf());
    }

}
