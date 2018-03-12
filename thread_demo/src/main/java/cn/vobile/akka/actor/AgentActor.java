package cn.vobile.akka.actor;

import akka.actor.*;
import akka.agent.Agent;
import akka.dispatch.ExecutionContexts;
import akka.dispatch.Futures;
import akka.dispatch.Mapper;
import akka.dispatch.OnComplete;
import com.typesafe.config.ConfigFactory;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

/**
 * 使用agent来实现共享变量的安全处理
 * 1. 设置10个并发actor对countAgent进行累加
 * 2. 累加逻辑：每个actor累加10000次
 * 3. agent可以保证临界值为10w
 *
 * @author awo
 * @create 2018-03-09 上午9:36
 **/
public class AgentActor extends UntypedActor {
    public static final int INCREASE_NUMBER = 10000;
    public static final int ACTOR_NUMBER = 10;

    public static Agent<Integer> countAgent = Agent.create(0, ExecutionContexts.global());
    public static ConcurrentLinkedQueue<Future<Integer>> linkedQueue = new ConcurrentLinkedQueue<>();
    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof Integer){
            //对actor进行累加
            for (int i=0;i<INCREASE_NUMBER;i++){
                Future<Integer> future = countAgent.alter(new Mapper<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer parameter) {
                        return parameter + 1;
                    }
                });
                linkedQueue.add(future);
                //通知inbox我的actor执行完毕
                getContext().stop(getSelf());
            }
        }else {
            unhandled(message);
        }
    }

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("agentSystem", ConfigFactory.load("akka.config"));
        ActorRef[] agentActors = new ActorRef[ACTOR_NUMBER];
        for (int i=0;i<ACTOR_NUMBER;i++){
            agentActors[i] = system.actorOf(Props.create(AgentActor.class),"agentActor_" + i);
        }
        //inbox发送并监视actor
        inboxSendAndWatch(system,agentActors);
        Futures.sequence(linkedQueue,system.dispatcher()).onComplete(new OnComplete<Iterable<Integer>>() {
            @Override
            public void onComplete(Throwable failure, Iterable<Integer> success) throws Throwable {
                System.out.println("result is " + countAgent.get());
                system.shutdown();
            }
        },system.dispatcher());
    }


    public static void inboxSendAndWatch(ActorSystem system,ActorRef[] agentActors){
        Inbox inbox = Inbox.create(system);
        //邮件收发监听每个actor
        for (ActorRef actorRef : agentActors){
            inbox.send(actorRef,1);
            inbox.watch(actorRef);
        }

        int closeCount = 1;
        while (true){
            //inbox接收stop的actor
            Object msg = inbox.receive(Duration.create(1, TimeUnit.SECONDS));
            if (msg instanceof Terminated){
                closeCount++;
            }
            //判断actor都stop，就停止监视
            if (closeCount == ACTOR_NUMBER){
                break;
            }
        }
    }
}
