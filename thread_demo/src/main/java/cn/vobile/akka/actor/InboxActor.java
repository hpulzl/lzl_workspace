package cn.vobile.akka.actor;

import akka.actor.UntypedActor;

/**
 * 作为消息收件箱的实例
 *
 * @author awo
 * @create 2018-03-06 上午11:34
 **/
public class InboxActor extends UntypedActor{

    public enum InboxMsg{
        WORKING,DONE,CLOSE
    }

    @Override
    public void preStart() throws Exception {
        System.out.println("[InboxActor] pre start...");
    }

    @Override
    public void postStop() throws Exception {
        System.out.println("[InboxActor] post stop...");
    }

    @Override
    public void onReceive(Object message) throws Exception {
        if (InboxMsg.WORKING.equals(message)){
            System.out.println("[InboxActor] i am working");
        }else if (InboxMsg.DONE.equals(message)){
            System.out.println("[InboxActor] stop working");
        }else if (InboxMsg.CLOSE.equals(message)){
            System.out.println("[InboxActor] close working");
            //告诉消息发送者，我要关闭了
            getSender().tell(InboxMsg.CLOSE, getSelf());
            getContext().stop(getSelf());
        }else {
            unhandled(message);
        }
    }

}
