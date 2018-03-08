package cn.vobile.akka.actor;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;
import akka.japi.Procedure;

/**
 * 状态切换的actor实例
 * TODO http://ifeve.com/akka-doc-java-untyped-actors/ 中解释，在角色消息循环中，进行实时替换。不太明白运用场景
 * @author awo
 * @create 2018-03-07 下午2:43
 **/
public class ProcedureActor extends UntypedActor {

    public enum ProcedureMsg{
        SLEEP,WORK
    }

    /**
     * 设计两个procedure，代表两个程序状态。
     * go to sleep, i am happy；do work, i am angry。
     * angryProcedure
     * happyProcedure
     */
    Procedure<Object> angryProcedure = new Procedure<Object>() {
        @Override
        public void apply(Object param) throws Exception {
            System.out.println("i am angry " + param);
            if (ProcedureMsg.WORK.equals(param)){
                System.out.println("do work ，status :" + param);
                getSelf().tell("do work, i am angry ", ActorRef.noSender());
            }else if (ProcedureMsg.SLEEP.equals(param)){
                System.out.println("go to sleep, status " + param);
                getContext().become(happyProcedure);
            }
        }
    };

    Procedure<Object> happyProcedure = new Procedure<Object>() {
        @Override
        public void apply(Object param) throws Exception {
            System.out.println("i am happy " + param);
            if (ProcedureMsg.SLEEP.equals(param)){
                System.out.println("go to sleep ，status :" + param);
                getSelf().tell("go to sleep, i am happy", ActorRef.noSender());
            }else if (ProcedureMsg.WORK.equals(param)){
                System.out.println("do work, status" + param);
                //热替换角色
                getContext().become(angryProcedure);
            }
        }
    };

    @Override
    public void onReceive(Object message) throws Exception {
        System.out.println("接收到消息:" + message);
        if (ProcedureMsg.WORK.equals(message)){
            getContext().become(angryProcedure);
        }else if (ProcedureMsg.SLEEP.equals(message)){
            getContext().become(happyProcedure);
        }
    }
}
