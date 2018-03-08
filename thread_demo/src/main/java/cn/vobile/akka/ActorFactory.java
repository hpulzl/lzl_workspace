package cn.vobile.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.typesafe.config.ConfigFactory;

/**
 * 创建actor的工厂类
 *
 * @author awo
 * @create 2018-03-06 上午11:14
 **/
public class ActorFactory {
    private static final ActorFactory ME = new ActorFactory();
    private static final ActorSystem SYSTEM = ActorSystem.create("messageSystem");
    private ActorFactory(){

    }

    public static ActorFactory getInstance(){
        return ME;
    }

    public static ActorSystem getSYSTEM() {
        return SYSTEM;
    }

    public ActorRef create(Class clazz){
        return SYSTEM.actorOf(Props.create(clazz));
    }

    public ActorRef create(Class clazz,String message){
        return SYSTEM.actorOf(Props.create(clazz),message);
    }

    public ActorRef create(Class clazz,ActorRef actorRef,String message){
        return SYSTEM.actorOf(Props.create(clazz,actorRef),message);
    }

    public ActorSelection actorSelection(String path){
        return SYSTEM.actorSelection(path);
    }

    public void shutdown(){
        SYSTEM.shutdown();
    }
}
