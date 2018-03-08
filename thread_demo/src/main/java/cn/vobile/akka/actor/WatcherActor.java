package cn.vobile.akka.actor;

import akka.actor.ActorRef;
import akka.actor.Terminated;
import akka.actor.UntypedActor;

/**
 * 监听actor
 *
 * @author awo
 * @create 2018-03-06 上午11:21
 **/
public class WatcherActor extends UntypedActor {
    
    public WatcherActor(ActorRef actorRef){
        getContext().watch(actorRef);
    }
    
    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof Terminated){
            getContext().system().shutdown();
        }else {
            unhandled(message);
            System.out.println("unhandled message :" + message);
        }
    }
}
