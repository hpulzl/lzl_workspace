package cn.vobile.akka.actor;

import akka.actor.UntypedActor;

/**
 * Actor中的Future-询问模式
 * <p>1. 作为主actor，通过akka中的future将MainActor的返回结果重定向PrintActor来处理</p>
 * @author awo
 * @create 2018-03-07 下午5:07
 **/
public class MainActor extends UntypedActor {

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof Integer){
            System.out.println("[MainActor] 接收到信息：" + message);
            getSender().tell(message,getSelf());
        }else {
            unhandled(message);
        }
    }
}
