package cn.vobile.akka.actor;

import akka.actor.UntypedActor;

/**
 * 用于接收MainActor处理的结果。并进行相应的逻辑处理
 *
 * @author awo
 * @create 2018-03-07 下午5:15
 **/
public class PrintActor extends UntypedActor {

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof Integer){
            System.out.println("[PrintActor] 接收到信息：" + message);
        }else {
            unhandled(message);
        }
    }
}
