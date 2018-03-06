package cn.vobile.akka.actor;

import akka.actor.UntypedActor;
import com.alibaba.fastjson.JSON;

/**
 * 创建一个actor实例，具体实现并发方法
 *
 * @author awo
 * @create 2018-03-06 上午10:40
 **/
public class HelloActor extends UntypedActor{
    @Override
    public void preStart() throws Exception {
        System.out.println("pre start...");
    }

    @Override
    public void postStop() throws Exception {
        System.out.println("post stop...");
    }

    @Override
    public void onReceive(Object message) throws Exception {
        System.out.println("接收到调用方法:" + JSON.toJSONString(message));
        unhandled(message);
    }
}
