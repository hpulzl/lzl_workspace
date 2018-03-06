package cn.vobile.akka.other;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import cn.vobile.akka.actor.HelloActor;

/**
 * 主函数
 *
 * @author awo
 * @create 2018-03-06 上午10:49
 **/
public class ActorSystemMain {
    public static void main(String[] args) {
        //创建ActorSystem，初始化数据.有不同的构造方法，也可以读取资源文件
        ActorSystem actorSystem = ActorSystem.create("akka-demo");
        //找到具体执行那一个actor
        ActorRef actorRef = actorSystem.actorOf(Props.create(HelloActor.class));
        //发送actor传递的数据
        actorRef.tell("hello",ActorRef.noSender());
    }
}
