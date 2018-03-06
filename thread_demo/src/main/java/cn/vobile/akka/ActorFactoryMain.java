package cn.vobile.akka;

import akka.actor.ActorRef;
import akka.actor.PoisonPill;
import cn.vobile.akka.actor.WatcherActor;
import cn.vobile.akka.actor.WorkActor;

/**
 * 主函数
 *
 * @author awo
 * @create 2018-03-06 上午11:52
 **/
public class ActorFactoryMain {

    public static void main(String[] args) {
       ActorRef workActor =  ActorFactory.getInstance().create(WorkActor.class,"workActor");
       ActorRef watcherActor =  ActorFactory.getInstance().create(WatcherActor.class,workActor,"watcherActor");

       workActor.tell(WorkActor.MsgEnum.WORKING,ActorRef.noSender());
       workActor.tell(WorkActor.MsgEnum.DONE,ActorRef.noSender());

        //中断workActor
        workActor.tell(PoisonPill.getInstance(), ActorRef.noSender());
    }
}
