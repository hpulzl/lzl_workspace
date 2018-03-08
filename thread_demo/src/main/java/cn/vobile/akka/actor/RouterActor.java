package cn.vobile.akka.actor;

import akka.actor.ActorRef;
import akka.actor.Terminated;
import akka.actor.UntypedActor;
import akka.routing.ActorRefRoutee;
import akka.routing.RoundRobinRoutingLogic;
import akka.routing.Routee;
import akka.routing.Router;
import cn.vobile.akka.ActorFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * akka的路由策略
 * 1. akka支持并发模型的actor，可以作为任务调度系统来使用，并提供了router来进行消息的调度
 * @author awo
 * @create 2018-03-07 上午11:09
 **/
public class RouterActor extends UntypedActor{

    public static AtomicBoolean FLAG = new AtomicBoolean(true);
    private Router router;

    {
        List<Routee> routees = new ArrayList<>();
        for (int i=0;i<5;i++){
            //创建InboxActor实例
            ActorRef inboxActorRef = ActorFactory.getInstance().create(InboxActor.class,"inboxActor_" + i);
            //监听inboxActorRef
            getContext().watch(inboxActorRef);
            routees.add(new ActorRefRoutee(inboxActorRef));
        }

        /**
         * RoutingLogic(路由策略)
         *  RoundRobinRoutingLogic: 轮询
         * BroadcastRoutingLogic: 广播
         * RandomRoutingLogic: 随机
         * SmallestMailboxRoutingLogic: 空闲
         */
        router = new Router(new RoundRobinRoutingLogic(),routees);
    }

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof InboxActor.InboxMsg){
            System.out.println("分发路由..." + message);
            router.route(message,getSender());
        }else if (message instanceof Terminated){
            //删除关闭的actor
            router = router.removeRoutee(((Terminated) message).actor());
            System.out.println(((Terminated)message).actor().path() + " 该actor已经删除。router.size=" + router.routees().size());
            if (router.routees().size() == 0){
                FLAG.compareAndSet(true,false);
                ActorFactory.getInstance().shutdown();
                System.out.print("没有可用actor了，系统关闭。");
            }
        }else{
            unhandled(message);
        }
    }
}
