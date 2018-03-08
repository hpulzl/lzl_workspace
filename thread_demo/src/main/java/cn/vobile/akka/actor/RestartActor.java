package cn.vobile.akka.actor;

import akka.actor.UntypedActor;
import scala.Option;

/**
 * 重启的actor
 * 了解actor的生命周期
 * @author awo
 * @create 2018-03-06 下午3:04
 **/
public class RestartActor extends UntypedActor{

    public enum RestartMsg{
        DONE,RESTART
    }
    @Override
    public void preStart() throws Exception {
        super.preStart();
        System.out.println("[RestartActor] pre start " + hashCode());
    }

    @Override
    public void preRestart(Throwable reason, Option<Object> message) throws Exception {
        super.preRestart(reason, message);
        System.out.println("[RestartActor] pre restart " + hashCode());

    }

    @Override
    public void postRestart(Throwable reason) throws Exception {
        super.postRestart(reason);
        System.out.println("[RestartActor] post Restart " + hashCode());
    }

    @Override
    public void postStop() throws Exception {
        super.postStop();
        System.out.println("[RestartActor] post stop" + hashCode());
    }

    @Override
    public void onReceive(Object message) throws Exception {
        if (RestartMsg.DONE.equals(message)){
            getContext().system().shutdown();
        }else if (RestartMsg.RESTART.equals(message)){
            //模拟一个异常信息,by zero
//            int i = 1 / 0;
            // nullPointException
            throw new NullPointerException();
        }else{
            unhandled(message);
        }
    }
}
