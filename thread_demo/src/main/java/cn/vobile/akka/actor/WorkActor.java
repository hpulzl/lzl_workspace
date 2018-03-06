package cn.vobile.akka.actor;

import akka.actor.UntypedActor;

/**
 * 工作actor
 *
 * @author awo
 * @create 2018-03-06 上午11:34
 **/
public class WorkActor extends UntypedActor{

    public enum MsgEnum{
        WORKING,DONE,CLOSE
    }

    @Override
    public void preStart() throws Exception {
        System.out.println("workActor pre start...");
    }

    @Override
    public void postStop() throws Exception {
        System.out.println("workActor post stop...");
    }

    @Override
    public void onReceive(Object message) throws Exception {
        if (MsgEnum.WORKING.equals(message)){
            System.out.println("i am working");
        }else if (MsgEnum.DONE.equals(message)){
            System.out.println("stop working");
        }else if (MsgEnum.CLOSE.equals(message)){
            System.out.println("close working");
            getSender().tell(MsgEnum.CLOSE, getSelf());
            getContext().stop(getSelf());
        }else {
            unhandled(message);
        }
    }

}
